package org.example.task5;


import org.example.task5.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class LightParentNode extends LightTaggedNode {
    public List<LightNode> getChildren() {
        return new ArrayList<>(children);
    }
    private final List<LightNode> children = new ArrayList<>();


    public LightParentNode(String tagName) {
        super(tagName);
    }

    public void addChild(LightNode child) {
        children.add(child);
    }

    public int getChildCount() {
        return children.size();
    }

    @Override
    public String innerHTML() {
        StringBuilder sb = new StringBuilder();
        for (LightNode child : children) {
            sb.append(child.outerHTML());
        }
        return sb.toString();
    }

    @Override
    protected String finishOpeningTag() {
        return ">";
    }

    @Override
    protected String closingTag() {
        return "</" + tagName + ">";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParentNode(this);
    }
}
