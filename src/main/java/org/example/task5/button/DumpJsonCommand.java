package org.example.task5.button;

import org.example.task5.LightNode;
import org.example.task5.visitor.JsonLoggerVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DumpJsonCommand implements Command{

    private final LightNode node;
    private final String fileName;

    public DumpJsonCommand(LightNode node, String fileName) {
        this.node = node;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        var json = new JsonLoggerVisitor();
        node.accept(json);
        try {
            Files.writeString(Path.of(fileName),json.resultJson(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
