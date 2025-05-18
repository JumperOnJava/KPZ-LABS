package org.example.task5.events;

/**
 * @param mousePressed specifies if cursor is over object. False if cursor moved away from object
 * @param button 1 - left, 2 - right, 3 - wheel, 4+ other buttons
 * @param x mouseX relative to left edge
 * @param y mouseY relative to top edge
 */
public record ClickEvent(boolean mousePressed, int button, int x, int y) {

}
