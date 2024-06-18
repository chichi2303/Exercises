package processors;

import ResultHandler.Result;
import ResultHandler.ResultHandler;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.Callable;
import lombok.AllArgsConstructor;

//Use Callable allow instances of this class to be executed by a thread and return an array of
// integers --> int[] this case
@AllArgsConstructor
public class FileProcessor implements Callable<int[]> {

  private Path filePath;


  @Override
  public int[] call() throws Exception {
    List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
    Result finalResult = new ResultHandler();
    for (String line : lines) {
      Result result = LineProcessor.countWords(line);
      finalResult.compute(result);
    }

    return finalResult.toArray();
  }
}

