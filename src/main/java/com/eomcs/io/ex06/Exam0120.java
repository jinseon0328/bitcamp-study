// 버퍼 사용 후 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    byte[] buf = new byte[8192]; // 보통 8KB 정도 메모리를 준비한다. (균형점)
    //                   ----- 81920000 8MB도 가능하지만 이것은 desk프로그램이고 
    //                         내가 만들어야 하는 건 서버 프로그램이므로 서버에서 실행한다고 가정해야한다
    //                         서버란 동시에 여러명이 한꺼번에 쓰는 프로그램이므로
    //                         너무 작게 잡아도 속도가 떨어지고 너무 크게 잡아도 속도가 떨어진다
    int len = 0;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;
    while ((len = in.read(buf)) != -1) { 
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount);
    in.close();
  }

}
