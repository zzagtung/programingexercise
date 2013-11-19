package uva.problemset.volume1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Problem3nplus1 class.
 * @see <a href="http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=36">Volume 1. 100 문제.</a>
 * 
 * @author Ryan
 * @date 2013. 11. 18.
 */
public class Problem3nplus1 {

  public static void main(String[] args) throws IOException {
    //System.out.println(getCycleLength(22));
//    System.out.println(getMaxCycleLength(1, 10));
//    System.out.println(getMaxCycleLength(100, 200));
//    System.out.println(getMaxCycleLength(201, 210));
//    System.out.println(getMaxCycleLength(900, 1000));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String temp = null;
    while ((temp = in.readLine()) != null && temp.length() != 0) {
      String[] inputValues = temp.split(" ");
      int a = Integer.valueOf(inputValues[0]);
      int b = Integer.valueOf(inputValues[1]);
      int maxLength = getMaxCycleLength(a, b);
      System.out.println(a + " " + b + " " + maxLength);
    }
    
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
