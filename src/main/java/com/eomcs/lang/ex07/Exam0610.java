package com.eomcs.lang.ex07;

// # JVM 아규먼트
//
public class Exam0610 {

  public static void main(String[] 변수명은상관없다) {
    // JVM 아규먼트?
    // 자바 버추얼머신 환경변수에 넣어 값을 쓸 때
    // - JVM에게 전달하는 값
    // - 형식
    // $java -cp ./bin/main -D이름=값 -D이름=값 -D이름=값 com.eomcs.lang.ex07.Exam0610
    //

    // JVM 아규먼트의 값 꺼내기
    // => System.getProperty("이름");
    //
    String value1 = System.getProperty("a");
    String value2 = System.getProperty("b");
    String value3 = System.getProperty("c");

    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
  }
}


