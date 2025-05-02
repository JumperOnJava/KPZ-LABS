package org.example;

import org.example.employee.Employee;
import org.example.employee.ZooKeeper;
import org.example.enclosure.Enclosure;
import org.example.inventory.GenericWarehouse;
import org.example.inventory.FoodProvider;
import org.example.inventory.VisitorFoodShop;
import org.example.inventory.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    Warehouse foodWarehouse = new GenericWarehouse();
    FoodProvider visitorFoodShop = new VisitorFoodShop(foodWarehouse);
    Employee director;
    List<Employee> employees = new ArrayList<>();
    List<ZooKeeper> zooKeepers = new ArrayList<>();
    List<Enclosure<?>> enclosures = new ArrayList<>();
}
