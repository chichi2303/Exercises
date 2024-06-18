import java.util.Scanner;

public class SumOfNumbers {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long num;
    do {
      System.out.print("Enter a positive integer: ");
      num = scanner.nextLong();

      long sum = calculateSum(num);
      if (sum > 10000000000L) {
        System.out.println("Sum exceeds the limit of 10^10. Please input a lower number!");
      }
      if (num < 1) {
        System.out.println("Value needs to be greater or equal to 1");
      } else {
        System.out.printf("The sum from 1 to %d is: %d", num, sum);
      }
    } while (num < 1 || calculateSum(num) > 10000000000L);
  }

  public static long calculateSum(long n) {
    return (n * (n + 1)) / 2;
  }
}