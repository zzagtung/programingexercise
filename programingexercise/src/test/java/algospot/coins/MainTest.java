package algospot.coins;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class MainTest {

  @Test
  public void testGet동전종류() throws Exception {
    int[] 동전종류 = Main.getCoins("10 50 100 500");
    assertThat(동전종류, is(notNullValue()));
    assertThat(동전종류.length, is(4));
    assertThat(동전종류[1], is(50));
    동전종류 = Main.getCoins("1 2 4 8 16 32 64 128");
    assertThat(동전종류.length, is(8));
    assertThat(동전종류[5], is(32));
  }

  @Test
  public void test경우의수구하기() throws Exception {
    int[] 동전종류 = Main.getCoins("10 50 100 500");
    System.out.println(Main.changeCaseCount(110, 동전종류));
  }
}
