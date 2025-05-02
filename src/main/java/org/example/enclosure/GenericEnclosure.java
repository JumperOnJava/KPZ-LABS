package org.example.enclosure;

import org.example.animal.Animal;
import org.example.animal.WaterAnimal;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public abstract class GenericEnclosure<T extends Animal> implements Enclosure<T> {
    private final List<T> animals = new ArrayList<>();


    public abstract String getType();

    @Override
    public void addAnimal(T animal) throws InsufficientResourcesException {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals.stream().map(a -> (Animal) a).collect(Collectors.toList());
    }
}
