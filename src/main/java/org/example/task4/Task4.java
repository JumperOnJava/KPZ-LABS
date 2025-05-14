package org.example.task4;

import java.util.ArrayList;

public class Task4 {
    public static void Main() {
        var old_virus = new Virus("Old virus", "lorem ipsum",20, 40);
        var current_virus = old_virus.duplicate();
        old_virus.children.add(current_virus);

        current_virus.name = "Current virus";
        current_virus.age = 20;
        current_virus.weight = 16;

        var new_virus = current_virus.duplicate();
        current_virus.children.add(new_virus);

        new_virus.name = "New virus";
        new_virus.age = 10;
        new_virus.weight = 10;
        new_virus.species = "lorem ipsum dolor";

        System.out.println("\nOriginal virus:\n");
        old_virus.printVirusInfo();

        System.out.println("\nDuplicated virus:\n");
        old_virus.duplicate().printVirusInfo();
    }
}
