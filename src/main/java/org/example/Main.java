package org.example;

import org.example.animal.Dolphin;
import org.example.animal.Lion;
import org.example.animal.Parrot;
import org.example.animal.SmallFish;
import org.example.employee.Director;
import org.example.employee.ZooKeeper;
import org.example.enclosure.Aquarium;
import org.example.enclosure.Cage;
import org.example.inventory.FoodTypes;
import org.example.inventory.GenericWarehouse;
import org.example.inventory.VisitorFoodShop;

import javax.naming.InsufficientResourcesException;

public class Main {
    public static void main(String[] args) throws InsufficientResourcesException {
        Zoo myZoo = new Zoo();

        Lion lion = new Lion("Simba");
        lion.eat(FoodTypes.MEAT, 5);
        lion.makeSound();

        Dolphin dolphin = new Dolphin("Flipper");
        dolphin.eat(FoodTypes.FISH, 10);
        dolphin.makeSound();

        Parrot parrot = new Parrot("Iago");
        parrot.eat(FoodTypes.SEEDS, 1);
        parrot.makeSound();

        SmallFish smallFish = new SmallFish("Feesh");

        Director director = new Director("Mr. Calvin");
        myZoo.director = director;
        GenericWarehouse warehouse = new GenericWarehouse();
        myZoo.foodWarehouse = warehouse;
        director.OrderFood(warehouse, FoodTypes.MEAT, 100);

        ZooKeeper zooKeeper = new ZooKeeper("John");
        myZoo.zooKeepers.add(zooKeeper);
        try {
            zooKeeper.FeedAnimal(warehouse, lion, FoodTypes.MEAT, 5);
        } catch (InsufficientResourcesException e) {
            System.out.println("Not enough food to feed the animal.");
        }
        System.out.println();

        ZooVisitor visitor = new ZooVisitor();
        try {
            visitor.FeedAnimal(new VisitorFoodShop(warehouse), parrot, FoodTypes.SEEDS, 1);
        } catch (RuntimeException e) {
            System.out.println("Not enough food to feed the animal.");
        }

        Cage cage = new Cage(100);
        myZoo.enclosures.add(cage);
        try {
            cage.addAnimal(lion);
        } catch (InsufficientResourcesException e) {
            throw new RuntimeException(e);
        }

        Aquarium aquarium = new Aquarium(200,5);
        myZoo.enclosures.add(aquarium);
        Aquarium smallAquarium = new Aquarium(5,1);

        try {
            smallAquarium.addAnimal(dolphin);
        } catch (InsufficientResourcesException e) {
            System.out.println(e.getMessage());
        }
        aquarium.addAnimal(dolphin);
        smallAquarium.addAnimal(smallFish);

        warehouse.addFood(FoodTypes.FISH, 50);
        try {
            warehouse.takeFood(FoodTypes.MEAT, 20);
        } catch (InsufficientResourcesException e) {
            System.out.println("Not enough food in warehouse.");
        }
        System.out.println("Warehouse inventory: ");
        warehouse.getInventory().forEach((k, v) -> System.out.printf("%s: %f%n", k.getName(), v));
        System.out.println();

        VisitorFoodShop foodShop = new VisitorFoodShop(warehouse);
        myZoo.visitorFoodShop = foodShop;
        try {
            foodShop.takeFood(FoodTypes.FISH, 5);
        } catch (InsufficientResourcesException e) {
            System.out.println("Not enough food in food shop.");
        }
    }
}