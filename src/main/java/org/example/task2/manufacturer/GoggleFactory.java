package org.example.task2.manufacturer;

import org.example.task2.device.laptop.GoggleLaptop;
import org.example.task2.device.laptop.Laptop;
import org.example.task2.device.phone.GogglePhone;
import org.example.task2.device.phone.Phone;
import org.example.task2.device.tablet.GoggleTablet;
import org.example.task2.device.tablet.Tablet;

public class GoggleFactory implements ManufacturerFactory {
    @Override
    public String getManufacturerName() {
        return "Goggle";
    }

    @Override
    public Phone createPhone(int storage) {
        return new GogglePhone(storage);
    }

    @Override
    public Laptop createLaptop(float inches, int ram, int cpuGeneration) {
        return new GoggleLaptop(inches, ram, cpuGeneration);
    }

    @Override
    public Tablet createTablet(float inches) {
        return new GoggleTablet(inches);
    }

}
