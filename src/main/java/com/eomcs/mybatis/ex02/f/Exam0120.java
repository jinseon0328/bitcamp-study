// SqlSession 사용법 - 결과가 한 개일 때 => selectOne()을 사용
package com.eomcs.mybatis.ex02.f;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;


public class Exam0120 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex02/f/mybatis-config.xml")).openSession();

    // selectOne()
    // - select 결과가 0 또는 1개일 때 호출할 수 있다.
    // - 결과가 없으면 리턴 값은 null이다.
    Board b = sqlSession.selectOne("BoardMapper.selectBoard2", 9);

    if(b == null) {
      System.out.println("해당 번호의 게시글이 없습니다");
      return;
    }

    // 컬러몀과 자바 객체의 프로퍼티명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내올 수 있다.
    System.out.printf("%d,%s,%s,%s,%d\n",
        b.getNo(),
        b.getTitle(),
        b.getContent(),
        b.getRegisteredDate(),
        b.getViewCount());

    sqlSession.close();
  }

}
