package org.example.task5.visitor;

import org.example.task5.LightNode;
import org.example.task5.LightParentNode;
import org.example.task5.LightTaggedNode;
import org.example.task5.LightTextNode;
import org.example.task5.iframe.IFrameNode;
import org.example.task5.images.ImageNode;

import java.util.ArrayList;
import java.util.List;

public class JsonLoggerVisitor implements Visitor {
    private final List<String> elements = new ArrayList<>();


    public String resultJson() {
        return "[" + String.join(", ", elements) + "]";
    }

    @Override
    public void visitUnknownNode(LightNode node) {
        elements.add("{\"unknown_html\": " + jsonCompatibleString(node.outerHTML()) + "}");
    }

    @Override
    public void visitImageNode(ImageNode node) {
        elements.add("{\"image_id\": " + jsonCompatibleString(node.getImageAddress()) + "}");
    }

    @Override
    public void visitTextNode(LightTextNode node) {
        elements.add("{\"text\": " + jsonCompatibleString(node.innerHTML()) + "}");
    }

    @Override
    public void visitTaggedNode(LightTaggedNode node) {
        elements.add(String.format(
                "{\"tag\": %s, \"css_classes\": %s}",
                jsonCompatibleString(node.getTag()),
                toJsonArray(node.getCssClasses())
        ));
    }

    @Override
    public void visitParentNode(LightParentNode node) {
        List<String> childJsons = new ArrayList<>();
        for (LightNode child : node.getChildren()) {
            JsonLoggerVisitor childVisitor = new JsonLoggerVisitor();
            child.accept(childVisitor);
            childJsons.addAll(childVisitor.elements);
        }
        elements.add(String.format(
                "{\"tag\": %s, \"css_classes\": %s, \"children\": [%s]}",
                jsonCompatibleString(node.getTag()),
                toJsonArray(node.getCssClasses()),
                String.join(", ", childJsons)
        ));
    }

    private String jsonCompatibleString(String text) {
        return "\"" + text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r") + "\"";
    }

    private String toJsonArray(List<String> list) {
        return "[%s]".formatted(String.join(", ", list.stream().map(this::jsonCompatibleString).toList()));
    }

}
