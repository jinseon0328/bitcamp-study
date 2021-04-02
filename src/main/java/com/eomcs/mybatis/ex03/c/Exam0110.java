// insert문 실행Exam0110.java
package com.eomcs.mybatis.ex03.c;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;


public class Exam0110 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/c/mybatis-config.xml")).openSession();

    Board board = new Board();
    board.setTitle("제목입니다111");
    board.setContent("내용입니다111");

    int count = sqlSession.insert("BoardMapper.insert1", board);
    System.out.printf("%d 개의 데이터를 입력 했음!\n", count);

    sqlSession.commit();

    sqlSession.close();
    System.out.println("실행완료");
  }

}
