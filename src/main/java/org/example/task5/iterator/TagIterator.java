package org.example.task5.iterator;

import org.example.task5.LightNode;
import org.example.task5.LightTaggedNode;

import java.util.ArrayList;
import java.util.List;

public class TagIterator extends NodeFilterIterator<String> {

    public TagIterator(LightNode node, String tag) {
        super(node, tag);
    }

    @Override
    public boolean matches(LightNode node, String s) {
        return node instanceof LightTaggedNode taggedNode && taggedNode.getTag().equals(s);
    }
}
