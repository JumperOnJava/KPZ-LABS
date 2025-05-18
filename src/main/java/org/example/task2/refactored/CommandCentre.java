package org.example.task2.refactored;

import java.util.HashMap;

public class CommandCentre {

    private final HashMap<Runway, Aircraft> busyRunways = new HashMap<>();

    public CommandCentre() {
    }

    public void TakeOff(Aircraft aircraft, Runway runway) {
        System.out.printf("Aircraft %s is taking off.\n", aircraft.Name);
        busyRunways.remove(runway);
        runway.HighLightGreen();
        System.out.printf("Aircraft %s has took off.\n", aircraft.Name);
    }

    public void Land(Aircraft aircraft, Runway runway) {
        System.out.printf("Aircraft %s is landing.\n", aircraft.Name);
        System.out.print("Checking runway.\n");
        if (!busyRunways.containsKey(runway)) {
            System.out.printf("Aircraft %s has landed.\n", aircraft.Name);
            busyRunways.put(runway, aircraft);
            runway.HighLightRed();
        } else {
            System.out.print("Could not land, the runway is busy.\n");
        }
    }

    public boolean CheckIsActive(Runway runway) {
        boolean result = false;
        if (busyRunways.containsKey(runway)) {
            result = busyRunways.get(runway).IsTakingOff;
        }
        return result;
    }
}