// 메서드 정보 추출
package com.eomcs.reflect.ex03;

import java.lang.reflect.Method;

public class Exam01 {
  public static void m1() {} // 클래스 메서드 = 스태틱 메서드

  public void m2() {} // 인스턴스가 있어야만 쓰는 메서드 인스턴스 메서드 = 논스태틱 메서드

  protected void m3() {}

  void m4() {}

  private void m5() {}

  public static void main(String[] args) {
    Class<?> clazz = Exam01.class;

    // 클래스에서 메서드 정보를 추출하기
    // => 해당 클래스에 선언된 public 메서드 + 상속 받은 public 메서드(수퍼 클래스의 메서드)
    Method[] list = clazz.getMethods();
    for (Method m : list) {
      System.out.println(m.getName());
    }
  }

}


