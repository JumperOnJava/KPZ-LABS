package org.example.task2.device.phone;

public class AbblePhone extends Phone {
    public AbblePhone(int storageTotal) {
        super(4500, 48, storageTotal);
    }

    @Override
    public void useStorage(int usage) {
        super.useStorage(usage);

        if (storageLeft <= (storageTotal * 0.25)) {
            System.out.println("\tYour storage is getting low. Buy myCloud for $5!");
        }
    }
}
