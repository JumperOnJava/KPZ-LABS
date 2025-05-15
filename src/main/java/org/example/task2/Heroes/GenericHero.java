package org.example.task2.Heroes;

import org.example.task2.Hero;

public abstract class GenericHero implements Hero {

    public GenericHero(String name) {
        this.name = name;
    }

    String name;

    @Override
    public String getName() {
        return name;
    }
}
