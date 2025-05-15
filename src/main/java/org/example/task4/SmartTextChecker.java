package org.example.task4;

import org.example.task1.ConsoleLogger;
import org.example.task1.Logger;

import java.util.List;

public class SmartTextChecker implements Reader {

    //logger from task1
    public static Logger LOGGER = new ConsoleLogger("SmartTextChecker");

    @Override
    public void open(String path) {
        LOGGER.info("Opening file");
        try {
            target.open(path);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<List<Character>> read() {
        LOGGER.info("Starting reading file");
        try {
            var data = target.read();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("Finished reading file");
        return List.of();
    }

    @Override
    public void close() {
        try {
            target.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("Closed file");
    }

    Reader target;

    public SmartTextChecker(Reader target) {
        this.target = target;
    }
}
