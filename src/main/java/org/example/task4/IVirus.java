package org.example.task4;

public interface IVirus extends Prototype<IVirus> {
    void printVirusInfo(int tabLevel);
    default void printVirusInfo(){printVirusInfo(0);};
}
