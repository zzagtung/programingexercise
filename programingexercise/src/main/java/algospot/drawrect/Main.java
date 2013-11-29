package algospot.drawrect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Main class for <a href="http://algospot.com/judge/problem/read/DRAWRECT">DRAWRECT</a>
 * 
 * @author Ryan
 * @date 2013. 11. 29.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    Main draw = new Main();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String count = in.readLine();
    for (int i = 0; i < Integer.valueOf(count); i++) {
      int[] p1 = draw.rectPoint(in.readLine());
      int[] p2 = draw.rectPoint(in.readLine());
      int[] p3 = draw.rectPoint(in.readLine());
      int[] p4 = draw.lastRectPoint(p1, p2, p3);
      System.out.println(p4[0] + " " + p4[1]);
    }
  }
  
  public int[] rectPoint(String in) {
    String[] temp = in.split(" ");
    int[] point = new int[temp.length];
    for (int i = 0; i < point.length; i++) {
      point[i] = Integer.valueOf(temp[i]);
    }
    return point;
  }
  
  public int[] lastRectPoint(int[] p1, int[] p2, int[] p3) {
    int[] p4 = new int[2];
    for (int i = 0; i < 2; i++) {
      if (p1[i] == p2[i]) {
        p4[i] = p3[i];
      }
      else if (p2[i] == p3[i]){
        p4[i] = p1[i];
      }
      else if (p1[i] == p3[i]) {
        p4[i] = p2[i];
      }
    }
    return p4;
  }
}
