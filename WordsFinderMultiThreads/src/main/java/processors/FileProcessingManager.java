package processors;

import OutputHandler.PrintOutput;
import OutputHandler.PrintOutputHandler;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileProcessingManager {

  private final Path folderPath;
  private final ExecutorService executor;
  private final List<Future<int[]>> futures;

  public FileProcessingManager(String inputPath, int numThreads) {
    this.folderPath = Paths.get(inputPath);
    this.executor = Executors.newFixedThreadPool(numThreads);
    this.futures = new ArrayList<>();
  }

  public void processFiles() {
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.txt")) {
      for (Path filePath : stream) {
        FileProcessor fileProcessor = new FileProcessor(filePath);
        //Submits a value-returning task for execution and returns a Future representing the pending results of the task.
        Future<int[]> future = executor.submit(fileProcessor);
        futures.add(future);
      }
    } catch (IOException | DirectoryIteratorException e) {
      e.printStackTrace();
    }
  }

  public int[] collectResults() {
    int totalVowelCount = 0;
    int totalNonVowelCount = 0;

    for (Future<int[]> future : futures) {
      try {
        int[] counts = future.get();
        totalVowelCount += counts[0];
        totalNonVowelCount += counts[1];
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    executor.shutdown();
    return new int[]{totalVowelCount, totalNonVowelCount};
  }

  public void execute() {
    PrintOutput output = new PrintOutputHandler();
    output.setStartTime(System.nanoTime());
    processFiles();
    int[] totalCounts = collectResults();
    output.setEndTime(System.nanoTime());
    output.totalTimeCount();
    output.printOutput(totalCounts[0], totalCounts[1]);
  }
}
