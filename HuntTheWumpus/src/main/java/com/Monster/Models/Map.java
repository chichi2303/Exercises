package com.Monster.Models;

import lombok.Getter;

@Getter
public class Map {

  private char[][] map;
  private final int size;
  private int playerX;
  private int playerY;

  public Map(int size, int playerX, int playerY) {
    this.size = size;
    this.playerX = playerX;
    this.playerY = playerY;
    map = new char[size][size];
    initializeMap();
  }

  public Map(int size) {
    this.size = size;
    map = new char[size][size];
    initializeMap();
  }

  private void initializeMap() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == playerY && j == playerX) {
          map[i][j] = 'x';
        } else {
          map[i][j] = '-';
        }
      }
    }
  }


  public void placeEntity(int x, int y, char symbol) {
    map[y][x] = symbol;
  }

  public void removeEntity(int x, int y) {
    map[y][x] = '-';
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  public boolean isValidPosition(int x, int y) {
    return x >= 0 && x < size && y >= 0 && y < size;
  }

  public int calculateDistaneToWumpus(int playerX, int playerY, Monster monster) {
    //Using Euclindean distance
    int monsterX = monster.getX();
    int monsterY = monster.getY();
    return (int) Math.sqrt(Math.pow(playerX - monsterX, 2) + Math.pow(playerY - monsterY, 2));
  }

}
