package test;

public class A {
  B b = new B();
  void m1() {
    b.y();
  }

  void m2(B b) {
    b.y();
  }

}
