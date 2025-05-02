package org.example.inventory;

import java.util.HashMap;

public interface Warehouse extends FoodProvider{
    HashMap<FoodType, Float> getInventory();
    void addFood(FoodType food, float amount);
}
