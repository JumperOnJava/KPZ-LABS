package org.example.task5.iterator;

import org.example.task5.LightNode;

import java.util.Stack;

public class DFSIterator implements Iterator<LightNode> {

    private Stack<LightNode> stack = new Stack<>();

    public DFSIterator(LightNode root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public LightNode next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }

        var current = stack.pop();

        for (var i = current.getChildCount() - 1; i >= 0; i--) {
            stack.push(current.getChildren().get(i));
        }

        return current;
    }
}
