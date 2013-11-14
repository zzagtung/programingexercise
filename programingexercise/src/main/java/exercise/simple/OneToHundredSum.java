package exercise.simple;

public class OneToHundredSum {

  public static void main(String[] args) {
    int value = 0;
    if (args.length == 0) {
      value = 100;
    }
    else {
      try {
        value = Integer.valueOf(args[0]);
      }
      catch (NumberFormatException e) {
        System.out.println("숫자만 입력 가능 함.");
      }
    }
    
    if (value > 100) {
      System.err.println("1 이상 100 이하 숫만 입력 가능 함.");
      System.exit(-1);
    }
    int sum = 0;
    for (int i = 1; i <= value; i++) {
      sum = sum + i;
    }
    System.out.println("1 부터 " + value + "까지 합은 : " + sum);
  }
}
