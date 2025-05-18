package org.example.task2;


public class Task2 {
    public static void Main() {
//        var aircraftA = new org.example.task2.original.Aircraft("Plane A",5);
//        var aircraftB = new org.example.task2.original.Aircraft("Plane B",4);
//        var runway = new org.example.task2.original.Runway();
//        aircraftA.Land(runway);
//        aircraftB.Land(runway);
//        aircraftA.TakeOff(runway);
//        aircraftB.Land(runway);
//        aircraftB.TakeOff(runway);


        var commandCentre = new org.example.task2.refactored.CommandCentre();
        var aircraftA2 = new org.example.task2.refactored.Aircraft("Plane A",5);
        var aircraftB2 = new org.example.task2.refactored.Aircraft("Plane B",4);
        var runway2 = new org.example.task2.refactored.Runway();
        commandCentre.Land(aircraftA2,runway2);
        commandCentre.Land(aircraftB2,runway2);
        commandCentre.TakeOff(aircraftA2,runway2);
        commandCentre.Land(aircraftB2,runway2);
        commandCentre.TakeOff(aircraftB2,runway2);

    }
}
