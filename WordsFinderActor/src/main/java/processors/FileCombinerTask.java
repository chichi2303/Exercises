package processors;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Callable;
import java.nio.file.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileCombinerTask implements Callable {

  private final Path filePath;
  private final BufferedWriter writer;


  @Override
  public Object call() throws Exception {
    List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
    synchronized (writer) {
      for (String line : lines) {
        writer.write(line);
        writer.newLine();
      }
    }
    return null;
  }
}
