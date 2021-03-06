// 오버라이딩(overriding) - 오버라이딩 실수의 예
package com.eomcs.oop.ex06.c;

class B {
  void m(int a) {
    System.out.println("B의 m()");
  }
}


class B2 extends B {
  // 오버라이딩 문법
  // => 메서드명, 파라미터 형식, 리턴 타입이 같아야 한다.
  // => 파라미터의 이름은 달라도 된다. 상관없다.
  //
  void m(float x) {
    // 그런데 이 메서드는 실수로 파라미터 타입을 float으로 했다.
    // 이것은 오버라이딩이 아니라 오버로딩이 된 것이다.
    // 즉 float 파라미터를 받는 m() 메서드가 추가된 것이다.
    // 그런데 개발자는 오버라이딩(재정의)을 했다고 착각하고 사용할 것이다.
    System.out.println("B2의 m()");
  }
}


class B3 extends B {
  // 오버라이딩 문법 검사
  // => 오버라이딩을 제대로 했는지 컴파일러에게 검사하도록 요청할 수 있다.
  // => 어떻게?
  //    메서드 정의 앞에 @Override를 붙여라
  @Override // <= 컴파일러야, 내가 상속받은 메서드를 재정의한다고 했는데, 혹시 실수는 없는지 검사해 줄래?
  void m(int x) {
    // 오버라이딩을 한다고 하면서 파라미터의 타입이나 개수, 순서를 달리해서
    // 오버로딩이 되는 경우가 있기 때문에
    // 이를 방지하기 위해 오버라이딩을 하는 메서드 앞에
    // @Override 애노테이션을 붙임으로써 잘못 사용하는 경우를 방지할 수 있다.
    //
    System.out.println("B3의 m()");
  }
}

public class Exam0210 {

  public static void main(String[] args) {
    // 1) 오버라이딩을 잘못한 예:
    test1();

    // 2) @Override를 이용해 오버라이딩의 실수를 방지한 예:
    //    test2();
  }

  static void test1() {
    B2 obj = new B2();

    // B2에서 B의 m() 메서드를 오버라이딩(재정의) 했다고 착각하고
    // 메서드를 사용할 수 있다.
    // => 그런데 B2 클래스를 가보면 m()의 파라미터가 float이다.
    //    즉 오버라이딩을 한 게 아니라 오버로딩을 한 것이 된다.
    obj.m(100); // B의 m(int) 메서드를 호출
    obj.m(3.14f); // B2의 m(float) 메서드를 호출

    // 해결책?
    // => 개발자들의 이런 실수가 많이 발생해서 자바에서는
    //    오버라이딩 여부를 검사하는 특별한 문법을 추가하였다.
  }

  static void test2() {
    B3 obj = new B3();
    obj.m(100); // B3의 m(int) 호출

    // B3 클래스에서는 m() 메서드를 제대로 오버라이딩 하였다.
    // @Override ?
    // => 애노테이션 문법이다.
    // => 컴파일러나 JVM에게 전달하는 특별한 주석이다.
    // => 개발자도 자신의 애노테이션을 정의하고 사용할 수 있다.
    //    나중에 따로 배운다!

  }
}








