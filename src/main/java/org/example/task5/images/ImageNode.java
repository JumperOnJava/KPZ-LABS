package org.example.task5.images;

import org.example.task5.LightNode;
import org.w3c.dom.Node;

public class ImageNode extends LightNode {
    private final String imageAddress;
    private final ImageContext context;

    public ImageNode(String imageAddress, ImageContext context) {
        this.imageAddress = imageAddress;
        this.context = context;
    }

    @Override
    public String outerHTML() {
        return "<image>\n"+innerHTML()+"\n</image>";
    }

    @Override
    public String innerHTML() {
        return context.executeStrategy(imageAddress);
    }
}
