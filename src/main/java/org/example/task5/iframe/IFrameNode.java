package org.example.task5.iframe;

import org.example.task5.LightNode;
import org.example.task5.visitor.Visitor;
import org.example.task5.iframe.states.DownloadingState;
import org.example.task5.iframe.states.State;

import java.net.URL;
import java.util.List;

public class IFrameNode implements LightNode {


    private URL url;

    public URL getUrl() {
        return url;
    }

    //ONLY for demo usage
    public void demo_setUrl(URL url) {
        this.url = url;
    }

    State currentState;

    public IFrameNode(URL url) {
        this.url = url;
        var fetchingState = new DownloadingState();
        fetchingState.setContext(this);
        setCurrentState(fetchingState);
    }

    public void reload(){
        currentState.reload();
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    @Override
    public String outerHTML() {
        return currentState.outerHTML();
    }

    @Override
    public String innerHTML() {
        return currentState.innerHTML();
    }

    @Override
    public List<LightNode> getChildren() {
        return currentState.getChildren();
    }

    @Override
    public int getChildCount() {
        return currentState.getChildCount();
    }
}

