package processors;

public class LineProcessor {

  public static int[] WordCounts(String line) {
    int vowelCount = 0;
    int nonVowelCount = 0;
    String vowels = "AEIOU";

    for (char ch : line.toUpperCase().toCharArray()) {
      if (Character.isLetter(ch)) {
        if (vowels.indexOf(ch) != -1) {
          vowelCount++;
        } else {
          nonVowelCount++;
        }
      }
    }

    return new int[]{vowelCount, nonVowelCount};
  }

}
