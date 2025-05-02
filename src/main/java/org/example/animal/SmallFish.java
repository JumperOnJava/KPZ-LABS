package org.example.animal;

import org.example.inventory.FoodType;
import org.example.inventory.FoodTypes;

public class SmallFish extends WaterAnimal{
    public SmallFish(String name) {
        super(name, "Small fish", 0.125f,0.2f);
    }

    @Override
    public FoodType getDiet() {
        return FoodTypes.ALGAE;
    }

    @Override
    public void makeSound() {
        //fish doesn't make sound
    }
}
