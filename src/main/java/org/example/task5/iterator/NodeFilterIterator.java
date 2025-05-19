package org.example.task5.iterator;

import org.example.task5.LightNode;

import java.util.ArrayList;
import java.util.List;

public abstract class NodeFilterIterator<TFilter> implements Iterator<LightNode> {
    protected final List<LightNode> matchNodes = new ArrayList<>();
    private int currentIndex = 0;

    NodeFilterIterator(LightNode node, TFilter filter) {
        List<LightNode> tempNodes = List.of(node);
        List<LightNode> nextList = new ArrayList<>();
        while (!tempNodes.isEmpty()) {
            for (LightNode tempNode : tempNodes) {
                if(matches(tempNode, filter)) {
                    matchNodes.add(tempNode);
                }
                nextList.addAll(tempNode.getChildren());
            }
            tempNodes = nextList;
            nextList = new ArrayList<>();
        }
    }

    public abstract boolean matches(LightNode node, TFilter filter);

    @Override
    public boolean hasNext() {
        return currentIndex < matchNodes.size();
    }

    @Override
    public LightNode next() {
        return matchNodes.get(currentIndex++);
    }
}
