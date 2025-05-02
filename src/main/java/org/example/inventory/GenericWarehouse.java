package org.example.inventory;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;

public class GenericWarehouse implements Warehouse {

    HashMap<FoodType,Float> foodStorage = new HashMap<>();
    @Override
    public void takeFood(FoodType food, float amount) throws InsufficientResourcesException{
        var newAmount = foodStorage.getOrDefault(food, 0.0f) - amount;
        if(newAmount < 0){
            throw new InsufficientResourcesException("Not enough food to consume");
        }
        foodStorage.put(food, newAmount);
    }

    public HashMap<FoodType, Float> getInventory() {
        return foodStorage;
    }

    public void addFood(FoodType food, float amount) {
        System.out.printf("Added %s of %s%n", amount, food.getName());
        var newAmount = foodStorage.getOrDefault(food, 0.0f) + amount;
        foodStorage.put(food, newAmount);
    }
}
