package com.Monster;

import com.Monster.Controller.GameMaster;
import java.util.Random;

public class HuntTheWumpus {

  public static void main(String[] args) {
    Random random = new Random();
    GameMaster gameMaster = new GameMaster(5, random.nextInt(5), random.nextInt(5), 4);
    gameMaster.startGame();
  }
}
