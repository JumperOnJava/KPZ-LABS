package org.example.task1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class FileOutputWriter implements OutputWriter {
    private String path;

    public FileOutputWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(String text) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeLine(String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
