package org.example.task6;

import org.example.task1.ConsoleLogger;
import org.example.task1.FileOutputWriter;
import org.example.task5.LightElementNode;
import org.example.task5.LightNode;
import org.example.task5.LightTextNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Function;

public class Task6 {

    public static void Main() throws IOException {
        new FileOutputWriter("parseCached.txt").write(parseFile(new LightNodeFactory()));
        new FileOutputWriter("parseUncached.txt").write(parseFile(new LightNodeFactory(){
            @Override
            public LightNode createLightNode(LightNode originalNode) {
                return originalNode;
            }
            @Override
            public void clear() {
            }
        }));

        var parsedfile1 = Files.readAllLines(Path.of("parseCached.txt"));
        var parsedfile2 = Files.readAllLines(Path.of("parseUncached.txt"));
        System.out.println("Two files are equal? Result: "+ Objects.equals(parsedfile1, parsedfile2));
        Files.deleteIfExists(Path.of("parseCached.txt"));
        Files.deleteIfExists(Path.of("parseUncached.txt"));
    }
    public static String parseFile(LightNodeFactory lightNodeFactory) throws IOException {
        printUsedMemory("Start");
        printUsedMemory("Before reading file");
        var file = Files.readAllLines(Path.of("book.txt"));
        printUsedMemory("After reading file");
        var rootNode = new LightElementNode("body");

        //repeat 1000 times to memory save to be more visible
        for (int j = 0; j < 100; j++) {

            for (int i = 0; i < file.size(); i++) {
                var line = file.get(i);
                LightNode textNode = new LightTextNode(line);


                if (i != 0) {
                    if (line.startsWith(" ")) {
                        var blockquoteNode = new LightElementNode("blockquote");
                        blockquoteNode.addChild(textNode);
                        textNode = blockquoteNode;
                    } else if (line.length() < 20) {
                        var h2Node = new LightElementNode("h2");
                        h2Node.addChild(textNode);
                        textNode = h2Node;
                    } else {
                        var pNode = new LightElementNode("p");
                        pNode.addChild(textNode);
                        textNode = pNode;
                    }

                } else {
                    var text = new LightElementNode("h1");
                    text.addChild(textNode);
                }

                rootNode.addChild(lightNodeFactory.createLightNode(textNode));
                rootNode.addChild(lightNodeFactory.createLightNode(textNode));

            }
        }
        lightNodeFactory.clear();

        printUsedMemory("After parsing file");

        return rootNode.outerHTML();

    }

    public static void printUsedMemory(String moment) {
        System.gc();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Runtime runtime = Runtime.getRuntime();

        long usedMemory = runtime.totalMemory() - runtime.freeMemory();

        double usedMemoryKB = usedMemory / (1024.0);

        System.out.printf(moment + ": %.2f KB%n", usedMemoryKB);
    }
}
