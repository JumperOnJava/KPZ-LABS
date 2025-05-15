package org.example.task2;

import org.example.task2.equipment.HermesBoots;
import org.example.task2.equipment.IronArmor;
import org.example.task2.equipment.SuperSword;
import org.example.task2.hero.Mage;
import org.example.task2.hero.Paladin;
import org.example.task2.hero.Warrior;

public class Task2 {
    public static void Main() {
        Hero mage = new Mage("Edengharius");
        Hero warrior = new Warrior("Nathaneus");
        Hero paladin = new Paladin("Damerefian");

        System.out.println("Characters before decorators: \n");
        mage.printDescription();
        warrior.printDescription();
        paladin.printDescription();

        mage = new HermesBoots(mage);
        warrior = new SuperSword(warrior);
        paladin = new IronArmor(paladin);

        System.out.println("Characters after 1 decorator: \n");
        mage.printDescription();
        warrior.printDescription();
        paladin.printDescription();

        mage = new IronArmor(mage);
        warrior = new HermesBoots(warrior);
        paladin = new SuperSword(paladin);

        System.out.println("Characters after 2 decorators: \n");
        mage.printDescription();
        warrior.printDescription();
        paladin.printDescription();



    }
}
