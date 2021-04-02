// insert문 실행Exam0110.java
package com.eomcs.mybatis.ex03.c;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;


public class Exam0410 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/c/mybatis-config.xml")).openSession();

    Board board = new Board();
    board.setTitle("제목입니다333");
    board.setContent("내용입니다333");

    System.out.printf("insert 실행 전 : %s\n", board);
    // insert 문을 실행한 후에 자동 증가한 PK값을 알아내기
    // - 자동 증가한 PK 값은 SQL을 실행할 때 넘겨준 객체에 담겨있을 것이다.
    // - 단 SQL 매퍼 파일에서 insert문을 정의할 때 설정해야한다.

    int count = sqlSession.insert("BoardMapper.insert3", board);
    System.out.printf("%d 개의 데이터를 입력 했음!\n", count);

    sqlSession.commit();

    sqlSession.close();

    System.out.printf("insert 실행 후 : %s\n", board);
    System.out.println("실행완료");
  }

}
