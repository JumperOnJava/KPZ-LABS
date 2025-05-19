package org.example.task5.button;

import java.io.Console;

public class LogCommand implements Command{

    public LogCommand(String message) {
        this.message = message;
    }

    String message;

    @Override
    public void execute() {
        System.out.println(message);
    }
}
