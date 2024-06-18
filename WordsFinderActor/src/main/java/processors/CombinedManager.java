package processors;

import OutputHandler.PrintOutputHandler;
import ResultHandler.ResultHandler;
import java.nio.file.Path;

public class CombinedManager {

  private String inputPath;
  private String outputPath;
  private int numThreads;
  private PrintOutputHandler printOutput;

  public CombinedManager(String inputPath, String outputPath, int numThreads) {
    this.inputPath = inputPath;
    this.outputPath = outputPath;
    this.numThreads = numThreads;
    this.printOutput = new PrintOutputHandler();
  }

  public void execute() {
    try {
      printOutput.setStartTime(System.nanoTime());
      FileCombinerManager combinerManager = new FileCombinerManager(inputPath, outputPath,
          numThreads);
      combinerManager.combineFiles();

      Path combinedFile = combinerManager.getCombinedFilePath();
      ;
      ResultHandler result = (ResultHandler) SingleThreadProcessor.processFile(combinedFile);

      printOutput.setEndTime(System.nanoTime());
      printOutput.totalTimeCount();

      printOutput.printOutput(result.getVowelCount(), result.getNonVowelCount());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

