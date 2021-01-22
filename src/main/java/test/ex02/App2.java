package test.ex02;

public class App2 {
  public static void main(String[] args) {

    //인스턴스와 가비지
    Myclass v1 = new Myclass();

    System.out.println(v1);

    Myclass v2 = v1;

    v2.b = 222;

    System.out.println(v1.b);

  }

}
