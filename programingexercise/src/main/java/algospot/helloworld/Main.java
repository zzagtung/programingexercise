package algospot.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Main class.
 * @see <a href="http://algospot.com/judge/problem/read/HELLOWORLD">HELLOWORLD</a>
 * 
 * @author Ryan
 * @date 2013. 11. 19.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String name = null;
    String count = in.readLine();
    for (int i = 0; i < Integer.valueOf(count); i++) {
      name = in.readLine();
      System.out.println("Hello, " + name + "!");
    }
  }
}
