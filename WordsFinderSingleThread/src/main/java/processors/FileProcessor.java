package processors;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileProcessor {

  int totalVowelCount = 0;
  int totalNonVowelCount = 0;

  public FileProcessor(String inputPath) {
    Path folderPath = Paths.get(inputPath);
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.txt")) {
      for (Path filePath : stream) {
//        System.out.println("Reading file: " + filePath.getFileName());
        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        for (String line : lines) {
          int[] counts = LineProcessor.WordCounts(line);
          totalVowelCount += counts[0];
          totalNonVowelCount += counts[1];
        }
//        System.out.println("Finished reading file: " + filePath.getFileName());
//        System.out.println();
      }
    } catch (IOException | DirectoryIteratorException e) {
      e.printStackTrace();
    }
  }

  public void printTotalCounts() {
    System.out.println("Total vowels: " + totalVowelCount);
    System.out.println("Total non-vowels: " + totalNonVowelCount);
  }
}
