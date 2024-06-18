package OutputHandler;

public class PrintOutputHandler extends PrintOutput {


  @Override
  public void printOutput(int vowelCounts, int nonVowelCounts) {
    System.out.println("Total vowels: " + vowelCounts);
    System.out.println("Total non-vowels: " + nonVowelCounts);
    System.out.println("Processing time: " + getDuration() + " seconds");
  }
}
