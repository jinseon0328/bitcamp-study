// SqlSession 사용법 - 결과 타입이 Map일 때 
package com.eomcs.mybatis.ex02.e;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Exam0110 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex02/e/mybatis-config.xml")).openSession();


    // 결과 타입이 Map 이면
    // - slectList()의 리턴 타입은 List<Map>이 된다.
    List<Map> list = sqlSession.selectList("BoardMapper.selectBoard");

    // 컬러몀과 자바 객체의 프로퍼티명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내올 수 있다.
    for (Map map : list) {
      System.out.printf("%d,%s,%s,%s,%d\n",
          map.get("board_id"),
          map.get("title"),
          map.get("contents"),
          map.get("created_date"),
          map.get("view_count"));
    }

    sqlSession.close();
  }

}
