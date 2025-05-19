package org.example.task5.iframe.states;

import org.example.task5.LightTaggedNode;
import org.example.task5.iframe.IFrameNode;

import java.nio.charset.StandardCharsets;

public class DownloadingState extends LightTaggedNode implements State {

    private IFrameNode context;

    public DownloadingState() {
        super("iframe");
    }

    @Override
    public void setContext(IFrameNode context) {
        this.context = context;

        new Thread(() -> {
            try(var in = context.getUrl().openStream()){
                Thread.sleep(1000);
                var text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                var newState = new FetchedState(text);
                newState.setContext(context);
                context.setCurrentState(newState);
            }
            catch (Exception e){
                var newState = new ErrorState(e);
                newState.setContext(context);
                context.setCurrentState(newState);
            }
        }).start();
    }

    @Override
    public void reload() {
        return;
    }

    @Override
    public String outerHTML() {
        return super.outerHTML();
    }

    @Override
    protected String properties() {
        return " state=\"fetching\" url=\"%s\" ".formatted(context.getUrl());
    }

    @Override
    public String innerHTML() {
        return "";
    }

    @Override
    public int getChildCount() {
        return 1;
    }
}
