package org.example.task2.device.tablet;

public class AbbleTablet extends Tablet {

    public AbbleTablet(float inches) {
        super(inches,  Tablet.SCREEN_RETINA, true);
    }

    @Override
    public void useStylus() {
        System.out.println("\tUsed super duper Abble Magic pencil");
    }
}
