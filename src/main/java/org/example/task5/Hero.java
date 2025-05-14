package org.example.task5;

import java.io.Console;
import java.lang.invoke.MethodType;
import java.time.chrono.HijrahEra;
import java.util.ArrayList;
import java.util.List;

public class Hero implements Character {

    private final String name;
    private int power;
    private float reputation;
    private final List<String> actions;

    public Hero(String name, int power, float reputation, List<String> actions) {
        this.name = name;
        this.power = power;
        this.reputation = reputation;
        this.actions = actions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getReputation() {
        return reputation;
    }

    @Override
    public void changeReputation(float change) {
        reputation += change;
    }

    @Override
    public String getFaction() {
        return "Good";
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public List<String> getActions() {
        return actions;
    }

    @Override
    public void doAction() {
        var index = (int) (Math.random() * actions.size());
        var action = actions.get(index);
        System.out.printf("%s done good action: %s%n",name,action);
    }

    @Override
    public void printInfo() {
        System.out.println("HERO:");
        Character.super.printInfo();
    }



    static class HeroBuilder implements CharacterBuilder<Hero>{

        private String name;
        private int power;
        private float reputation;
        private List<String> actions = new ArrayList<>();

        @Override
        public CharacterBuilder<Hero> name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public CharacterBuilder<Hero> power(int power) {
            this.power = power;
            return this;
        }

        @Override
        public CharacterBuilder<Hero> reputation(float reputation) {
            this.reputation = reputation;
            return this;
        }

        @Override
        public CharacterBuilder<Hero> action(String action) {
            this.actions.add(action);
            return this;
        }

        @Override
        public Hero build() {
            return new Hero(name, power, reputation, actions);
        }
    }
}
