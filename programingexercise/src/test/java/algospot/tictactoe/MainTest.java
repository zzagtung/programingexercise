package algospot.tictactoe;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class MainTest {

  @Test
  public void testNextPlayer() throws Exception {
    Main game = new Main();
    String[] board = {".",".",".",".",".",".",".",".","."};
    String player = game.nextPlayer(board);
    assertThat(player, is("X"));
    String[] board2 = {".",".",".","X","X",".","O","O","."};
    String player2 = game.nextPlayer(board2);
    assertThat(player2, is("X"));
    String[] board3 = {"X","O","X","O","O",".","X",".","X"};
    String player3 = game.nextPlayer(board3);
    assertThat(player3, is("O"));
  }

  @Test
  public void testGetGameBoardStatus() throws Exception {
    Main game = new Main();
    String in = ".........";
    String[] board = game.getGameBoardStatus(in);
    assertThat(board.length, is(9));
    assertThat(board[1], is("."));
    in = "...XX.OO.";
    String[] board2 = game.getGameBoardStatus(in);
    assertThat(board2.length, is(9));
    assertThat(board2[3], is("X"));
    assertThat(board2[4], is("X"));
    assertThat(board2[6], is("O"));
    assertThat(board2[8], is("."));
  }

  @Test
  public void testCheckWin() throws Exception {
    Main game = new Main();
    String[] board1 = {"X","X","X","O","O",".","O",".","."};
    String win = game.checkWin(board1);
    assertThat(win, is("X"));
    String[] board2 = {"X","X","O","X","X","O","O","O","X"};
    win = game.checkWin(board2);
    assertThat(win, is("X"));
    String[] board3 = {"X","O","X","O","O",".","X","O","X"};
    win = game.checkWin(board3);
    assertThat(win, is("O"));
    String[] board4 = {"O","X","X","X","X","O","O","O","X"};
    win = game.checkWin(board4);
    assertThat(win, is("TIE"));
    String[] board5 = {".",".",".","O","O",".","X","X","X"};
    win = game.checkWin(board5);
    assertThat(win, is("X"));
    String[] board6 = {"O","X","X","O","X","X","O","O","."};
    win = game.checkWin(board6);
    assertThat(win, is("O"));
    String[] board7 = {"X","X",".","O","O",".",".",".","."};
    win = game.checkWin(board7);
    assertThat(win, is("PLAYING"));
  }

}
