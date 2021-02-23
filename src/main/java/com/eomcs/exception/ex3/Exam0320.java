// 던지는 예외를 메서드에 선언하기 - 사용자 정의 예외 만들기
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0320 {

  // 공통 분모를 사용하여 퉁치는 방법
  // => 메서드에서 발생하는 예외의 공통 수퍼 클래스를 지정하여
  // 여러 개를 나열하지 않을 수 있다.
  // => 그러나 호출자에게 어떤 오류가 발생하는지 정확하게 알려주는 것이
  // 유지보수에 도움이 된다.
  // 따라서 가능한 그 메서드에서 발생하는 예외는 모두 나열하라!

  // 사용자 정의 예외는 사실상 큰 코드 기능에서 차이는 없다
  // 직관적으로 메서드를 쓰는 사람이 알아 볼 수 있도록 이름을 다르게 한 것일 뿐이다
  //
  static void m(int i) throws Exception {
    //                          빵
    if (i == 0)
      throw new Exception();
    //           소보루빵
    else if (i == 1)
      throw new RuntimeException();
    //             쉬폰빵
    else if (i == 2)
      throw new SQLException();
    //            슈크림빵
    else
      throw new IOException();
    //             도넛빵
  }

  public static void main(String[] args) {}

}
