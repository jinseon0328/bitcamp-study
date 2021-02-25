package com.eomcs.io.ex11.c;

public class Member implements java.io.Serializable {

  String name;
  int age;
  // 위치는 상관없지만 추가하거나 삭제하는 것이 생기면 버전이 달라진다
  boolean gender; // true(여자), false(남자)

  // Exam0320의 두 번째 테스트를 실행할 때 주석을 풀라!
  // String tel;

  @Override
  public String toString() {
    return "Member [name=" + name +
        ", age=" + age +
        ", gender=" + gender +
        // Exam0320의 두 번째 테스트를 실행할 때 주석을 풀라!
        // ", tel=" + tel +
        "]";
  }
}
