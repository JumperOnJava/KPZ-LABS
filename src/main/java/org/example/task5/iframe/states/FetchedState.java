package org.example.task5.iframe.states;

import org.example.task5.LightParentNode;
import org.example.task5.LightTextNode;
import org.example.task5.iframe.IFrameNode;

public class FetchedState extends LightParentNode implements State {
    private IFrameNode context;

    public FetchedState(String childHtml) {
        super("iframe");
        addChild(new LightTextNode(childHtml));
    }

    @Override
    public void setContext(IFrameNode node) {
        this.context = node;
    }

    @Override
    protected String properties() {
        return " state=\"fetched\" url=\"%s\" ".formatted(context.getUrl());
    }

    @Override
    public void reload() {
        var newState = new DownloadingState();
        newState.setContext(context);
        context.setCurrentState(newState);
    }
}
