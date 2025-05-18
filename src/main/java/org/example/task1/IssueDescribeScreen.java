package org.example.task1;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

public class IssueDescribeScreen extends SupportScreen{
    @Override
    public void handle(InputStream input) {
        System.out.print("Please describe the issue: \n> ");
        var issue = new Scanner(input).nextLine();
        try {
            Desktop.getDesktop().browse(URI.create("https://www.google.com/search?q="+issue));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new OptionSelection("Have you been able to find resolution for your issue?")
                .option("Yes",()->{System.out.println("Have a nice day");})
                .option("No",()-> {System.out.println("Unfortunately we can't help you with that");next(input);})
                .select(input);
    }
}
