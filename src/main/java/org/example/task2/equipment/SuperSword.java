package org.example.task2.equipment;

import org.example.task2.Hero;

public class SuperSword extends Equipment{
    public SuperSword(Hero target) {
        super(target);
    }

    @Override
    protected int modifyDefence(int original) {
        return original;
    }

    @Override
    protected int modifyAttack(int original) {
        return original+8;
    }

    @Override
    protected int modifySpeed(int original) {
        return original;
    }
}
