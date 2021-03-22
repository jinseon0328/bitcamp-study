// 던지는 예외 받기 - 예외 처리 책임을 상위 호출자에게 위임
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0421 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else
      throw new IOException();
  }


  // 메서드 안에서 발생하는 예외에 대해
  // 메서드 선언부에 모두 적지 않고,
  // 그 예외들의 공통 분모에 해당하는 슈퍼 클래스만 적어도 된다.
  public static void main(String[] args) throws Exception {
    // 예외 처리 방법 1:
    // - 예외를 처리하고 싶지 않다면 상위 호출자에게 책임을 떠넘길 수 있다.
    m(1);
  }
}