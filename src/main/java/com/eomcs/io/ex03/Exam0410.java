// Character Stream - String 출력하기
package com.eomcs.io.ex03;

import java.io.FileWriter;

public class Exam0410 {

  public static void main(String[] args) throws Exception {
    FileWriter out = new FileWriter("temp/test2.txt");

    String str = new String("AB가각");

    // 바로 출력할 수 있다 -> 물론 UTF-8로
    out.write(str); 

    out.close();

    System.out.println("데이터 출력 완료!");

  }

}
