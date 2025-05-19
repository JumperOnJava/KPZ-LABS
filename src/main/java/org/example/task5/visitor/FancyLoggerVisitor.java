package org.example.task5.visitor;

import org.example.task5.LightNode;
import org.example.task5.LightParentNode;
import org.example.task5.LightTaggedNode;
import org.example.task5.LightTextNode;
import org.example.task5.images.ImageNode;

import java.util.Arrays;

public class FancyLoggerVisitor implements Visitor {
    int depth = 0;
    @Override
    public void visitUnknownNode(LightNode node) {
        System.out.printf(
                ":\t".repeat(depth)+
                        "|Unknown node:%n"+":\t".repeat(depth)+
                        "'---," +
                        "%n%s%n"+"\t".repeat(depth)
                        +",---'%n", String.join("\n",Arrays.stream(node.outerHTML().split("\n")).map(s->":\t".repeat(depth+1)+"| "+s).toList()));  }

    @Override
    public void visitImageNode(ImageNode node) {
        System.out.printf(
                ":\t".repeat(depth)+
                "|Image %s:%n"+":\t".repeat(depth)+
                "'---," +
                        "%n%s%n"+"\t".repeat(depth)
                        +",---'%n", node.getImageAddress(), String.join("\n",Arrays.stream(node.innerHTML().split("\n")).map(s->":\t".repeat(depth+1)+"| "+s).toList()));
    }

    @Override
    public void visitTextNode(LightTextNode node) {
        System.out.printf(":\t".repeat(depth)+"|Text: %s%n", node.innerHTML());
    }

    @Override
    public void visitTaggedNode(LightTaggedNode node) {
        System.out.printf(":\t".repeat(depth)+"|HTML %s tag: %s%n", node.getTag(), node.getCssClasses());
    }

    @Override
    public void visitParentNode(LightParentNode node) {
        System.out.printf(":\t".repeat(depth)+"|HTML %s tag %s with %s children:\n", node.getTag(), node.getCssClasses(), node.getChildCount());
        if(node.getChildCount() > 0) {
            System.out.printf(":\t".repeat(depth)+"'---,\n");
        }
        depth++;
        node.getChildren().forEach(child -> child.accept(this));
        depth--;
        if(node.getChildCount() > 0) {
            System.out.printf(":\t".repeat(depth)+",---'\n");
        }
    }
}
