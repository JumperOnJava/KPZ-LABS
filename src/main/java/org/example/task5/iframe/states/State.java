package org.example.task5.iframe.states;

import org.example.task5.LightNode;
import org.example.task5.iframe.IFrameNode;

public interface State extends LightNode {
    void setContext(IFrameNode node);
    void reload();
}
