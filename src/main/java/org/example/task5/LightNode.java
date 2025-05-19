package org.example.task5;

import java.util.List;

public interface LightNode {
    String outerHTML();
    String innerHTML();

    default List<LightNode> getChildren() {
        return List.of();
    }
    default int getChildCount() {
        return 0;
    }

}
