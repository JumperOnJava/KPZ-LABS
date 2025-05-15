package org.example.task1;


public class OutputLogger implements Logger {

    public OutputLogger(OutputWriter target) {
        this.target = target;
    }

    OutputWriter target;

    @Override
    public void info(String message) {
        target.writeLine("[INFO] %s".formatted(message));
    }

    @Override
    public void warning(String message) {
        target.writeLine("[WARN] %s".formatted(message));
    }

    @Override
    public void error(String message) {
        target.writeLine("[ERR] %s".formatted(message));

    }
}
