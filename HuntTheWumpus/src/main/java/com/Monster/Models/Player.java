package com.Monster.Models;


import com.Monster.Characteristics.AttackImpl;
import com.Monster.Controller.GameManagement;
import com.Monster.Characteristics.ShotTracker;
import com.Monster.Characteristics.ShotTrackerImpl;

public class Player extends Characters {

  private ShotTracker shotTracker;
  private AttackImpl attackImpl;

  public Player(int x, int y, int initialShots, GameManagement gameManagement) {
    super(x, y);
    this.shotTracker = new ShotTrackerImpl(initialShots);
    this.attackImpl = new AttackImpl(gameManagement);

  }

  @Override
  public char getSymbol() {
    return 'x';
  }

  public boolean attackWumpus(Map map, Monster monster) {
    return attackImpl.attackWumpus(this, map, monster);
  }

  public int getRemainingShots() {
    return shotTracker.getRemainingShots();
  }

  public void decrementRemainingShots() {
    shotTracker.useShot();
  }
  
}
