import lombok.Getter;
import java.util.Scanner;

@Getter
public class InputHandler {

  private int width;
  private int height;
  private final Scanner scanner;

  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }

  public void getInput() {
    width = validInput("Enter the width of the rectangle (Positive integer from 1 to 10 only): ", 1,
        10);
    height = validInput("Enter the height of the rectangle (Positive Integer from 1 to 10 only): "
        , 1,
        10);
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
