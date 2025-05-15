package org.example.task2;

public interface Hero {
    String getName();

    String getClassName();

    int getDefence();

    int getAttack();

    int getSpeed();

    default void printDescription() {
        System.out.printf("Name: %s [%s]%n", getName(), getClassName());
        System.out.printf("\tDefence: %2d %s%n", getDefence(),"#".repeat(getDefence()));
        System.out.printf("\t Attack: %2d %s%n", getAttack(),"#".repeat(getAttack()));
        System.out.printf("\t  Speed: %2d %s%n", getSpeed(),"#".repeat(getSpeed()));
        System.out.print("\n");
    }
}
