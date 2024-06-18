import java.util.Scanner;
import lombok.Getter;

@Getter
public class TriangleInputHandler {

  private int length;
  private final Scanner scanner;

  public TriangleInputHandler() {
    this.scanner = new Scanner(System.in);
  }


  public void TriangleInput() {
    length = validInput("Enter the length of the isosceles triangle (Integer from 1 to 10 only): ",
        1, 10);
  }

  private int validInput(String message, int min, int max) {
    int input;
    do {
      System.out.print(message);
      input = scanner.nextInt();
      if (input < min || input > max) {
        System.out.println(" Invalid input. Value must not be negative and between 1 to 10");
      }
    } while (input < min || input > max);
    return input;
  }
}
