package org.example.animal;

import org.example.inventory.FoodType;

public abstract class GenericAnimal implements Animal {
    private String name;
    private String species;

    @Override
    public void eat(FoodType food, float amount) {
        if(food.equals(getDiet())){
            System.out.printf("%s %s ate %f of %s%n", this.getSpecies(), this.getName(), amount, food.getName());
        }
        else {
            System.out.printf("%s %s doesn't eat %s", this.getSpecies(), this.getName(), food.getName());
        }
    }

    public GenericAnimal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() { return name; }
    public String getSpecies() { return species; }
}
