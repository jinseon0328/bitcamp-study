// 클래스 정보 추출 - 클래스 이름 알아내기
package com.eomcs.reflect.ex02;

public class Exam01 {

  static class A {}

  static Object obj = new Object() {
    @Override
    public String toString() {
      return "익명 클래스";
    }
  };

  public static void main(String[] args) throws Exception {
    //1) 패키지 멤버 클래스
    Class<?> clazz = Class.forName("java.lang.String");
    // <?> 아무 클래스라고 말하는 것

    // '클래스의 타입 정보를 담은 객체'를 통해 클래스 정보를 추출할 수 있다.
    System.out.println(clazz.getSimpleName()); // String
    System.out.println(clazz.getName()); // java.lang.String
    System.out.println(clazz.getCanonicalName()); // java.lang.String
    System.out.println(clazz.getTypeName()); // java.lang.String

    System.out.println("------------------------------------------");

    //2) 중첩 클래스
    Class<?> clazz2 = Class.forName("com.eomcs.reflect.ex02.Exam01$A");

    // 클래스의 타입 객체를 통해 클래스 정보를 추출할 수 있다.
    System.out.println(clazz2.getSimpleName()); // A
    System.out.println(clazz2.getName()); // com.eomcs.reflect.ex02.Exam01$A
    System.out.println(clazz2.getCanonicalName()); // com.eomcs.reflect.ex02.Exam01.A
    // 자바 코드에서 쓰는 이름
    System.out.println(clazz2.getTypeName()); // com.eomcs.reflect.ex02.Exam01$A
    // 스트링으로 받을 때 쓰는 이름 원초적인 이름

    System.out.println("------------------------------------------");

    //3) 익명 클래스
    Class<?> clazz3 = obj.getClass(); // 익명 클래스의 인스턴스로부터 클래스 정보 추출

    // 클래스의 타입 객체를 통해 클래스 정보를 추출할 수 있다.
    System.out.println(clazz3.getSimpleName()); //
    System.out.println(clazz3.getName()); // com.eomcs.reflect.ex02.Exam01$1
    System.out.println(clazz3.getCanonicalName()); // null
    System.out.println(clazz3.getTypeName()); // com.eomcs.reflect.ex02.Exam01$1
    // 선언된 순서대로 $1 $2 이렇게 이름이 붙는다
  }

}
