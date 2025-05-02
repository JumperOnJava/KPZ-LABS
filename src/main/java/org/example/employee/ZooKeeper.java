package org.example.employee;

import org.example.animal.Animal;
import org.example.inventory.FoodType;
import org.example.inventory.FoodProvider;

public class ZooKeeper extends GenericEmployee implements Feeder {
    private String name;

    public ZooKeeper(String name) {
        super(name);
    }

    public String getRole() { return "ZooKeeper"; }

    @Override
    public float getSalary() {
        return 10000f;
    }

    @Override
    public String getFeederName() {
        return "%s %s".formatted(getRole(), getName());
    }
}
