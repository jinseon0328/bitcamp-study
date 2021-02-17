// HashMap과 Set 키 목록
package com.eomcs.basic.ex08;

import java.util.HashMap;
import java.util.Set;

public class Exam0310 {
  public static void main(String[] args) {

    HashMap<String,Member> map = new HashMap<>();
    map.put("s01", new Member("홍길동", 20));
    map.put("s02", new Member("임꺽정", 30));
    map.put("s03", new Member("유관순", 16));
    map.put("s04", new Member("안중근", 20));
    map.put("s05", new Member("윤봉길", 30));

    Set<String> keys = map.keySet();
    // keySet()이 리턴하는 것은 HashMap의 key 목록을 다루는 객체이다.
    // 별도로 key 목록을 만들어 리턴하지 않는다.
    // 키 목록을 복제하지 않고 바로 꺼냈다

    // 따라서 다음과 같이 맵의 데이터를 지운다면,
    // 당연히 키목록을 얻은 후에 해당 키도 삭제된다.
    map.remove("s01");
    map.remove("s02");
    map.remove("s03");

    // Set 객체를 통해 key 를 꺼낼 때,
    // Map에서 제거된 키는 꺼낼 수 없다.
    // 왜?
    // Set 객체는 HashMap에 있는 key를 꺼내기 때문이다.
    // 즉 keySet()을 호출할 때 모든 key를 미리 목록을 만들어 리턴하지 않는다.
    for (Object key : keys) {
      System.out.println(key);
    }
  }

}


