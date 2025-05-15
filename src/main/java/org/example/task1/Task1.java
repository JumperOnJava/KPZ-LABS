package org.example.task1;

public class Task1 {
    public static void Main() {
        var logger = new ConsoleLogger("Task1");

        var fileWriter = new FileOutputWriter("task1.txt");
        fileWriter.write("[Starting logs at:");
        fileWriter.write(String.valueOf(System.currentTimeMillis()));
        fileWriter.writeLine("]");

        var fileLogger = new OutputLogger(fileWriter);

        printLogs(logger);
        printLogs(fileLogger);
    }
    public static void printLogs(Logger logger) {
        logger.info("Printing logs");
        logger.warning("Printing warnings");
        logger.error("Printing errors");
    }
}
