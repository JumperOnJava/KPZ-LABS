package org.example.task5;


import org.example.task5.events.ClickEvent;
import org.example.task5.events.Event;
import org.example.task5.events.HoverEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LightElementNode extends LightNode {
    private final String tagName;
    private final List<String> cssClasses = new ArrayList<>();
    private final List<LightNode> children = new ArrayList<>();

    public Event<ClickEvent> onClick = new Event<ClickEvent>();

    public LightElementNode(String tagName) {
        this.tagName = tagName;
    }

    public void addClass(String cssClass) {
        cssClasses.add(cssClass);
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
    public String outerHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName);

        if (!cssClasses.isEmpty()) {
            sb.append(" class=\"");
            StringJoiner joiner = new StringJoiner(" ");
            for (String cls : cssClasses) {
                joiner.add(cls);
            }
            sb.append(joiner).append("\"");
        }

        sb.append(">");
        sb.append(innerHTML());
        sb.append("</").append(tagName).append(">");

        return sb.toString();
    }

    void clickEvent(boolean mousePressed, int button, int x, int y) {
        onClick.publish(new ClickEvent(mousePressed, button, x, y));
    }
}
