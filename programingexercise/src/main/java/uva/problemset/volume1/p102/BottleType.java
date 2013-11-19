package uva.problemset.volume1.p102;

public enum BottleType {
  BROWN("B"), GREEN("G"), CLEAR("C");
  
  String bottleType;
  BottleType(String type) {
    this.bottleType = type;
  }
  
  public String getValue() {
    return bottleType;
  }
}
