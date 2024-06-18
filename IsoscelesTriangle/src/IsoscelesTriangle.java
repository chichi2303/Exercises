public class IsoscelesTriangle {

  public static void main(String[] args) {
    TriangleInputHandler triangleInputHandler = new TriangleInputHandler();
    triangleInputHandler.TriangleInput();

    for (int k = 1; k <= triangleInputHandler.getLength(); k++) {
      printTriangleLine(k, triangleInputHandler.getLength());
    }

  }

  public static void printTriangleLine(int rowNumber, int totalRows) {
    printSequence(" ", totalRows - rowNumber);
    printSequence("*", 2 * rowNumber - 1);
    System.out.println();
  }

  public static void printSequence(String s, int repeats) {
    for (int i = 0; i < repeats; i++) {
      System.out.print(s);
    }
  }
}