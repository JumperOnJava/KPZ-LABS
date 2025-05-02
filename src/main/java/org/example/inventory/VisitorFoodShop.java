package org.example.inventory;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;

public class VisitorFoodShop implements FoodProvider{
    FoodProvider parentFoodProvider;

    public VisitorFoodShop(FoodProvider parentFoodProvider) {
        this.parentFoodProvider = parentFoodProvider;
    }

    @Override
    public void takeFood(FoodType food, float amount) throws InsufficientResourcesException {
        try{
            parentFoodProvider.takeFood(food, amount);
        }
        catch(InsufficientResourcesException e){
            System.out.printf("Visitor unable to take %s of %s%n", amount, food.getName());
            return;
        }
        System.out.printf("Visitor took %s of %s%n", amount, food.getName());
    }
}
