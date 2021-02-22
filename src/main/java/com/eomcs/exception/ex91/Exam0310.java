// 예외의 종류 - 애플리케이션 예외
package com.eomcs.exception.ex91;

public class Exam0310 {

  public static void main(String[] args) {

    try {
      int result = 100 / 0;
      System.out.printf("계산 결과 = %d\n", result);

    } catch (Throwable e) {
      // 예외에 대한 상세 정보 출력
      e.printStackTrace();
      //e로 객체를 받아서 어느부분에서 예외가 일어났는지 자세히 나온다
    }

  }
}

// 애플리케이션 예외
// - 애플리케이션 명령 처리 중 발생하는 예외이다.
// - java.lang.Exception 타입의 예외이다.
// Exception의 서브클래스이다
// - catch 블록에서 적절한 조치를 취한 후
//   프로그램을 계속 실행하게 할 수 있다.
//
// [java.lang.Exception]
// - 애플리케이션 예외가 발생할 때 전달되는 예외 객체이다.
// - 애플리케이션 예외 정보를 담고 있다.
// - 클래스 계층도
//   java.lang.Object
//      ㄴ java.lang.Throwable
//           ㄴ java.lang.Exception
// - 애플리케이션 예외 예:
//   ArrayIndexOutOfBoundsException, ClassCastException,
//   존재하지 않는 배열을 호출
//   ClassNotFoundException, CloneNotSupportedException,
//   NullPointerException, IOException, SQLException,
//                         입출력하려고 하는데 파일이 없음 파일이 잠겨서 권한이 없음
//   FileNotFoundException, SocketException, MalformedURLException,
//                    저쪽 컴퓨터에 연결하려고 하는데 서버가 실행되고 있지 않음
//   RuntimeException, ArithmeticException 등
//
//
// 예외 클래스 계층도
// [java.lang.Throwable]
//     ㄴ java.lang.Error : 시스템 예외
//     ㄴ java.lang.Exception : 애플리케이션 예외
//
















