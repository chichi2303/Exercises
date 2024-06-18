import Model.Map;
import Model.PathFinder;
import Model.PathPrinter;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Map map = new Map(5, 5);
    System.out.println("Initial Map with Paths:");
    map.printMap();
    System.out.println();

    PathPrinter pathPrinter = new PathPrinter();

    PathFinder pathFinder = new PathFinder();

    System.out.println("All Possible Paths:");

    List<List<int[]>> allPaths = pathFinder.findAllPaths(map.getMap());
    pathPrinter.printPaths(map.getMap(), allPaths);

    List<int[]> shortestPath = pathFinder.findShortestPath(map.getMap());
    if (shortestPath != null) {
      System.out.println("Shortest Paths:");
      pathPrinter.printPath(map.getMap(), shortestPath);
    } else {
      System.out.println("No path found.");
    }
  }

}