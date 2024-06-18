package com.Monster.Controller;

import com.Monster.Models.Map;
import com.Monster.Models.Player;
import com.Monster.Models.Monster;
import java.util.Random;
import java.util.Scanner;

public class GameMaster {

  private Player player;
  private Map map;
  private GameManagement gameManagement;
  private Monster monster;
  private boolean attackHit;

  public GameMaster(int mapSize, int playerX, int playerY, int initialShots) {
    Random random = new Random();
    this.gameManagement = new GameManagementImpl(mapSize);
    this.monster = new Monster(random.nextInt(mapSize), random.nextInt(mapSize));

    //In case that user is in the same position with the Monster:
    while (playerX == monster.getX() && playerY == monster.getY()) {
      playerX = random.nextInt(mapSize);
      playerY = random.nextInt(mapSize);
    }

    this.player = new Player(playerX, playerY, initialShots, this.gameManagement);
    this.map = new Map(mapSize, playerX, playerY);

  }

  public void startGame() {
    System.out.println("Welcome to Hunt the Wumpus");
    System.out.println("Starting a new game...");
    System.out.println("Current map: ");
    map.display();
    gameLoop();
  }

  private void gameLoop() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      //Player movement
      player.move(map);
      //Check if monster is near
      int distance = map.calculateDistaneToWumpus(player.getX(), player.getY(), monster);
      if (distance == 1) {
        System.out.println("Warning: Wumpus is nearby!");
      }
      if (gameOverCondition(attackHit)) {
        gameManagement.endGame();
        break;
      }
      map.display();

      boolean permissionToAttack = false;
      while (!permissionToAttack) {
        //Check if user wants to attack or not
        System.out.print("Do you want to attack? (y/n): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("y")) {
          //Player Attack
          attackHit = player.attackWumpus(map, monster);
          permissionToAttack = true;
        } else if (choice.equals("n")) {
          break;
        } else {
          System.out.println("Invalid choice. Please enter 'y' or 'n'.");
        }
      }

      if (gameOverCondition(attackHit)) {
        gameManagement.endGame();
        break;
      }
    }
  }

  private boolean gameOverCondition(boolean attackHit) {
    if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
      System.out.println("Game over! Wumpus ate player.");
      return true;
    }

    if (player.getRemainingShots() <= 0) {
      System.out.println("Out of shots! Game over!");
      return true;
    }

    if (attackHit) {
      System.out.println("You hit it! You Won!");
      return true;
    }
    return false;
  }
}
