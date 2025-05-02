package org.example.employee;

import org.example.inventory.FoodType;
import org.example.inventory.FoodProvider;
import org.example.inventory.Warehouse;

public class Director extends GenericEmployee {

    public Director(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "Director";
    }

    @Override
    public float getSalary() {
        return 25000f;
    }

    public void OrderFood(Warehouse warehouse, FoodType foodType, float amount) {
        System.out.printf("Director ordered %s of %s%n", amount, foodType.getName());
        warehouse.addFood(foodType, amount);
    }
}
