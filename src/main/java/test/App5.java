
package test;


public class App5 {

  class Member{
    String name;
    int age;
    boolean working;
  }
  public static void main(String[] args) {

    Member m;

    Member m = new Member();
    m.name = "임꺽정";
    m.age = 20;
    m.working = true;

    printMember();




  }
  static void printMember(Member m) {

    System.out.printf("이름: %s\n", m.name);
    System.out.printf("나이: %d\n", m.age);
    System.out.printf("재직여부: %b\n", m.working);
    System.out.println("---------------------------------");

  }
}



