package org.example.task2.hero;

import org.example.task2.Heroes.GenericHero;

public class Paladin extends GenericHero {
    public Paladin(String name) {
        super(name);
    }

    @Override
    public String getClassName() {
        return "Paladin";
    }

    @Override
    public int getDefence() {
        return 8;
    }

    @Override
    public int getAttack() {
        return 6;
    }

    @Override
    public int getSpeed() {
        return 3;
    }
}
