package org.example.animal;

public abstract class GroundAnimal extends GenericAnimal {
    /**
     * In square meters
     */
    private float personalArea;

    public float getPersonalArea() {
        return personalArea;
    }

    public GroundAnimal(String name, String species, float personalArea) {
        super(name, species);
        this.personalArea = personalArea;
    }
}
