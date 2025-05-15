package org.example.task2.equipment;

import org.example.task2.Hero;

public abstract class Equipment implements Hero {

    Hero target;

    Equipment(Hero target) {
        this.target = target;
    }

    @Override
    public String getName() {
        return target.getName();
    }

    @Override
    public String getClassName() {
        return target.getClassName();
    }

    @Override
    public int getDefence() {
        return modifyDefence(target.getDefence());
    }

    protected abstract int modifyDefence(int original);

    @Override
    public int getAttack() {
        return modifyAttack(target.getAttack());
    }

    protected abstract int modifyAttack(int original);

    @Override
    public int getSpeed() {
        return modifySpeed(target.getSpeed());
    }

    protected abstract int modifySpeed(int original);

}
