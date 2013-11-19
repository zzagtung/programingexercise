package uva.problemset.volume1.p102;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class RecycleBinTest {

  RecycleBin bin1;
  RecycleBin bin2;
  RecycleBin bin3;
  
  @Before
  public void setUp() {
//    bin1 = new RecycleBin(1, 2, 3);
//    bin2 = new RecycleBin(4, 5, 6);
//    bin3 = new RecycleBin(7, 8, 9);
    bin1 = new RecycleBin(5, 10, 5);
    bin2 = new RecycleBin(20, 10, 5);
    bin3 = new RecycleBin(10, 20, 10);
  }
  
  @Test
  public void test() {
    Map<BottleType, Integer> bin1Move = bin1.getBottleMovement(bin2, bin3);
    Map<BottleType, Integer> bin2Move = bin2.getBottleMovement(bin1, bin3);
    Map<BottleType, Integer> bin3Move = bin3.getBottleMovement(bin1, bin2);
    System.out.println(bin1Move);
    System.out.println(bin2Move);
    System.out.println(bin3Move);
  }
}
