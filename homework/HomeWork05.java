package com.hspedu.chapter11.homework;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork05 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}
class A{
    private String NAME = "tom";
  public void f1(){
      class B{
          private final String NAME ="jack";
          public  void show(){
              System.out.println("NAME = " + NAME + " 外部类的name = " + A.this.NAME);
          }
      }
      B b = new B();
      b.show();

  }
}