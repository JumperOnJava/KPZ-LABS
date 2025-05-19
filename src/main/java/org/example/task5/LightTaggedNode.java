package org.example.task5;


import org.example.task5.events.ClickEvent;
import org.example.task5.events.Event;
import org.example.task5.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LightTaggedNode extends SimpleNode {
    protected final String tagName;

    public String getTag() {
        return tagName;
    }

    public List<String> getCssClasses() {
        return cssClasses;
    }

    protected final List<String> cssClasses = new ArrayList<>();

    public Event<ClickEvent> onClick = new Event<ClickEvent>();

    public LightTaggedNode(String tagName) {
        this.tagName = tagName;
    }

    public void addClass(String cssClass) {
        cssClasses.add(cssClass);
    }


    @Override
    public String outerHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append(startOpeningTag());
        sb.append(properties());
        sb.append(classes());
        sb.append(finishOpeningTag());
        sb.append(innerHTML());
        sb.append(closingTag());

        return sb.toString();
    }

    @Override
    public String innerHTML() {
        return "";
    }

    protected String properties(){
        return "";
    }

    protected String finishOpeningTag() {
        return "/>";
    }

    protected String startOpeningTag(){
        return "<" + tagName;
    }

    protected String classes(){
        StringBuilder sb = new StringBuilder();
        if (!cssClasses.isEmpty()) {
            sb.append(" class=\"");
            StringJoiner joiner = new StringJoiner(" ");
            cssClasses.forEach(joiner::add);
            sb.append(joiner).append("\"");
        }
        return sb.toString();
    }

    protected String closingTag(){
        return "";
    }

    void clickEvent(boolean mousePressed, int button, int x, int y) {
        onClick.publish(new ClickEvent(mousePressed, button, x, y));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTaggedNode(this);
    }
}
