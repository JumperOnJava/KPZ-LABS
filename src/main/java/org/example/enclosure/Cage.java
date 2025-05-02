package org.example.enclosure;

import org.example.animal.GroundAnimal;

import javax.naming.InsufficientResourcesException;

public class Cage extends GenericEnclosure<GroundAnimal> {
    public Cage(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getType() {
        return "Cage";
    }

    @Override
    public void addAnimal(GroundAnimal animal) throws InsufficientResourcesException {
        var volumeTaken = this.getAnimals().stream().map(a -> ((GroundAnimal)a).getPersonalArea()).reduce(Float::sum).orElse(0f);
        if(volumeTaken + animal.getPersonalArea() > surfaceArea) {
            throw new InsufficientResourcesException("Not enough area in cage for " + animal.getSpecies());
        }
        super.addAnimal(animal);
    }

    public float surfaceArea;

    public float getSurfaceArea() {
        return surfaceArea;
    }

}

