package org.example.task1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HomeScreen extends SupportScreen{
    @Override
    public void handle(InputStream input) throws IOException {
        System.out.println("Press enter to continue...");
        input.read();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to videogame support home screen");
        next(input);

    }
}
