/* 계산기 클라이언트 만들기 
 1단계 : 단순히 서버에 요청하고 응답을 받아 출력하기
 2단게 : 응답의 종료 조건을 설정하기
 - 응답의 종료 조건을 설정하면 언제까지 읽어야 할 지 결정하기 쉽다.
 - 빈 줄을 받을 때까지 응답을 읽어 출력한다.
 3단계 : 응답을 읽는 코드를 별도의 메서드로 분리한다.
 - 기능 별로 메서드를 분리하면 코드를 관리하기가 편하다.
 4단계 : 사용자로부터 계산식을 입력 받아서 서버에 전달한다.
 5단계 : 코드 리팩토링
 6단계 : 사용자에게 프롬프트를 제시하고 계산식을 입력 받기
 7단계 : 프로그램 종료 명령 'exit' 처리하기
 8단계 : 예외 처리 추가 (Client는 변경 사항 없음)
 9단계 : 리팩토링 (Client는 변경 사항 없음)
 10단계 : 여러 개의 클라이언트 접속 처리 (Client는 변경 사항 없음)
 11단계 : Stateful 방식을 Stateless 방식으로 전환
 - 요청할 때 연결해서 요청이 끝나면 즉시 연결을 끊는다.
 - Stateless 방식은 요청 때마다 연결하기 때문에 요청을 처리하는데 연결 시간이 추가되는 문제가 있다.
 - 즉 한 번에 한 클라이언트의 요청을 처리하기 때문에
   특정한 클라이언트 서버가 묶이는 현상이 덜한다.
 - 서버 입장에서는 클라이언트의 대기 시간을 줄일 수 있다.
 - 클라이언트 입장에서도 다른 클라이언트가 서버를 독점하는 것을 피할 수 있다.
 12단계 : 동시에 여러 클라이언트 요청을 처리하기 (Client는 변경 사항 없음)
 - 스레드를 이용하면 동시에 여러 클라이언트 요청을 처리할 수 있다.

 */
package com.eomcs.net.ex11.my;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {
    Scanner keyboardScanner = new Scanner(System.in);

    //클라이언트 접속에 대해 더이상 안내 메시지를 제공하지 않는다.
    //readResponse(in); // 서버의 인사말 받기

    while (true) {
      String input = prompt (keyboardScanner);
      if (input == null) {
        continue;
      } else if (input.equalsIgnoreCase("exit")) {
        //exit 명령을 입력할 경우 서버에 접속할 필요가 없이 즉시 클라이언트를 종료한다.
        break;
      }
      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        sendRequest(out, input); // 서버에 요청을 보내기
        readResponse(in); // 서버의 실행 결과를 출력

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    keyboardScanner.close();   
  }

  static String prompt(Scanner keyboardScanner) {
    System.out.print("계산식>");
    String input = keyboardScanner.nextLine();

    if (input.equalsIgnoreCase("exit")) {
      return input;

    } else if (input.split(" ").length != 3) { // 사용자가 입력한 값을 검증
      System.out.println("입력 형식이 올바르지 않습니다. 예) 23 + 5");
      return null;
    }
    return input;
  }

  static void sendRequest(PrintStream out, String message) throws Exception {
    out.println(message);
    out.flush();
  }

  static void readResponse(BufferedReader in) throws Exception {
    while (true) {
      String input = in.readLine();
      if (input.length() == 0) {
        // 빈 줄을 읽었다면 읽기를 끝낸다.
        break;
      }
      System.out.println(input);
    }
  }

}
