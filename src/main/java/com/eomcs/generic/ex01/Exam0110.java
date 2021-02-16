// 제네릭(generic) 적용 전 - Object를 이용한 다형적 변수 사용
package com.eomcs.generic.ex01;

import java.util.Calendar;
import java.util.Date;

public class Exam0110 {

  public static Object echo(Object obj) {
    // 타입이 Object이므로 이 객체의 값은 어떤 타입도 가능하다
    return obj;
  }

  public static void main(String[] args) {

    // echo() 리턴 타입이 Object이기 때문에 String 레퍼런스로 바로 받을 수 없다.
    // => 해결책? 형변환 해야 한다.
    //
    //String obj = echo(new String("Hello")); // 컴파일 오류!
    // echo는 Object 타입인데 obj는 Object 타입이 아닌 String 변수에 담겠다고 했으므로 문법 오류
    // 실제로는 String 타입이 들어 있어도 컴파일러는 문법을 정확하게 지키므로 오류가 난다
    String obj = (String) echo(new String("Hello"));
    //           ------- 이렇게 형변환 해야한다
    String obj2 = (String) echo(new Integer("Hello"));
    // Okay! 컴파일러 입장에서는 문법적으로 맞으므로 이건 가능하다

    // 잘못된 형변환은 컴파일러는 속일 수 있을 지라도, runtime 에서는 오류를 발생시킨다.
    //Integer obj2 = (Integer) echo(new String("Hello")); // 실행 오류!

    Date obj3 = (Date) echo(new Date());

    Calendar obj4 = (Calendar) echo(Calendar.getInstance());
  }

}
