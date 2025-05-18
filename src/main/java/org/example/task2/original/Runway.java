package org.example.task2.original;


import java.util.Optional;
import java.util.UUID;

public class Runway
  {
    public final UUID Id = UUID.randomUUID();
    public Aircraft IsBusyWithAircraft;

    public boolean CheckIsActive()
    {
      boolean result = false;
      if (this.IsBusyWithAircraft != null)
      {
        result = this.IsBusyWithAircraft.IsTakingOff;
      }
      return result;
    }

    public void HighLightRed()
    {
      System.out.printf("Runway %s is busy!\n",this.Id);
    }

    public void HighLightGreen()
    {
      System.out.printf("Runway %s is free!\n",this.Id);
    }
  }
