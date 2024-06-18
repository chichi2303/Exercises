package com.Monster.Characteristics;

import com.Monster.Controller.GameMaster;
import com.Monster.Models.Player;
import com.Monster.Models.Monster;
import com.Monster.Controller.GameManagement;
import com.Monster.Models.Map;
import java.util.Scanner;

public class AttackImpl implements Attack {

  private GameManagement gameManagement;
  private final Scanner scanner = new Scanner(System.in);
  private GameMaster gameMaster;

  public AttackImpl(GameManagement gameManagement) {
    this.gameManagement = gameManagement;
  }

  @Override
  public boolean attackWumpus(Player player, Map map, Monster monster) {
    boolean validDirection = false;
    int targetX = player.getX(), targetY = player.getY();

    while (!validDirection) {
      System.out.print("Enter 'a', 'w', 's', or 'd' for shooting direction:");
      String direction = scanner.nextLine().toLowerCase();
      targetX = player.getX();
      targetY = player.getY();
      switch (direction) {
        case "w":
          targetY--;
          break;
        case "s":
          targetY++;
          break;
        case "a":
          targetX--;
          break;
        case "d":
          targetX++;
          break;
        default:
          System.out.println("Invalid direction!");
          continue;
      }
      if (map.isValidPosition(targetX, targetY)) {
        validDirection = true;
      } else {
        System.out.println("Invalid direction!");
      }
    }
    player.decrementRemainingShots();
    
    if (targetX == monster.getX() && targetY == monster.getY()) {
      return true;
    }
    System.out.println("Missed Target!");
    return false;


  }
}
