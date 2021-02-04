package test;

import java.sql.Date;

public class Test3 {

  static void print (int value) {
    System.out.println("==>" + value);
  }

  static void print(String str) {
    System.out.println("==>" + str);
  }
  static void print(Object obj) {
    System.out.println("==>" + obj.toString());
  }
  public static void main(String[] args) {
    print(100);
    print("홍길동");
    print(new Date(System.currentTimeMillis()))
  }

}
