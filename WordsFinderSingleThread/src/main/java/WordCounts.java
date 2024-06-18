import processors.FileProcessor;

public class WordCounts {

  public static void main(String[] args) {

    String inputPath = "/Users/chi/OneDrive/Study/java/Exercises/WordsFinderSingleThread/Examples";

    long startTime = System.nanoTime();

    FileProcessor fileProcessor = new FileProcessor(inputPath);
    fileProcessor.printTotalCounts();

    long endTime = System.nanoTime();
    double duration = (endTime - startTime) / 1_000_000_000.0; //convert from nanoseconds to seconds
    System.out.println("Processing time: " + duration + " seconds");
  }
}
