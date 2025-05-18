package org.example.task2.original;

import java.util.ArrayList;
import java.util.List;

class CommandCentre
  {
    private List<Runway> _runways = new ArrayList<>();
    private List<Aircraft> _aircrafts = new ArrayList<>();

    public CommandCentre(Runway[] runways, Aircraft[] aircrafts)
    {
      this._runways.addAll(List.of(runways));
      this._aircrafts.addAll(List.of(aircrafts));
    }
  }