// 멀티 스레딩(비동기 프로그래밍)의 문제점 - 사례 1의 문제 해결

package com.eomcs.concurrent.ex5;

public class Exam0120 {

  static class MyList {
    int[] values = new int[100];
    int size;

    // Critical Section에 오직 한 개의 스레드만 접근하게 하면 
    // 비동기로 인한 문제가 발생하지 않는다.
    // => 즉 동기화로 처리한다.
    // => 동기화?
    //    여러 스레드가 동시에 실행하는 것이 아니라,
    //    각 스레드가 순차적으로 접근하는 것.
    //    단 순차적으로 실행한다는 것은 동시 실행의 이점을 버리는 것이기 때문에
    //    스레드를 사용하기 전의 상태와 같다.
    //    기존의 실행 방식처럼 즉 실행 시간이 많이 걸린다.
    //
    // 다음 메서드를 동기화 처리해보자.
    // => synchronized
    //    - 이 키워드가 붙은 블록은 오직 한 번에 한 개의 스레드만이 접근할 수 있다.
    //    - 먼저 접근한 스레드가 나가야만 다음 스레드가 진입할 수 있다.
    synchronized public void add(int value) {
      // 여러 스레드가 동시에 이 메서드에 진입하면
      // 배열의 값을 덮어쓰거나 size만 올려놓고 값이 들어가지 않아 0으로 만들어 놓고
      // 다음 size로 넘어가는 문제가 발생한다.
      // 이렇게 여러 스레드가 동시에 접근했을 때 문제가 발생하는 코드 부분을 
      // "Critical Section" = "Critical Region"이라 부른다.
      if (size >= values.length) {
        delay();
        return;
      }
      delay();
      values[size] = value;
      delay();
      size = size + 1;
      delay();
    }
    public void print() {
      for (int i = 0; i < size; i++) {
        System.out.printf("%d: %d\n", i, values[i]);
      }
    }

    public void delay() {
      int count = (int)Math.random() *1000;
      //random() 0이랑 같거나 1000
      for (int i = 0; i < count; i++) {
        Math.atan(34.1234);
      }
    }
  }


  static class Worker extends Thread {
    MyList list;
    int value;
    public Worker(MyList list, int value) {
      this.list = list;
      this.value = value;
    }

    @Override
    public void run() {
      for (int i = 0; i < 20; i++) {
        list.add(value);

      }
    }
  }

  public static void main(String[] args) throws Exception {
    //static 안에는 인스턴스 멤버가 없다 
    MyList list= new MyList();

    Worker w1 = new Worker(list, 111);
    Worker w2 = new Worker(list, 222);
    Worker w3 = new Worker(list, 333);

    w1.start();
    w2.start();
    w3.start();

    Thread.sleep(10000);
    list.print();

  }
}
