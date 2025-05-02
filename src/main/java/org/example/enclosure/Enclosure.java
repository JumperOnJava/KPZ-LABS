package org.example.enclosure;

import org.example.animal.Animal;

import javax.naming.InsufficientResourcesException;
import java.util.List;

public interface Enclosure<T extends Animal> {
    String getType();
    void addAnimal(T animal) throws InsufficientResourcesException;
    List<Animal> getAnimals();
}
