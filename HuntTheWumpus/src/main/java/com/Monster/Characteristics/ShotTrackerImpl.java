package com.Monster.Characteristics;

import lombok.Getter;

@Getter
public class ShotTrackerImpl implements ShotTracker {

  private int remainingShots;
  private final int initialShots;

  public ShotTrackerImpl(int initialShot) {
    this.remainingShots = initialShot;
    this.initialShots = initialShot;
  }


  @Override
  public int getRemainingShots() {
    return remainingShots;
  }

  @Override
  public void useShot() {
    remainingShots--; //For this issue, -1 every time we shoot
  }

  @Override
  public void resetShots() {
    remainingShots = initialShots;
  }
}
