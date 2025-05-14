package org.example.task2;

import org.example.task2.device.laptop.Laptop;
import org.example.task2.manufacturer.AbbleFactory;
import org.example.task2.manufacturer.GoggleFactory;
import org.example.task2.manufacturer.SmasnugFactory;

import java.util.List;

public class Task2 {
    public static void Main() {
        var abbleFactory = new AbbleFactory();
        var smasnugFactory = new SmasnugFactory();
        var goggleFactory = new GoggleFactory();

        var factories = List.of(abbleFactory, smasnugFactory, goggleFactory);
        factories.forEach(factory -> {

            System.out.printf("\n%s Phone: \n",factory.getManufacturerName());
            var phone = factory.createPhone(128);
            phone.capturePhoto();
            phone.useStorage(100);
            phone.useBattery(500);
            phone.printInfo();

            var laptop_old = factory.createLaptop(13, 8, 3);
            var laptop_new = factory.createLaptop(13, 16, 5);

            System.out.printf("\n%s Laptop old: \n",factory.getManufacturerName());
            laptop_old.printInfo();
            System.out.printf("\n%s Laptop new: \n",factory.getManufacturerName());
            laptop_new.printInfo();

            System.out.printf("\n%s Tablet: \n",factory.getManufacturerName());
            var tablet = factory.createTablet(10);
            tablet.useStylus();
            tablet.printInfo();
            System.out.print("\n\n\n\n");

        });
    }
}
