package org.example.animal;

import org.example.inventory.FoodType;
import org.example.inventory.FoodTypes;

public class Dolphin extends WaterAnimal{
    public Dolphin(String name) {
        super(name, "Dolphin",  120,3);
    }

    @Override
    public FoodType getDiet() {
        return FoodTypes.FISH;
    }

    @Override
    public void makeSound() {
        System.out.println("Squeak!");
    }
}
