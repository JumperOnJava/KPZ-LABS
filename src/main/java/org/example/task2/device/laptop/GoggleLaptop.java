package org.example.task2.device.laptop;

public class GoggleLaptop extends Laptop {
    public GoggleLaptop(float inches, int ram, int cpuGeneration) {
        super(inches, ram, KUALKOM, cpuGeneration);
    }

    @Override
    public float getCpuCalculationTFLOPS() {
        return 9.0f + getCpuGeneration() * 2;
    }
}
