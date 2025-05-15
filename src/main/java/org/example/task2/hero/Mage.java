package org.example.task2.hero;

import org.example.task2.Heroes.GenericHero;

public class Mage extends GenericHero {
    public Mage(String name) {
        super(name);
    }

    @Override
    public String getClassName() {
        return "Mage";
    }

    @Override
    public int getDefence() {
        return 2;
    }

    @Override
    public int getAttack() {
        return 7;
    }

    @Override
    public int getSpeed() {
        return 6;
    }
}
