package org.example.task5.visitor;

import org.example.task5.LightNode;
import org.example.task5.LightParentNode;
import org.example.task5.LightTaggedNode;
import org.example.task5.LightTextNode;
import org.example.task5.iframe.IFrameNode;
import org.example.task5.images.ImageNode;

public interface Visitor {
    void visitUnknownNode(LightNode node);
    void visitImageNode(ImageNode node);
    void visitTextNode(LightTextNode node);
    void visitTaggedNode(LightTaggedNode node);
    void visitParentNode(LightParentNode node);

}
