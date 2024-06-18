package com.Monster.Models;

public class Monster extends Characters {

  public Monster(int x, int y) {
    super(x, y);
  }

  @Override
  public void move(Map map) {
    //Do nothing as Wumpus does not move.
  }
  

}
