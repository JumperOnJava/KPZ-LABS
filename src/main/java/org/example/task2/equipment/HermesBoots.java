package org.example.task2.equipment;

import org.example.task2.Hero;

public class HermesBoots extends Equipment{
    public HermesBoots(Hero target) {
        super(target);
    }

    @Override
    protected int modifyDefence(int original) {
        return original-2;
    }

    @Override
    protected int modifyAttack(int original) {
        return original-2;
    }

    @Override
    protected int modifySpeed(int original) {
        return original+6;
    }
}
