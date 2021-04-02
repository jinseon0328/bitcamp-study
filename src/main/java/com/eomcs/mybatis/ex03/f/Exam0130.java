// #{} 과 ${} 차이점 => ${} 문법의 활용 II
package com.eomcs.mybatis.ex03.f;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;


public class Exam0130 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/f/mybatis-config.xml")).openSession();

    // 정렬 방식을 파라미터로 넘기기
    // => #{} 문법은 파라미터 값을 SQL문에 그대로 삽입한다.
    // => 그래서 값 뿐만 아니라 다른 것도 가능하다
    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard3", "created_date desc, title asc");

    for (Board b : boards) {
      System.out.printf("%d,%s,%s,%s,%d\n",
          b.getNo(),
          b.getTitle(),
          b.getContent(),
          b.getRegisteredDate(),
          b.getViewCount());
    }

    sqlSession.close();
  }

}
