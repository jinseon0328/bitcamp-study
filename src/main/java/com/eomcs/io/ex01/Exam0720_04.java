// 활용 - 지정한 폴더를 삭제하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720_04 {

  public static void main(String[] args) throws Exception {

    // temp 디렉토리를 삭제하기
    // 손코딩 해야하는 문제!
    File dir = new File("temp");

    deleteFile(dir);
    // 파일을 지우는 임의의 메서드를 만든다
  }

  static void deleteFile(File dir) {
    // 재귀호출을 써야한다
    // 디렉토리를 지우려면 디렉토리 안에 아무것도 없어야한다
    // 그래서 디렉토리를 지우려면 디렉토리 안의 맨 하위의 파일부터 하나하나 지우면서 상위까지 올라와서 지워야한다
    // 주어진 파일이 디렉토리라면 하위 파일이나 디렉토리를 찾아 지운다.
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File file : files) {
        deleteFile(file);
      }
    }

    dir.delete(); // 현재 파일이나 폴더 지우기
  }

}


