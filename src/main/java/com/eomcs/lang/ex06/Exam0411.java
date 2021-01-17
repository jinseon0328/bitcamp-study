package com.eomcs.lang.ex06;

//# 흐름 제어문 - for 반복문
//
public class Exam0411 {
  public static void main(String[] args) {
    // for (변수선언 및 초기화; 조건; 증감문) 문장;
    // -> 변수 선언 및 초기화 -> 조건 -> 참이면 -> 문장 -> 증감문 
    // -> 다시 조건 -> 참이면 -> 문장 -> 증감문 
    // 거짓일 때까지 계속 반복
    // for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

    // 증감문 제거
    for (int i = 1; i <= 5;) {
      System.out.println(i);
      i++;
    }

  }
}
