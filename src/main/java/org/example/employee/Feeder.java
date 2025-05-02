package org.example.employee;

import org.example.animal.Animal;
import org.example.inventory.FoodType;
import org.example.inventory.FoodProvider;

import javax.naming.InsufficientResourcesException;

public interface Feeder {
    String getFeederName();
    default void FeedAnimal(FoodProvider foodProvider, Animal animal, FoodType food, float amount) throws InsufficientResourcesException {
        try{
            foodProvider.takeFood(food,amount);
        }
        catch (InsufficientResourcesException e){
            System.out.printf("not enough %d to take ", food.getName());
            throw e;
        }
        System.out.printf("%s feeded %s %s with %f of %s%n ", getFeederName(), animal.getSpecies(), animal.getName(), amount, food.getName());
    }
}
