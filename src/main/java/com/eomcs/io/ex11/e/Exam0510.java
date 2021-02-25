// 인스턴스 입출력 - 'transient' modifier
package com.eomcs.io.ex11.e;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam0510 {

  public static void main(String[] args) throws Exception {
    FileOutputStream fileOut = new FileOutputStream("temp/score.data");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 99;
    s.eng = 80;
    s.math = 92;
    s.compute();

    // serialize 대상에서 제외된 필드(transient가 붙은 필드)는 
    // 다음과 같이 저장해도 변경되지 않는다.
    s.sum = 300;
    s.aver = 100.0f;
    // serialize 할 때 transient가 붙은 필드의 값은 제외된다.
    out.writeObject(s);

    out.close();
    System.out.println("출력 완료!");
  }

}


