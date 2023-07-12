package com.hspedu.chapter10.abstract_;

public class AbstractDetail01 {
    public static void main(String[] args) {
//        new A();//抽象类不能被实例化
    }
}
abstract class A{ //抽象类中不一定要包含抽象方法，，还可以有实现的方法
    public void hi(){
        System.out.println("hi");
    }
}
class B{
   // public  abstract  int n1 = 1;//abstract只能修饰类和方法
}