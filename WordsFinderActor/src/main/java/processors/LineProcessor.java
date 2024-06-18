package processors;

import ResultHandler.ResultHandler;
import ResultHandler.Result;

public class LineProcessor {

  private LineProcessor() {
  }

  public static Result countWords(String line) {
    Result result = new ResultHandler();
    String vowels = "AEIOU";

    for (char ch : line.toUpperCase().toCharArray()) {
      if (Character.isLetter(ch)) {
        if (vowels.indexOf(ch) != -1) {
          result.compute(new ResultHandler(1, 0)); // Increment vowel count
        } else {
          result.compute(new ResultHandler(0, 1)); // Increment non-vowel count
        }
      }
    }

    return result;
  }

}
