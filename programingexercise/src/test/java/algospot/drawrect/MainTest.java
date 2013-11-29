package algospot.drawrect;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class MainTest {

  @Test
  public void testLastRectPoint() throws Exception {
    Main main = new Main();
    int[] p4 = main.lastRectPoint(new int[]{5,5}, new int[]{5,7},new int[]{7,5});
    assertThat(p4, equalTo(new int[]{7,7}));
  }

  @Test
  public void testRectPoint() throws Exception {
    String in = "5 7";
    Main main = new Main();
    int[] p1 = main.rectPoint(in);
    assertThat(p1.length, equalTo(2));
    assertThat(p1[0], equalTo(5));
    assertThat(p1[1], equalTo(7));
  }

}
