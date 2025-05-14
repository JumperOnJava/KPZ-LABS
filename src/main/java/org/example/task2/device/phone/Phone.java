package org.example.task2.device.phone;

public abstract class Phone {
    int batteryChargeLeft;
    int batteryFullCharge;
    int megapixels;
    int storageTotal;
    int storageLeft;

    protected Phone(int batteryFullCharge, int megapixels, int storageTotal) {
        this.batteryFullCharge = batteryFullCharge;
        this.megapixels = megapixels;
        this.storageTotal = storageTotal;
        this.storageLeft = storageTotal;
        this.batteryChargeLeft = batteryFullCharge;
    }

    public int getBatteryChargeLeft() {
        return batteryChargeLeft;
    }

    public void useBattery(int usage) {
        batteryChargeLeft -= usage;
        if(batteryChargeLeft <= 0) {
            System.out.print("\tbattery is discharged\n");
            batteryChargeLeft = 0;
        }
    }

    public void chargeBattery() {
        System.out.printf("\tcharged battery to %d mAh\n", batteryFullCharge);
        batteryChargeLeft = batteryFullCharge;
    }

    public void capturePhoto(){
        System.out.printf("\tcaptured %d megapixel photo\n", megapixels);
    }

    public int getStorageLeft() {
        return storageLeft;
    }

    public void useStorage(int usage) {
        storageLeft -= usage;
        if(storageLeft <= 0) {
            System.out.print("\tstorage is full\n");
            storageLeft = 0;
        }
    }

    public void clearStorage() {
        System.out.printf("\tcleared storage to %d GB\n", storageTotal);
        storageLeft = storageTotal;
    }
    public void printInfo(){
        System.out.println("\tBattery charge left: " + batteryChargeLeft + "/" + batteryFullCharge);
        System.out.println("\tCamera megapixels: " + megapixels);
        System.out.println("\tStorage left: " + storageLeft + "/" + storageTotal);
    }
}

