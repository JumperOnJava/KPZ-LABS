package org.example.animal;

import org.example.inventory.FoodType;

public interface Animal {
    String getName();
    String getSpecies();
    FoodType getDiet();
    void eat(FoodType food, float amount);
    void makeSound();
}