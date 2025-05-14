package org.example.task2.device.tablet;

public class GoggleTablet extends Tablet {

    public GoggleTablet(float inches) {
        super(inches, SCREEN_OLED, false);
    }

    @Override
    public void useStylus() {
        System.out.println("Goggle Tablet doesn't support stylus");
    }
}
