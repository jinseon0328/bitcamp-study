package test.util;

public class test1 {
  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(100);
    c.minus(20);
    c.plus(100, 200);
    c.minus(30, 40);
    // c.result = 200;
    System.out.println(c.getResult());
  }
}
