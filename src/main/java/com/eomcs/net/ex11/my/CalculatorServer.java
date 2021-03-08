/* 계산기 서버 만들기 
 1단계 : 단순히 클라이언트 요청에 응답하기
 2단계 : 응답의 종료 조건을 설정하기
 - 응답의 종료 조건을 설정하면 언제까지 읽어야 할 지 결정하기가 쉽다.
 - 응답을 완료했다면 빈 줄을 보내 응답을 완료했음을 표시한다.
 3단계 : 안내 메시지 전송 코드를 별도의 메서드로 분리한다.
 - 클라이언트가 접속했을 때 안내하는 문구를 보내느 코드를 별도의 메서드로 분리한다.\
 4단계 : 클라이언트가 보낸 요청을 받아 그대로 되돌려 준다.
 5단계 : 코드 리팩토링
 6단계 : 클라이언트가 보내 온 계산식을 실행하여 결과를 리턴한다.
 7단계 : 클라이언트의 종료 요청 'exit' 처리하기
 8단계 : 예외 처리 추가
 9단계 : 리팩토링 - 클라이언트의 요청을 처리하는 메서드를 별도의 클래스로 분리하기
10단계 : 여러 개의 클라이언트 접속 처리
- 반복문을 이용하여 계속해서 클라이언트의 접속을 처리한다.
- 문제점? 현재 작업 중인 클라이언트와의 연결이 끝날 때까지 다른 클라이언트는 대기열에서 기다려야한다.
11단계 : Stateful 방식을 Stateless 방식으로 전환
- 한 클라이언트의 한 번 접속에 한 번의 요청만 처리한다
12단계 : 동시에 여러 클라이언트의 요청을 처리하기
- 클라이언트 요청을 처리하는 코드를 main 실행과 분리하여 별도로 실행하게 한다
- 스레드 문법을 이용한다.


 */
package com.eomcs.net.ex11.my;
import java.net.ServerSocket;

public class CalculatorServer {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행중...");


      while (true) {
        // 클라이언트가 접속하면, 
        // 각 클라이언트의 요청을 main 실행에서 분리하여 별도로 실행해야 하기 때문에
        // 각 클라이언트에 대해 Thread 객체를 따로 만들어 실행한다.
        // 그래서 이전처럼 한 객체를 사용할 수는 없다.
        /*
         * RequestProcessor requestProcessor = new RequestProcessor();
         * requestProcessor.setSocket(serverSocket.accept()); requestProcessor.service();
         */
        RequestProcessor thread =  new RequestProcessor(serverSocket.accept());

        //run() 메서드를 직접 호출하면 안된다.
        //스레드에게 독립적으로 실행하라고 명령해야 한다.
        thread.start();
        //start() 메서드는 main 실행과 분리하여 별도의 실행 모드에서 run()을 호출한다.
        // 그런 후 run() 메서드가 리턴할 때까지 기다리지 않고 즉시 리턴한다.
        // 따라서 기존 클라이언트 요청을 처리하는데 시간이 걸리더라도
        // 다른 클라이언트는 영향을 받지 않는다.
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
