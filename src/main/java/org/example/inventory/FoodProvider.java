package org.example.inventory;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;

public interface FoodProvider {
    void takeFood(FoodType food, float amount) throws InsufficientResourcesException;
}
