
package test;

public class App6 {

  public static void main(String[] args) {
    //회원정보를 저장할 새로운 메모리 구조를 설계한다.
    // 사용자(개발자) 정의 데이터 타입
    //
    //메모리 설계도
    class Member{
      String name;
      int age;
      boolean working;
    }

    //설계도에 따라 준비한 변수 및 레퍼런스
    Member m1 = new Member();
    Member m2 = new Member();
    Member m3 = new Member();
    // m1 -> 설계도에 따라 준비한 메모리의 주소를 보관한다.
    // new Member() => Member 설계도에 따라 변수를 생성한 후 그 주소를 리턴.

    // 인스턴스 변수에 값 넣기

    m1.name = "홍길동";
    m1.age = 20;
    m1.working = false;

    m2.name = "임꺽정";
    m2.age = 30;
    m2.working = true;

    m3.name = "안중근";
    m3.age = 40;
    m3.working = true;

    System.out.printf("이름: %s\n", m1.name);
    System.out.printf("나이: %d\n", m1.age);
    System.out.printf("재직여부: %b\n", m1.working);

    System.out.printf("이름: %s\n", m2.name);
    System.out.printf("나이: %d\n", m2.age);
    System.out.printf("재직여부: %b\n", m2.working);

    System.out.printf("이름: %s\n", m3.name);
    System.out.printf("나이: %d\n", m3.age);
    System.out.printf("재직여부: %b\n", m3.working);

  }
}

