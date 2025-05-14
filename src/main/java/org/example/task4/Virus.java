package org.example.task4;

import java.util.ArrayList;
import java.util.List;

public class Virus implements IVirus {
    public String name;
    public String species;
    public int weight;
    public int age;
    public List<IVirus> children;

    public Virus(String name, String species, int weight, int age, List<IVirus> children) {
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.age = age;
        this.children = new ArrayList<>(children);
    }
    public Virus(String name, String species, int weight, int age) {
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.age = age;
        this.children = new ArrayList<>();
    }

    @Override
    public void printVirusInfo(int tabLevel) {
        String tabs = "\t".repeat(tabLevel);
        System.out.println(tabs + "Name: " + name);
        System.out.println(tabs + "Species: " + species);
        System.out.println(tabs + "Age: " + age);
        System.out.println(tabs + "Weight: " + weight);
        System.out.println(tabs + "Children: ");
        if(children.isEmpty()) {
            System.out.println(tabs + "No children");
        }
        children.forEach(child -> child.printVirusInfo(tabLevel + 1));
    }

    @Override
    public Virus duplicate() {
        var newChildren = children.stream().map(IVirus::duplicate).toList();
        return new Virus(name, species, weight, age, newChildren);
    }
}
