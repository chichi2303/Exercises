package com.Monster.Models;

import java.util.Scanner;
import lombok.Getter;


@Getter
public class Characters {

  protected int x, y;
  private final Scanner scanner = new Scanner(System.in);

  public Characters(int x, int y) {
    this.x = x;
    this.y = y;
  }


  public void move(Map map) {
    boolean validDirection = false;

    while (!validDirection) {
      System.out.print("Enter direction ('up', 'down', 'left', 'right'): ");
      String direction = scanner.nextLine().toLowerCase();
      int newX = x, newY = y;

      switch (direction) {
        case "up":
          newY--;
          break;
        case "down":
          newY++;
          break;
        case "left":
          newX--;
          break;
        case "right":
          newX++;
          break;
        default:
          System.out.println("Invalid input! Please enter a valid input.");
          continue;
      }

      if (map.isValidPosition(newX, newY)) {
        map.removeEntity(x, y);
        x = newX;
        y = newY;
        placeOnMap(map, getSymbol());
        validDirection = true;
      } else {
        System.out.println("Invalid move! The position is outside the map boundaries. Please "
            + "re-enter new position");
      }
    }
    
  }

  public void placeOnMap(Map map, char symbol) {
    map.placeEntity(x, y, symbol);
  }

  public char getSymbol() {
    return '-';
  }

}
