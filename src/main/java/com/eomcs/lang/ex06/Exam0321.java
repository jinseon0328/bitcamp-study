package com.eomcs.lang.ex06;

//# 흐름 제어문 - break와 continue 활용
//
public class Exam0321 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;


    // 1부터 100까지의 짝수의 합은?
    // => continue 사용 전
    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count % 2 == 0) {
        //      --- & 0b000000000_00000000_00000000_000000001 (2진수)
        //          & 0x00_00_00_01 (16진수)
        //          & 0x01 ==> count % 2의 다른 표현
        sum += count;
      }
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);

    System.out.println("------------------------");

    // => continue 사용 후
    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count % 2 == 1)
        continue; // 다음 문장을 실행하지 않고 즉시 조건 검사로 이동한다.
      // 조건 문장으로 다시 간다 홀수인 경우는 sum += count; 문장으로 가지 않고
      // 다시 돌아간다
      sum += count;
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);
  }
}
