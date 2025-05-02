package org.example.inventory;

public class FoodType {
    private final String name;

    public String getName() {
        return name;
    }

    public boolean equals(FoodType food) {
        return food.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public FoodType(String name) {
        this.name = name;
    }
}

