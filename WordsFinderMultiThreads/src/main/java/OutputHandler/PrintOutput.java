package OutputHandler;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class PrintOutput {

  private long startTime;
  private long endTime;
  private double duration;

  public void totalTimeCount() {
    duration = (endTime - startTime) / 1_000_000_000.0; //convert from nanoseconds to seconds
  }

  public abstract void printOutput(int vowelCounts, int nonVowelCounts);
}
