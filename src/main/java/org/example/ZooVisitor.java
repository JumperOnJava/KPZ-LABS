package org.example;

import org.example.animal.Animal;
import org.example.employee.Feeder;
import org.example.inventory.FoodProvider;
import org.example.inventory.FoodType;

import javax.naming.InsufficientResourcesException;

public class ZooVisitor implements Feeder {
    @Override
    public String getFeederName() {
        return "Unknown visitor %d".formatted(hashCode());
    }

    @Override
    public void FeedAnimal(FoodProvider foodProvider, Animal animal, FoodType food, float amount) {
        try {
            foodProvider.takeFood(food, amount);
        } catch (InsufficientResourcesException e) {
            throw new RuntimeException(e);
        }

    }
}
