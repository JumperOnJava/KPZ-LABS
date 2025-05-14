package org.example.task2.device.laptop;

public class SmasnugLaptop extends Laptop {
    public SmasnugLaptop(float inches, int ram, int cpuGeneration) {
        super(inches, ram, INTELECTRO, cpuGeneration);
    }

    @Override
    public float getCpuCalculationTFLOPS() {
        return (float) (8.5f + getCpuGeneration() * 2.2);
    }
}
