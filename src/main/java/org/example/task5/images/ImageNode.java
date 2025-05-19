package org.example.task5.images;

import org.example.task5.LightTaggedNode;
import org.example.task5.visitor.Visitor;

public class ImageNode extends LightTaggedNode {
    private final String imageAddress;
    private final ImageContext context;

    public ImageNode(String imageAddress, ImageContext context) {
        super("image");
        this.imageAddress = imageAddress;
        this.context = context;
    }

    @Override
    protected String finishOpeningTag() {
        return ">";
    }

    @Override
    public String innerHTML() {
        return "\n"+context.executeStrategy(imageAddress)+"\n";
    }

    @Override
    protected String closingTag() {
        return "</image>";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageNode(this);
    }

    public String getImageAddress() {
        return imageAddress;
    }
}
