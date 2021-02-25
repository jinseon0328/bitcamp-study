// 파일 입출력의 close() 호출
package com.eomcs.io.ex12.d;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_1 {
  public static void main(String[] args) {

    FileOutputStream out1 = null;
    BufferedOutputStream out2 = null;
    DataOutputStream out3 = null;

    try {
      out1 = new FileOutputStream("temp3/data.bin");
      out2 = new BufferedOutputStream(out1);
      out3 = new DataOutputStream(out2);

      out3.writeInt(0x11223344);

    } catch (IOException e) {
      System.out.println("파일 입출력 예외 발생!");
      e.printStackTrace();

    } finally {
      // 입출력 객체를 닫을 때는 가장 바깥의 객체부터 닫아라!
      try {out3.close();} catch (Exception e2) {}

      // 가장 마지막에 연결한 데코레이터를 닫으면 굳이
      // 다음과 같이 이전에 연결한 객체를 닫을 필요가 없다.
      // 그래도 클로즈 를 명시적으로 호출하고 싶다면,
      // 가장 마지막에 연결된 순서대로 
      try {out2.close();} catch (Exception e2) {}
      try {out1.close();} catch (Exception e2) {}

    }

    System.out.println("출력 완료!");
  }
}








