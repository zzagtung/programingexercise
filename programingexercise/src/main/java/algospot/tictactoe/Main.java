package algospot.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Main class for TICTACTOE game.
 * @see <a href="http://algospot.com/judge/problem/read/TICTACTOE">TICTACTOE</a>
 * 
 * @author Ryan
 * @date 2013. 11. 26.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    Main game = new Main();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String count = in.readLine();
    for (int i = 0; i < Integer.valueOf(count); i++) {
      String temp = in.readLine();
      temp = temp + in.readLine();
      temp = temp + in.readLine();
      String[] gameBoard = game.getGameBoardStatus(temp);
      while (game.checkWin(gameBoard).equals("PLAYING")) {
        game.play(gameBoard);
      }
      System.out.println(game.checkWin(gameBoard));
    }
  }
  
  public String nextPlayer(String[] gameBoard) {
    // 게임은 항상 x 가 먼저 진행.
    // x == o --> x
    // x > o --> o
    int xCount = 0;
    int oCount = 0;
    for (String cell : gameBoard) {
      if (cell.equals("X")) {
        xCount++;
      }
      else if (cell.equals("O")) {
        oCount++;
      }
    }
    return xCount - oCount == 0 ? "X" : "O";
  }
  
  public void play(String[] board) {
    String player = nextPlayer(board);
    int position = findPlace(board);
    board[position] = player;
  }
  
  public int findPlace(String[] board) {
    // 두개 인접하여 놓은 부분
    return 0;
  }
  
  public String checkWin(String[] gameBoard) {
    if (!gameBoard[0].equals(".") && gameBoard[0].equals(gameBoard[1]) && gameBoard[1].equals(gameBoard[2])) {
      return gameBoard[0];
    }
    else if (!gameBoard[0].equals(".") && gameBoard[0].equals(gameBoard[3]) && gameBoard[3].equals(gameBoard[6])) {
      return gameBoard[0];
    }
    else if (!gameBoard[0].equals(".") && gameBoard[0].equals(gameBoard[4]) && gameBoard[4].equals(gameBoard[8])) {
      return gameBoard[0];
    }
    else if (!gameBoard[1].equals(".") && gameBoard[1].equals(gameBoard[4]) && gameBoard[4].equals(gameBoard[7])) {
      return gameBoard[1];
    }
    else if (!gameBoard[2].equals(".") && gameBoard[2].equals(gameBoard[5]) && gameBoard[5].equals(gameBoard[8])) {
      return gameBoard[2];
    }
    else if (!gameBoard[2].equals(".") && gameBoard[2].equals(gameBoard[4]) && gameBoard[4].equals(gameBoard[6])) {
      return gameBoard[2];
    }
    else if (!gameBoard[3].equals(".") && gameBoard[3].equals(gameBoard[4]) && gameBoard[4].equals(gameBoard[5])) {
      return gameBoard[3];
    }
    else if (!gameBoard[6].equals(".") && gameBoard[6].equals(gameBoard[7]) && gameBoard[7].equals(gameBoard[8])) {
      return gameBoard[6];
    }
    else {
      boolean tie = true;
      for (String cell : gameBoard) {
        if (cell.equals(".")) {
          tie = false;
          break;
        }
      }
      return tie ? "TIE" : "PLAYING";
    }
    
  }
  
  public String[] getGameBoardStatus(String gameStatus) {
    String[] gameBoard = new String[9];
    int i = 0;
    for (char cell : gameStatus.toCharArray()) {
      gameBoard[i] = String.valueOf(cell);
      i++;
    }
    return gameBoard;
  }
}
