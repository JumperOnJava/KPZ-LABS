package org.example.task2.manufacturer;

import org.example.task2.device.laptop.Laptop;
import org.example.task2.device.laptop.SmasnugLaptop;
import org.example.task2.device.phone.Phone;
import org.example.task2.device.phone.SmasungPhone;
import org.example.task2.device.tablet.SmasnugTablet;
import org.example.task2.device.tablet.Tablet;

public class SmasnugFactory implements ManufacturerFactory
{
    @Override
    public String getManufacturerName() {
        return "Smasnug";
    }

    @Override
    public Phone createPhone(int storage) {
        return new SmasungPhone(storage);
    }

    @Override
    public Laptop createLaptop(float inches, int ram, int cpuGeneration) {
        return new SmasnugLaptop(inches, ram, cpuGeneration);
    }

    @Override
    public Tablet createTablet(float inches) {
        return new SmasnugTablet(inches);
    }

}
