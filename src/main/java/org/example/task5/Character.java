package org.example.task5;

import java.util.List;

public interface Character {
    String getName();

    float getReputation();

    void changeReputation(float change);

    String getFaction();

    int getPower();

    List<String> getActions();

    void doAction();

    default void printInfo() {
        System.out.println("Character: " + getName());
        System.out.println("Power: " + getPower());
        System.out.println("Faction: " + getFaction());
        System.out.println("Reputation: " + getReputation());
        System.out.println("Actions: " + getActions());
        System.out.println();
    }
}
