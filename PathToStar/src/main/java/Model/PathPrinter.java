package Model;

import java.util.List;

public class PathPrinter {

  public void printPath(char[][] map, List<int[]> path) {
    int height = map.length;
    int width = map[0].length;
    char[][] mapCopy = new char[height][width];

    //create a copy
    for (int i = 0; i < height; i++) {
      System.arraycopy(map[i], 0, mapCopy[i], 0, width);
    }

    //mark the path on the map copy
    for (int[] cell : path) {
      int x = cell[0];
      int y = cell[1];
      if (mapCopy[x][y] != 'S' && mapCopy[x][y] != 'E') {
        mapCopy[x][y] = '*';
      }
    }

    //print the map with path marked
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(mapCopy[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void printPaths(char[][] map, List<List<int[]>> paths) {
    for (List<int[]> path : paths) {
      printPath(map, path);
      System.out.println();
    }
  }
}
