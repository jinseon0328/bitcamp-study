// 스태틱 초기화 블록(static initializer) - 활용
package com.eomcs.oop.ex03;

public class Exam0690 {

  public static class A {
    static float pi;
    // => static float pi = 3.14159f; 이렇게 추천하지만
    // 복잡한 경우에는 static 블록을 쓸수밖에 없다

    static float area(int r) {
      return pi * r * r;
    }

    // 스태틱 블록은 클래스 멤버를 사용하기 전에 유효한 값으로 초기화시키는 것.
    static {
      pi = 3.14159f;
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println(A.area(25));
  }
}


