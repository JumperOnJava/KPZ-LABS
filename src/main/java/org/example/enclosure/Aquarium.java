package org.example.enclosure;

import org.example.animal.WaterAnimal;

import javax.naming.InsufficientResourcesException;

public class Aquarium extends GenericEnclosure<WaterAnimal> {
    public Aquarium(float volume, float depth) {
        this.volume = volume;
        this.depth = depth;
    }

    public String getType() {
        return "Aquarium";
    }

    @Override
    public void addAnimal(WaterAnimal animal) throws InsufficientResourcesException{
        if(animal.getMinimalDepth() > depth){
            throw new InsufficientResourcesException("Depth in aquarium is too low for this animal (%s)".formatted(animal.getSpecies()));
        }

        var volumeTaken = this.getAnimals().stream().map(a -> ((WaterAnimal)a).getPersonalVolume()).reduce(Float::sum).orElse(0f);
        if(volumeTaken + animal.getPersonalVolume() > volume){
            throw new InsufficientResourcesException("Not enough volume in aquarium for this animal (%s)".formatted(animal.getSpecies()));
        }
        super.addAnimal(animal);
    }

    public float volume;
    public float depth;

    public float getVolume() {
        return volume;
    }
    public float getDepth() {
        return volume;
    }
}

