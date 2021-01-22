package test.ex01;

public class Myclass {
  // 스태틱 필드(변수) = 클래스(변수)
  // - 클래스가 로딩된 후 자동으로 이 명령은 수행된다.
  static int a = 1;


  // 인스턴트 필드(변수)
  // - new 명령을 실행할 때 이 명령은 수행된다.
  int b = 10;


  static void m () {
    // 로컬 변수
    // - 메서드가 호출될 때 이 명령은 수행된다.
    int c;
    c = 100;

    System.out.println(c);
  }
}