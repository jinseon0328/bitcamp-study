// 버퍼 사용 전 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;
    while ((b = in.read()) != -1) { // 무조건 1바이트씩 읽을 때
      callCount++; // 파일을 끝까지 읽는다.
      // 한번 읽을 때마다 카운트를 증가 시킨다
    }

    long endTime = System.currentTimeMillis();
    // 나가자마자 현재 시간을 측정해서 변수에 담는다

    System.out.println(endTime - startTime);
    System.out.println(callCount);

    in.close();
  }

}
