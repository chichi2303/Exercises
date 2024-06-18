package ResultHandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultHandler extends Result {

  public ResultHandler(int vowelCount, int nonVowelCount) {
    super(vowelCount, nonVowelCount);
  }

  @Override
  public void compute(Result result) {
    this.setVowelCount(this.getVowelCount() + result.getVowelCount());
    this.setNonVowelCount(this.getNonVowelCount() + result.getNonVowelCount());
  }
}
