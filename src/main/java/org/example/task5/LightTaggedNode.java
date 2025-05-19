package org.example.task5;


import org.example.task5.events.ClickEvent;
import org.example.task5.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LightTaggedNode extends LightNode {
    protected final String tagName;
    protected final List<String> cssClasses = new ArrayList<>();
    protected final List<LightNode> children = new ArrayList<>();

    public Event<ClickEvent> onClick = new Event<ClickEvent>();

    public LightTaggedNode(String tagName) {
        this.tagName = tagName;
    }

    public void addClass(String cssClass) {
        cssClasses.add(cssClass);
    }

    @Override
    public String innerHTML() {
        return "";
    }

    @Override
    public String outerHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName);

        if (!cssClasses.isEmpty()) {
            sb.append(" class=\"");
            StringJoiner joiner = new StringJoiner(" ");
            cssClasses.forEach(joiner::add);
            sb.append(joiner).append("\"");
        }

        sb.append("/>");

        return sb.toString();
    }

    void clickEvent(boolean mousePressed, int button, int x, int y) {
        onClick.publish(new ClickEvent(mousePressed, button, x, y));
    }
}
