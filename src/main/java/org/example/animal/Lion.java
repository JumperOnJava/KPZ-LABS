package org.example.animal;

import org.example.inventory.FoodType;
import org.example.inventory.FoodTypes;

public class Lion extends GroundAnimal {
    public Lion(String name) {
        super(name, "Lion", 16);
    }

    public FoodType getDiet() { return FoodTypes.MEAT; }

    public void makeSound() {
        System.out.println("Roar!");
    }
}
