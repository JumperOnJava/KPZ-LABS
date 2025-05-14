package org.example.task5;

import java.util.ArrayList;
import java.util.List;

public class Enemy implements Character {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_POWER = 1;
    private static final int INDEX_REPUTATION = 2;
    private static final int INDEX_ACTIONS = 3;

    //i changed how this object stores data to have different implementation with similar functionality;
    private final Object[] data;

    public Enemy(Object[] data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return (String) data[INDEX_NAME];
    }

    @Override
    public float getReputation() {
        return (float) data[INDEX_REPUTATION];
    }

    @Override
    public void changeReputation(float change) {
        data[INDEX_REPUTATION] = (float) data[INDEX_REPUTATION] + change;
    }

    @Override
    public String getFaction() {
        return "Evil";
    }

    @Override
    public int getPower() {
        return (int) data[INDEX_POWER];
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getActions() {
        return (List<String>) data[INDEX_ACTIONS];
    }

    @Override
    public void doAction() {
        List<String> actions = getActions();
        int index = (int) (Math.random() * actions.size());
        String action = actions.get(index);
        System.out.printf("%s done bad action: %s%n", getName(), action);
    }

    @Override
    public void printInfo() {
        System.out.println("ENEMY:%n");
        Character.super.printInfo();
    }

    static class EnemyBuilder implements CharacterBuilder<Enemy> {

        private final Object[] data = new Object[4];

        @Override
        public CharacterBuilder<Enemy> name(String name) {
            data[INDEX_NAME] = name;
            return this;
        }

        @Override
        public CharacterBuilder<Enemy> power(int power) {
            data[INDEX_POWER] = power;
            return this;
        }

        @Override
        public CharacterBuilder<Enemy> reputation(float reputation) {
            data[INDEX_REPUTATION] = reputation;
            return this;
        }

        @SuppressWarnings("unchecked")
        @Override
        public CharacterBuilder<Enemy> action(String action) {
            if (data[INDEX_ACTIONS] == null) {
                data[INDEX_ACTIONS] = new ArrayList<String>();
            }
            ((List<String>) data[INDEX_ACTIONS]).add(action);
            return this;
        }

        @Override
        public Enemy build() {
            return new Enemy(data);
        }
    }
}
