package org.example.task2.manufacturer;

import org.example.task2.device.laptop.Laptop;
import org.example.task2.device.phone.Phone;
import org.example.task2.device.tablet.Tablet;

public interface ManufacturerFactory {
    public String getManufacturerName();
    public Phone createPhone(int storage);
    public Laptop createLaptop(float inches, int ram, int cpuGeneration);
    public Tablet createTablet(float inches);
}
