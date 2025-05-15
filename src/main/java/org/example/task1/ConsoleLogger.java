package org.example.task1;

public class ConsoleLogger implements Logger {

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[31m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[32m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[33m";

    String name;

    public ConsoleLogger(String name) {
        this.name = name;
    }

    @Override
    public void info(String message) {
        System.out.printf("%s%s : %s%n", ANSI_GREEN_BACKGROUND, name, message);
        resetColor();
    }

    @Override
    public void warning(String message) {
        System.out.printf("%s%s : %s%n", ANSI_YELLOW_BACKGROUND, name, message);
        resetColor();
    }

    @Override
    public void error(String message) {
        System.out.printf("%s%s : %s%n", ANSI_RED_BACKGROUND, name, message);
        resetColor();
    }

    protected void resetColor() {
        System.out.println(ANSI_BLACK_BACKGROUND);
    }
}
