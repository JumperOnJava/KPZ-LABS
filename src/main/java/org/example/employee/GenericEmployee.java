package org.example.employee;

import org.example.animal.Animal;
import org.example.inventory.FoodType;

public abstract class GenericEmployee implements Employee {

    private final String name;

    public GenericEmployee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public abstract String getRole();
    public abstract float getSalary();
}
