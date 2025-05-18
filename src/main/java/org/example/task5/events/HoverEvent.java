package org.example.task5.events;

/**
 * @param isOverElement specifies if cursor is over object. False if cursor moved away from object
 * @param x mouseX relative to left edge
 * @param y mouseY relative to top edge
 */
public record HoverEvent(boolean isOverElement, int x, int y) {

}
