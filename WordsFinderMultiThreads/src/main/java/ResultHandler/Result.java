package ResultHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Result {

  private int vowelCount;
  private int nonVowelCount;

  public abstract void compute(Result result);

  public int[] toArray() {
    return new int[]{vowelCount, nonVowelCount};
  }
}
