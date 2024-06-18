import processors.CombinedManager;

public class Main {

  public static void main(String[] args) {
    String inputPath = "/Users/chi/OneDrive/Study/java/Exercises/Examples";
    String outputPath = "/Users/chi/OneDrive/Study/java/Exercises/Combined.txt";
    int numThreads = 3;

    CombinedManager manager = new CombinedManager(inputPath, outputPath, numThreads);
    manager.execute();
  }
}