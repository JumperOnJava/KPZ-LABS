package org.example.task2.equipment;

import org.example.task2.Hero;

public class IronArmor extends Equipment{
    public IronArmor(Hero target) {
        super(target);
    }

    @Override
    protected int modifyDefence(int original) {
        return original+6;
    }

    @Override
    protected int modifyAttack(int original) {
        return original;
    }

    @Override
    protected int modifySpeed(int original) {
        return original-2;
    }
}
