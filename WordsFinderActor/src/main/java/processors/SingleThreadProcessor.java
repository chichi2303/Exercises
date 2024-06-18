package processors;

import ResultHandler.ResultHandler;
import ResultHandler.Result;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SingleThreadProcessor {

  private SingleThreadProcessor() {
  }

  public static Result processFile(Path filePath) throws Exception {
    Result finalResult = new ResultHandler();
    List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
    for (String line : lines) {
      Result result = LineProcessor.countWords(line);
      finalResult.compute(result);
    }
    return finalResult;
  }
}
