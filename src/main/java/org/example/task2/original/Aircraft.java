package org.example.task2.original;


public class Aircraft {
    public String Name;
    public Runway CurrentRunway;
    public boolean IsTakingOff;

    public Aircraft(String name, int size) {
        this.Name = name;
    }

    public void Land(Runway runway) {
        System.out.printf("Aircraft %s is landing.\n",this.Name);
        System.out.print("Checking runway.\n");
        if (runway.IsBusyWithAircraft == null) {
            System.out.printf("Aircraft %s has landed.\n",this.Name);
            runway.IsBusyWithAircraft = this;
            runway.HighLightRed();
            this.CurrentRunway = runway;
        } else {
            System.out.print("Could not land, the runway is busy.\n");
        }
    }

    public void TakeOff(Runway runway) {
        System.out.printf("Aircraft %s is taking off.\n",this.Name);
        runway.IsBusyWithAircraft = null;
        this.CurrentRunway = null;
        runway.HighLightGreen();
        System.out.printf("Aircraft %s has took off.\n",this.Name);
    }
}
