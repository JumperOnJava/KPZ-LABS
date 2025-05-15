package org.example.task2.hero;

import org.example.task2.Heroes.GenericHero;

public class Warrior extends GenericHero {
    public Warrior(String name) {
        super(name);
    }

    @Override
    public String getClassName() {
        return "Warrior";
    }

    @Override
    public int getDefence() {
        return 4;
    }

    @Override
    public int getAttack() {
        return 7;
    }

    @Override
    public int getSpeed() {
        return 5;
    }
}
