package org.example.task5;

import org.example.task5.events.Event;
import org.example.task5.events.HoverEvent;

public abstract class LightNode {
    public abstract String outerHTML();
    public abstract String innerHTML();

    public Event<HoverEvent> onHover = new Event<HoverEvent>();
    void hoverEvent(boolean isOverElement, int x, int y) {
        onHover.publish(new HoverEvent(isOverElement, x, y));
    }
}

