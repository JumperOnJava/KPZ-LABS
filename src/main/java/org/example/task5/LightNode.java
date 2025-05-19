package org.example.task5;

import org.example.task5.visitor.Visitable;
import org.example.task5.visitor.Visitor;

import java.util.List;

public interface LightNode extends Visitable {
    String outerHTML();
    String innerHTML();

    default List<LightNode> getChildren() {
        return List.of();
    }
    default int getChildCount() {
        return 0;
    }

    @Override
    default void accept(Visitor visitor) {
        visitor.visitUnknownNode(this);
    }
}
