package org.example.animal;

import org.example.inventory.FoodType;
import org.example.inventory.FoodTypes;

public class Parrot extends GroundAnimal {
    public Parrot(String name) {
        super(name, "Parrot", 2);
    }

    public FoodType getDiet() { return FoodTypes.SEEDS; }

    public void makeSound() {
        System.out.println("Squawk!");
    }
}
