package org.example.task5;

import org.example.task5.events.Event;
import org.example.task5.events.HoverEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class LightNode {
    public abstract String outerHTML();
    public abstract String innerHTML();

    public List<LightNode> getChildren() {
        return List.of();
    }
    public int getChildCount() {
        return 0;
    }


    public Event<HoverEvent> onHover = new Event<HoverEvent>();
    void hoverEvent(boolean isOverElement, int x, int y) {
        onHover.publish(new HoverEvent(isOverElement, x, y));
    }
}

