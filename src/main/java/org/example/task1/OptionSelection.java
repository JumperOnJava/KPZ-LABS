package org.example.task1;

import org.example.Pair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionSelection {
    private final String title;

    public OptionSelection(String title) {
        this.title = title;
    }

    private final List<Pair<String,Runnable>> options = new ArrayList<>();
    public void select(InputStream stream){
        System.out.println();
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i).left;
            System.out.printf("%d) %s\n", i, option);
        }
        System.out.print("> ");
        var scanner = new Scanner(stream);
        var read = scanner.nextLine();
        try{
            var value = Integer.parseInt(read);
            options.get(value).right.run();
        }
        catch(NumberFormatException e){
            System.out.printf("Failed to parse number: %s\n", read);
        }
        catch(IndexOutOfBoundsException e){
            System.out.printf("Incorrect option: %s\n", read);
        }
    }

    public OptionSelection option(String option, Runnable runnable){
        options.add(new Pair<>(option, runnable));
        return this;
    }
}


