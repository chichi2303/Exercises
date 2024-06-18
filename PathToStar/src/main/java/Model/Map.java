package Model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class Map {

  private int height;
  private int width;
  @Getter
  private char[][] map;
  private final char startSymbol = 'S';
  private final char endSymbol = 'E';
  private final char pathSymbol = 'o';
  private final char obstacleSymbol = '-';

  public Map(int height, int width) {
    this.height = height;
    this.width = width;
    map = new char[height][width];
    initializeMap();
    setPaths(initializePaths());
  }

  private void initializeMap() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        map[i][j] = obstacleSymbol;
      }
    }
    map[0][0] = startSymbol; //start loc
    map[height - 1][width - 1] = endSymbol; //end Loc
  }

  public void printMap() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  //at least 3 paths - 3 for now
  private List<List<int[]>> initializePaths() {
    List<int[]> path1 = new ArrayList<>();
    path1.add(new int[]{0, 1});
    path1.add(new int[]{0, 2});
    path1.add(new int[]{0, 3});
    path1.add(new int[]{1, 3});
    path1.add(new int[]{2, 3});
    path1.add(new int[]{3, 3});
    path1.add(new int[]{4, 3});
    path1.add(new int[]{4, 4});

    List<int[]> path2 = new ArrayList<>();
    path2.add(new int[]{0, 1});
    path2.add(new int[]{1, 1});
    path2.add(new int[]{2, 1});
    path2.add(new int[]{3, 1});
    path2.add(new int[]{3, 2});
    path2.add(new int[]{3, 3});
    path2.add(new int[]{4, 3});
    path2.add(new int[]{4, 4});

    List<int[]> path3 = new ArrayList<>();
    path3.add(new int[]{1, 0});
    path3.add(new int[]{2, 0});
    path3.add(new int[]{2, 1});
    path3.add(new int[]{2, 2});
    path3.add(new int[]{2, 3});
    path3.add(new int[]{3, 3});
    path3.add(new int[]{4, 3});
    path3.add(new int[]{4, 4});

    List<List<int[]>> paths = new ArrayList<>();
    paths.add(path1);
    paths.add(path2);
    paths.add(path3);
    return paths;
  }

  private void setPaths(List<List<int[]>> paths) {
    for (List<int[]> path : paths) {
      for (int[] coordinate : path) {
        int x = coordinate[0];
        int y = coordinate[1];
        if (x >= 0 && x < height && y >= 0 && y < width && map[x][y] != startSymbol
            && map[x][y] != endSymbol) {
          map[x][y] = pathSymbol;
        }
      }
    }
  }

  public List<List<int[]>> getPaths() {
    return initializePaths();
  }
}
