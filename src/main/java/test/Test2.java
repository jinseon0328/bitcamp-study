package test;

public class Test2 {
  static class A {
    int a = 100;
    int b = 200;
    void m1() {
      System.out.println("A.m1()");
    }
    void m2() {
      System.out.println("A.m2()");
    }

  }
  static class B extends A {

    int a = 111;
    int c = 222;

    @Override
    void m1() {
      System.out.println("B.m1()");
    }
    void m3() {
      System.out.println("B.m3()");
    }

  }
  public static void main(String[] args) {

    A obj = new B();
    obj.m1(); //실제 obj가 가리키는 객체의 클래스에서 메서드를 찾는다.
    // 없으면 슈퍼 클래스로 따라 올라가면서 찾는다.
    obj.m2();
    //obj.m3(); // 컴파일러는 문법 그대로 검사한다.
    // obj에 어떤 객체 주소가 들어있는지 고려하지 않는다

    B obj2 = (B) obj;

    System.out.println(obj.a);
    System.out.println(obj2.a);
  }
}
