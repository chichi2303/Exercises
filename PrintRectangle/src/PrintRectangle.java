public class PrintRectangle {

  public static void main(String[] args) {
    InputHandler inputHandler = new InputHandler();
    inputHandler.getInput();

    printRectangle(inputHandler.getWidth(), inputHandler.getHeight());
  }

  public static void printRectangle(int width, int height) {
    StringBuilder row = new StringBuilder();
    for (int i = 0; i < width; i++) {
      row.append("* ");
    }

    for (int j = 0; j < height; j++) {
      System.out.println(row);
    }
  }
}