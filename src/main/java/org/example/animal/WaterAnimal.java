package org.example.animal;

public abstract class WaterAnimal extends GenericAnimal {
    /**
     * In cubic meters
     */
    private float personalVolume;
    private float minimalDepth;

    public float getPersonalVolume() {
        return personalVolume;
    }
    public float getMinimalDepth() {
        return minimalDepth;
    }

    public WaterAnimal(String name, String species, float personalVolume, float minimalDepth) {
        super(name, species);
        this.personalVolume = personalVolume;
        this.minimalDepth = minimalDepth;
    }

}
