package algospot.coins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Coins class. 동전의 금액, 개수를 알려주고 특정금액을 만드는 경우의 수를 출력.
 * 
 * @see <a href="http://algospot.com/judge/problem/read/COINS">COINS</a>
 * 
 * @author Ryan
 * @date 2013. 11. 25.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String testCases = in.readLine();
    for (int i = 0; i < Integer.valueOf(testCases); i++) {
      String changeAndCoinCount = in.readLine();
      String[] temp = changeAndCoinCount.split(" ");
      int change = Integer.valueOf(temp[0]);
      //int coinCount = Integer.valueOf(temp[1]);
      int[] coins = getCoins(in.readLine());
      System.out.println(changeCaseCount(change, coins));
    }
  }

  public static int changeCaseCount(int change, int[] coins) {
    if (change < 0) {
      return 0;
    }
    
    int[][] table = new int[coins.length][change + 1];
    // 초기화
    for (int i = 0; i < coins.length; i++) {
      table[i][0] = 1;
    }
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j < change + 1; j++) {
        int withCoin = (j - coins[i]) >= 0 ? table[i][j - coins[i]] : 0;
        int withoutCoin = (i >= 1) ? table[i-1][j] : 0;
        table [i][j] = (withCoin + withoutCoin) % 1000000007;
      }
    }
    return table[coins.length - 1][change];
  }

  public static int[] getCoins(String temp) {
    String[] coinsStr = temp.split(" ");
    int[] coins = new int[coinsStr.length];
    for (int i = 0; i < coins.length; i++) {
      coins[i] = Integer.valueOf(coinsStr[i]);
    }
    return coins;
  }
}
