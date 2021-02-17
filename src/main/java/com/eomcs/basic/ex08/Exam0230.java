// java.util.HashMap - key/value 한쌍으로 묶어 꺼내기
package com.eomcs.basic.ex08;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Exam0230 {
  public static void main(String[] args) {

    HashMap<String,Member> map = new HashMap<>();
    map.put("s01", new Member("홍길동", 20));
    map.put("s02", new Member("임꺽정", 30));
    map.put("s03", new Member("유관순", 16));
    map.put("s04", new Member("안중근", 20));
    map.put("s05", new Member("윤봉길", 30));


    Set<Entry<String,Member>> entrySet = map.entrySet();
    //                                   ------------ 키와 value를 한번에 꺼내는 메서드
    // set 구현체에 들어있는 객체는 엔트리 객체 엔트리 객체에는 String과 멤버 객체
    // 키는 String 값은 멤버
    // 엔트리 객체는 키랑 값을 가지고 있는 객체
    // set은 집합
    // key,value가 한쌍으로 묶여있는 객체들이 들어있다.

    for (Entry<String,Member> entry : entrySet) {
      System.out.printf("%s ===> %s\n",
          entry.getKey(),
          entry.getValue());
    }

  }

}







