package test.ex06;

public class App {
  public static void main(String[] args) {

    // 식: 2 *3 + 7 - 2 = 11
    // 식: 12 / 4 -5 = -2
    Calculator r1 = new Calculator();
    Calculator r2 = new Calculator();

    r1.result = 0;
    r2.result = 0;

    //Calculator.plus(2); -> 오류
    // 메서드를 사용할 때는 이 메소드가 소속된 인스턴스 주소를 넣도록 하는 규칙
    r1.plus(2);
    r1.multiple(3);
    r1.plus(7);
    r1.minus(2);

    r2.plus(12);
    r2.divide(4);
    r2.minus(5);

    System.out.println(r1.result);
    System.out.println(r2.result);



  }

}
