package org.example.task2.device.laptop;

public class AbbleLaptop extends Laptop {
    public AbbleLaptop(float inches, int ram, int cpuGeneration) {
        super(inches, 8, cpuGeneration < 4 ? INTELECTRO : ABBLE_SILICON, cpuGeneration);
    }

    @Override
    public float getCpuCalculationTFLOPS() {
        return getCpuGeneration() + (getCpuManufacturer().equals(ABBLE_SILICON) ? 10.5f : 8.0f);
    }
}
