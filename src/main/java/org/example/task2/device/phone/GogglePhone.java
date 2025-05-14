package org.example.task2.device.phone;

public class GogglePhone extends Phone {
    public GogglePhone(int storageTotal) {
        super(4800, 50, storageTotal);
    }

    @Override
    public void useBattery(int usage) {
        int reducedUsage = (int)(usage * 0.8);
        super.useBattery(reducedUsage);
    }
}
