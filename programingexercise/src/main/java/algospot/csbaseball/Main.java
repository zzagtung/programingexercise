package algospot.csbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Main class for CSBASEBALL
 * @see <a href="http://algospot.com/judge/problem/read/CSBASEBALL">CSBASEBALL</a>
 * 
 * @author Ryan
 * @date 2013. 11. 25.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    Main csbaseball = new Main();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String count = in.readLine();
    for (int i = 0; i < Integer.valueOf(count); i++) {
      int[] scores = csbaseball.getScores(in.readLine());
      System.out.println(csbaseball.hitCountForScore(scores[0], scores[1]));
    }
  }
  
  public int hitCountForScore(int csTeamScore, int pintosTeamScore) {
    if (csTeamScore > pintosTeamScore) {
      return 0;
    }
    else {
      return 4 + pintosTeamScore - csTeamScore;
    }
  }
  
  public int[] getScores(String scoresStr) {
    String[] temp = scoresStr.split(" ");
    int[] scores = new int[temp.length];
    for (int i = 0; i < scores.length; i++) {
      scores[i] = Integer.valueOf(temp[i]);
    }
    return scores;
  }
}
