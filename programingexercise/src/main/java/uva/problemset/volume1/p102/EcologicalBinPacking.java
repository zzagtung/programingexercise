package uva.problemset.volume1.p102;

import java.util.Map;

/**
 * The EcologicalBinPacking class.
 * @see <a href="http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=38">Volume 1. 102 문제.</a>
 * 
 * @author Ryan
 * @date 2013. 11. 19.
 */
public class EcologicalBinPacking {

  static int min;
  static String minBinStr = "BGC";

  public static void main(String[] args) {
    // String input = "5 10 5 20 10 5 10 20 10";
    // String input = "1 2 3 4 5 6 7 8 9";
    String input = "9 8 7 6 5 4 3 2 1";
    String[] temp = input.split(" ");
    RecycleBin bin1 = new RecycleBin(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
    RecycleBin bin2 = new RecycleBin(Integer.valueOf(temp[3]), Integer.valueOf(temp[4]), Integer.valueOf(temp[5]));
    RecycleBin bin3 = new RecycleBin(Integer.valueOf(temp[6]), Integer.valueOf(temp[7]), Integer.valueOf(temp[8]));

    Map<BottleType, Integer> bin1Move = bin1.getBottleMovement(bin2, bin3);
    Map<BottleType, Integer> bin2Move = bin2.getBottleMovement(bin1, bin3);
    Map<BottleType, Integer> bin3Move = bin3.getBottleMovement(bin1, bin2);

    // System.out.println(bin1.getBottleMovement(bin2, bin3));
    // System.out.println(bin2.getBottleMovement(bin1, bin3));
    // System.out.println(bin3.getBottleMovement(bin1, bin2));

    // CASE 'BGC'
    int BGC = bin1Move.get(BottleType.BROWN) + bin2Move.get(BottleType.GREEN) + bin3Move.get(BottleType.CLEAR);
    min(BGC, BGC, "BGC");
    // CASE 'BCG'
    int BCG = bin1Move.get(BottleType.BROWN) + bin2Move.get(BottleType.CLEAR) + bin3Move.get(BottleType.GREEN);
    min(min, BCG, "BCG");
    // CASE 'CBG'
    int CBG = bin1Move.get(BottleType.CLEAR) + bin2Move.get(BottleType.BROWN) + bin3Move.get(BottleType.GREEN);
    min(min, CBG, "CBG");
    // CASE 'CGB'
    int CGB = bin1Move.get(BottleType.CLEAR) + bin2Move.get(BottleType.GREEN) + bin3Move.get(BottleType.BROWN);
    min(min, CGB, "CGB");
    // CASE 'GBC'
    int GBC = bin1Move.get(BottleType.GREEN) + bin2Move.get(BottleType.BROWN) + bin3Move.get(BottleType.CLEAR);
    min(min, GBC, "GBC");
    // CASE 'GCB'
    int GCB = bin1Move.get(BottleType.GREEN) + bin2Move.get(BottleType.CLEAR) + bin3Move.get(BottleType.BROWN);
    min(min, GCB, "GCB");

    // Collections.sort(bottlesInBins);
    // System.out.println(bottlesInBins);

    // System.out.println(bottlesInBins.get(0) + " " + min);
    System.out.println(minBinStr + " " + min);
  }

  private static void min(int a, int b, String binStr) {
    if (a == b) {
      // System.out.println(minBinStr + ", " + binStr + ", " +
      // minBinStr.compareTo(binStr));
      minBinStr = minBinStr.compareTo(binStr) < 0 ? minBinStr : binStr;
      // bottlesInBins.add(binStr);
      min = b;
    }
    else if (a > b) {
      // bottlesInBins = new ArrayList<String>();
      // bottlesInBins.add(binStr);
      minBinStr = binStr;
      min = b;
    }
    else {
      min = a;
    }
  }
}