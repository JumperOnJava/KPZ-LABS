package org.example.task2.manufacturer;

import org.example.task2.device.laptop.AbbleLaptop;
import org.example.task2.device.laptop.Laptop;
import org.example.task2.device.phone.AbblePhone;
import org.example.task2.device.phone.Phone;
import org.example.task2.device.tablet.AbbleTablet;
import org.example.task2.device.tablet.Tablet;

public class AbbleFactory implements ManufacturerFactory {
    @Override
    public String getManufacturerName() {
        return "Abble";
    }

    @Override
    public Phone createPhone(int storage) {
        return new AbblePhone(storage);
    }

    @Override
    public Laptop createLaptop(float inches, int ram, int cpuGeneration) {
        return new AbbleLaptop(inches, ram, cpuGeneration);
    }

    @Override
    public Tablet createTablet(float inches) {
        return new AbbleTablet(inches);
    }

}
