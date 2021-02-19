// 아규먼트에 람다(lambda) 활용 II - 파라미터와 리턴 값이 있는 람다 만들기
package com.eomcs.oop.ex12;

public class Exam0320 {

  static interface Calculator {
    int compute(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.compute(100, 200));
  }

  public static void main(String[] args) {
    // 람다 : 메서드 호출이 아니라 호출될 메서드를 정의 하는 것
    // 파라미터와 리턴 값이 있는 메서드 구현하기
    test((a, b) -> a + b);

  }

}


