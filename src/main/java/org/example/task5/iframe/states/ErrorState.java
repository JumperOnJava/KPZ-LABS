package org.example.task5.iframe.states;

import org.example.task5.LightTaggedNode;
import org.example.task5.iframe.IFrameNode;

public class ErrorState extends LightTaggedNode implements State {
    private final Exception error;
    private IFrameNode context;

    public ErrorState(Exception error) {
        super("iframe");
        this.error = error;
    }

    @Override
    protected String properties() {
        return " state=\"error\" error=\"%s\" url=\"%s\" ".formatted(error.getMessage(), context.getUrl());
    }

    @Override
    public void setContext(IFrameNode node) {
        this.context = node;
    }

    @Override
    public void reload() {
        var newState = new DownloadingState();
        newState.setContext(context);
        context.setCurrentState(newState);
    }
}
