package com.Monster.Controller;

import java.util.Random;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameManagementImpl implements GameManagement {

  private int mapSize;


  @Override
  public void endGame() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.print("Do you want to play again? (y/n): ");
    String playAgain = scanner.nextLine().toLowerCase();

    if (playAgain.equals("y")) {
      GameMaster gameMaster = new GameMaster(5, random.nextInt(5), random.nextInt(5), 4);
      gameMaster.startGame();
    } else {
      System.out.println("Thank you for playing!");
    }

  }
}
