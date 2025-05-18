package org.example.task2.refactored;

import java.util.UUID;

public class Runway {

    public final UUID Id = UUID.randomUUID();

    public void HighLightRed() {
        System.out.printf("Runway %s is busy!\n", this.Id);
    }

    public void HighLightGreen() {
        System.out.printf("Runway %s is free!\n", this.Id);
    }
}
