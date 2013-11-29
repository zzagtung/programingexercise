package algospot.encrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Main class for <a href="http://algospot.com/judge/problem/read/ENCRYPT">ENCRYPT</a>
 * 
 * @author Ryan
 * @date 2013. 11. 29.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    Main encrypt = new Main();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String count = in.readLine();
    for (int i = 0; i < Integer.valueOf(count); i++) {
      String input = in.readLine();
      System.out.println(encrypt.encrypt(input));
    }
  }
  
  public String encrypt(String input) {
    char[] encrypted = new char[input.length()];
    char[] temp = new char[input.length()/2];
    int count = 0; // 앞자리로 이동한 글자 개수.
    int tempIndex = 0;
    for (int i = 0; i < input.length(); i++) {
      if (i % 2 == 0) {
        encrypted[i] = input.charAt(i); 
        count++;
      }
      else {
        temp[tempIndex] = input.charAt(i);
        tempIndex++;
      }
    }
    for (int i = 0; i < tempIndex; i++) {
      encrypted[count+i] = temp[i];
    }
    return String.valueOf(encrypted);
  }
}
