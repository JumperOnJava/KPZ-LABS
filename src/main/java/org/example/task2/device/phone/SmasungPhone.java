package org.example.task2.device.phone;

public class SmasungPhone extends Phone {
    public SmasungPhone(int storageTotal) {
        super(5000, 108, storageTotal);
    }

    @Override
    public void capturePhoto() {
        System.out.printf("\tcaptured %d megapixel photo using x100 zoom\n", megapixels);
    }
}
