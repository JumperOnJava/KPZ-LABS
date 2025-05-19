package org.example.task5;

import org.example.task5.visitor.Visitor;

public class LightTextNode extends SimpleNode {
    private final String text;

    public LightTextNode(String text) {
        this.text = text;
    }

    @Override
    public String outerHTML() {
        return text;
    }

    @Override
    public String innerHTML() {
        return text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTextNode(this);
    }
}
