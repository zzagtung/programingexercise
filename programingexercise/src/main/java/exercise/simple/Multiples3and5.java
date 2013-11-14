package exercise.simple;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * @author ryan
 *
 */
public class Multiples3and5 {
  
  public static void main(String[] args) {
    // 3배수의 합.
    int threeMultiplesSum = 3 * sum(999/3);
    // 5배수의 합.
    int fiveMultiplesSum = 5 * sum(999/5);
    // 15배수의 합.
    int fifteenMultiplesSum = 15 * sum(999/15);
    
    // 3배수 합 + 5배수 합 - 15배수 합
    System.out.println(threeMultiplesSum + fiveMultiplesSum - fifteenMultiplesSum);
  }
  
  private static int sum(int n) {
    return (n * (n+1)) / 2;
  }

}
