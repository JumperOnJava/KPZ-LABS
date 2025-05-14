package org.example.task2.device.tablet;

public abstract class Tablet {
    protected float inches;
    protected String screenType;
    protected boolean supportsStylus;

    public static final String SCREEN_OLED = "OLED";
    public static final String SCREEN_AMOLED = "AMOLED";
    public static final String SCREEN_RETINA = "RETINA";

    protected Tablet(float inches, String screenType, boolean supportsStylus) {
        this.inches = inches;
        this.screenType = screenType;
        this.supportsStylus = supportsStylus;
    }

    public void printInfo() {
        System.out.printf("\tScreen: %s %.1f inches %s stylus support", screenType, inches, supportsStylus ? "with" : "without");
    }

    public void useStylus(){
        if(supportsStylus){
            System.out.println("\tStylus used for tablet");
        }else {
            System.out.println("\tTablet does not support stylus");
        }
    }
}
