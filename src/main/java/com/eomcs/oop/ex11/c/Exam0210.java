// inner class : 다른 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B {
  // 클래스 멤버
  static int v1;
  static void m1() {}

  // 인스턴스 멤버
  int v2 = 10;
  int v3 = 20; 
  int v4 = 30;
  void m2() {}

  // 얘도 인스턴스 멤버
  class X {
    int v2 = 100;
    int v3 = 200; 
    void test() {
      // 같은 클래스 멤버 접근 가능
      System.out.println(B.v1);
      B.m1();
      System.out.println("-------------------------");

      // 바깥 클래스 이름 생략 가능
      v1 = 200; 
      m2(); 

      // 인스턴스 멤버에 접근 가능
      // => 바깥클래스명.this.인스턴스멤버명
      B.this.v2 = 10;
      B.this.v3 = 200;
      B.this.v4 = 100;
      B.this.m2();

      // 바깥클래스명.this 는 생략가능
      // => 로컬 변수와 같은 이름이 아니라면 생략 가능
      v2 = 300; 

      // => 해당 클래스의 멤버와 같은 이름이 아니라면 생략 가능
      // => inner class 의 가장 큰 특징은 바깥 클래스의 다른 멤버에 손쉽게 접근할 수 있다는 것이다.
      // => 이것이 가능한 이유는 바깥 클래스의 인스턴스 멤버이기 때문이다.
      v2 = 100; //=> this.v2 -> A 클래스의 인스턴스 변수이다.
      m2();
    }
  }
}

public class Exam0210 {

  public static void main(String[] args) {
    B outer = new B();

    B.X obj = outer.new X();
    obj.test();

    System.out.println(B.v1);
    System.out.println(outer.v2);
  }

}
