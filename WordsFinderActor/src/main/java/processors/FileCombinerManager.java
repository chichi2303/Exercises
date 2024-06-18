package processors;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.Getter;

public class FileCombinerManager {

  private final Path folderPath;
  @Getter
  private final Path combinedFilePath;
  private final ExecutorService executor;

  public FileCombinerManager(String inputPath, String outputFilePath, int numbThreads) {
    this.folderPath = Paths.get(inputPath);
    this.combinedFilePath = Paths.get(outputFilePath);
    this.executor = Executors.newFixedThreadPool(numbThreads);
  }

  public void combineFiles() throws IOException {
    List<Future<Void>> futures = new ArrayList<>();

    try (BufferedWriter writer = Files.newBufferedWriter(combinedFilePath,
        StandardCharsets.UTF_8)) {
      try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.txt")) {
        for (Path filePath : stream) {
          FileCombinerTask task = new FileCombinerTask(filePath, writer);
          Future<Void> future = executor.submit(task);
          futures.add(future);
        }
      } catch (IOException | DirectoryIteratorException e) {
        e.printStackTrace();
      }
      for (Future<Void> future : futures) {
        try {
          future.get(); //wait for all tasks to complete
        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
        }
      }
    } finally {
      executor.shutdown();
    }
  }
}
