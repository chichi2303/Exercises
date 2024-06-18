package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathFinder {

  private final int[] dx = {0, 1, 0, -1};
  private final int[] dy = {1, 0, -1, 0};

  //Find all Paths

  /**
   * find all possible paths from start to bottom
   *
   * @param map: 2d map array
   * @return: list of all the possible paths using DFS
   */
  public List<List<int[]>> findAllPaths(char[][] map) {
    int height = map.length;
    int width = map[0].length;
    boolean[][] visited = new boolean[height][width];
    List<List<int[]>> allPaths = new ArrayList<>();
    List<int[]> currentPath = new ArrayList<>();
    int[] pathCount = new int[1];
    dfs(map, 0, 0, visited, currentPath, allPaths, pathCount);
    System.out.println("Total possible paths: " + pathCount[0]);
    return allPaths;
  }

  /**
   * @param map         the 2D map
   * @param x           the current row
   * @param y           the current column
   * @param visited     the visited array to track visited locs
   * @param currentPath the current path
   * @param allPaths    the list of all found paths
   */

  private void dfs(char[][] map, int x, int y, boolean[][] visited, List<int[]> currentPath,
      List<List<int[]>> allPaths, int[] pathCount) {
    int height = map.length;
    int width = map[0].length;

    //Base case: return if the current cell is out of bounds, already visited, if it's
    // not a path --> return
    if (x < 0 || x >= height || y < 0 || y >= width || visited[x][y] || map[x][y] == '-') {
      return;
    }

    //add the current cell to path and marked it as visited
    currentPath.add(new int[]{x, y});
    visited[x][y] = true;

    //check if the destination is reached
    if (x == height - 1 && y == width - 1) {
      allPaths.add(new ArrayList<>(currentPath));
      pathCount[0]++;
    } else {
      //recursive to explore the four possible directions
      dfs(map, x + 1, y, visited, currentPath, allPaths, pathCount);
      dfs(map, x, y + 1, visited, currentPath, allPaths, pathCount);
      dfs(map, x - 1, y, visited, currentPath, allPaths, pathCount);
      dfs(map, x, y - 1, visited, currentPath, allPaths, pathCount);
    }

    //remove the current cell from the path and mark it as unvisited
    currentPath.remove(currentPath.size() - 1);
    visited[x][y] = false;
  }

  //Find the shortest paths

  /**
   * @param map 2D map array
   * @return A Pathresult object containing the shortest path and number of steps, or null if no
   * path is found
   */
  public List<int[]> findShortestPath(char[][] map) {
    int height = map.length;
    int width = map[0].length;
    boolean[][] visited = new boolean[height][width];
    int[][][] parent = new int[height][width][2];

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int x = cell[0], y = cell[1];

      if (x == height - 1 && y == width - 1) {
        return reconstructPath(parent, x, y);
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];

        if (nx >= 0 && nx < height && ny >= 0 && ny < width && !visited[nx][ny]
            && map[nx][ny] != '-') {
          queue.add(new int[]{nx, ny});
          visited[nx][ny] = true;
          parent[nx][ny][0] = x;
          parent[nx][ny][1] = y;

        }
      }
    }

    return null;
  }

  /**
   * @param parent storing previous cell for each cell in the path
   * @param x      x-coordinate of the end cell
   * @param y      y-coordinate of the end cell
   * @return A list of coordinate representing the path
   */
  private List<int[]> reconstructPath(int[][][] parent, int x, int y) {
    List<int[]> path = new ArrayList<>();
    while (x != 0 || y != 0) {
      path.add(new int[]{x, y});
      int px = parent[x][y][0];
      int py = parent[x][y][1];
      x = px;
      y = py;
    }
    path.add(new int[]{0, 0});
    return path;
  }
}
