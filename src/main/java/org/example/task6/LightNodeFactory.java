package org.example.task6;

import org.example.task5.LightNode;
import org.example.task5.LightTextNode;

import java.util.HashMap;

public class LightNodeFactory {
    HashMap<String,LightNode> nodes;
    public LightNodeFactory() {
        nodes = new HashMap<>();
    }
//    public LightTextNode createTextNode(String text) {
//        if (nodes.containsKey(text)) {
//            return nodes.get(text);
//        } else {
//            var node = new LightTextNode(text);
//            nodes.put(text, node);
//            return node;
//        }
//    }

    public LightNode createLightNode(LightNode originalNode) {
        var key = originalNode.outerHTML();
        if (nodes.containsKey(key)) {
            return nodes.get(key);
        } else {
            var node = new LightTextNode(originalNode.outerHTML());
            nodes.put(key, node);
            return node;
        }
    }

    public void clear(){
        nodes.clear();
    }
}
