package uva.problemset.volume1.p102;

import java.util.HashMap;
import java.util.Map;

public class RecycleBin {
  private int brown;
  private int green;
  private int clear;
  public RecycleBin() {}
  public RecycleBin(int brown, int green, int clear) {
    this.brown = brown;
    this.green = green;
    this.clear = clear;
  }
  public int getBrown() {
    return brown;
  }
  public void setBrown(int brown) {
    this.brown = brown;
  }
  public int getGreen() {
    return green;
  }
  public void setGreen(int green) {
    this.green = green;
  }
  public int getClear() {
    return clear;
  }
  public void setClear(int clear) {
    this.clear = clear;
  }
  
  public Map<BottleType, Integer> getBottleMovement(RecycleBin bin2, RecycleBin bin3) {
    Map<BottleType, Integer> result = new HashMap<BottleType, Integer>();
    result.put(BottleType.BROWN, bin2.getBrown() + bin3.getBrown());
    result.put(BottleType.GREEN, bin2.getGreen() + bin3.getGreen());
    result.put(BottleType.CLEAR, bin2.getClear() + bin3.getClear());
    return result;
  }
}
