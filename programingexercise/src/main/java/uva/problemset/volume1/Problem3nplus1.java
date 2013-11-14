package uva.problemset.volume1;


public class Problem3nplus1 {

  public static void main(String[] args) {
    //System.out.println(getCycleLength(22));
    System.out.println(getMaxCycleLength(1, 10));
    System.out.println(getMaxCycleLength(100, 200));
    System.out.println(getMaxCycleLength(201, 210));
    System.out.println(getMaxCycleLength(900, 1000));
  }
  private static int getCycleLength(int n) {
    //System.out.println(n);
    int cycle = 1;
    if (n == 1) {
      return cycle;
    }
    while (n != 1) {
      cycle = cycle + 1;
      if (n % 2 == 0) {
        n = n / 2;
      }
      else {
        n = 3*n + 1;
      }
      //System.out.println(n);
    }
    return cycle;
  }
  
  private static int getMaxCycleLength(int a, int b) {
    int maxCycleLength = 0;
    for (;a <= b; a++) {
      int temp = getCycleLength(a);
      if (maxCycleLength < temp) {
        maxCycleLength = temp;
      }
    }
    return maxCycleLength;
  }
}
