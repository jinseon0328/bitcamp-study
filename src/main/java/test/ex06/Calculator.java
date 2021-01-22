package test.ex06;

public class Calculator {

  int result;


  void plus(int value) {
    //Calculator this;
    //인스턴트 변수에 내장된 변수 this
    this.result += value;
  }

  void minus(int value) {
    this.result -= value;
  }

  void multiple(int value) {
    this.result *= value;
  }

  void divide(int value) {
    this.result /= value;
  }

}
