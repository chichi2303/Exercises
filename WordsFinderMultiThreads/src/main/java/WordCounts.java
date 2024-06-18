import processors.FileProcessingManager;

public class WordCounts {

  public static void main(String[] args) {

    String inputPath = "/Users/chi/OneDrive/Study/java/Exercises/Examples";
    int numThreads = 4;
    System.out.println("Number of Threads: " + numThreads);
    FileProcessingManager manager = new FileProcessingManager(inputPath, numThreads);
    manager.execute();
  }
}
