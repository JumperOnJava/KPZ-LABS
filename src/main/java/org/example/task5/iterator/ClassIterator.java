package org.example.task5.iterator;

import org.example.task5.LightNode;
import org.example.task5.LightTaggedNode;

public class ClassIterator extends NodeFilterIterator<String> {

    public ClassIterator(LightTaggedNode root, String tag) {
        super(root,tag);
    }

    @Override
    public boolean matches(LightNode node, String s) {
        return node instanceof LightTaggedNode taggedNode && taggedNode.getCssClasses().contains(s);
    }
}
