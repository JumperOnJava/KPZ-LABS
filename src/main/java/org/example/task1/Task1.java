package org.example.task1;

import java.io.IOException;

public class Task1 {
    public static void Main() {
        var homeScreen = new HomeScreen();
        var initScreen = new InitScreen();
        var troubleshootScreen = new TroubleshootScreen();
        var supportScreen = new IssueDescribeScreen();

        homeScreen.setNext(initScreen);
        initScreen.setNext(troubleshootScreen);
        troubleshootScreen.setNext(supportScreen);
        supportScreen.setNext(homeScreen);

        while (true) {
            try {
                homeScreen.handle(System.in);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
