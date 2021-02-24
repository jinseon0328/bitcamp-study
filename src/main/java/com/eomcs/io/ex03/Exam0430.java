// Character Stream - 텍스트 읽기 II
package com.eomcs.io.ex03;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exam0430 {

  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("temp/test2.txt");
    // Scanner(System.in) 하고 쓰듯이 FileReader를 그냥 쓰면 불편하다

    // 데코레이터를 붙인다.
    // => 버퍼 기능 + 한 줄 읽기 기능
    BufferedReader in2 = new BufferedReader(in);

    System.out.println(in2.readLine());

    in.close();
  }

}


