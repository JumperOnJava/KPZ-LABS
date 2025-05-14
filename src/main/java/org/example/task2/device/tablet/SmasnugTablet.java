package org.example.task2.device.tablet;

public class SmasnugTablet extends Tablet {

    public SmasnugTablet(float inches) {
        super(inches, SCREEN_AMOLED, true);
    }

    @Override
    public void printInfo() {
        System.out.printf("\tScreen: Super AMOLED %.1f inches display\n", inches);
    }
}
