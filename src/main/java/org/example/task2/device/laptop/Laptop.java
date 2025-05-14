package org.example.task2.device.laptop;

public abstract class   Laptop {
    private final float inches;
    private final int ram;
    private final String cpuManufacturer;
    private final int cpuGeneration;

    public static final String KUALKOM = "KUALKOM";
    public static final String ABBLE_SILICON = "ABBLE SILICON";
    public static final String INTELECTRO = "INTELECTRO";

    protected Laptop(float inches, int ram, String cpuManufacturer, int cpuGeneration) {
        this.inches = inches;
        this.ram = ram;
        this.cpuManufacturer = cpuManufacturer;
        this.cpuGeneration = cpuGeneration;
    }

    public int getRam() {
        return ram;
    }
    public float getScreenSizeInches() {
        return inches;
    }
    public String getCpuManufacturer() {
        return cpuManufacturer;
    }
    public int getCpuGeneration() {
        return cpuGeneration;
    }
    public abstract float getCpuCalculationTFLOPS();

    public void printInfo(){
        System.out.println("\tRAM: " + getRam());
        System.out.println("\tCPU Manufacturer: " + getCpuManufacturer());
        System.out.println("\tCPU Generation: " + getCpuGeneration());
        System.out.println("\tCPU Calculation TFLOPS: " + getCpuCalculationTFLOPS());
        System.out.println("\tScreen size: "+getScreenSizeInches());
    }
}

