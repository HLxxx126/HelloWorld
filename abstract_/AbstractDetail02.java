package com.hspedu.chapter10.abstract_;

public class AbstractDetail02 {
    public static void main(String[] args) {

    }
}
abstract class D{ //抽象类还是类,可以有类的各种成员
    public int n1 = 10;
    public static String name = "HLxxx";
    public void hi(){
        System.out.println("hi");
    }
    public abstract void hello();
    public static void ok(){
        System.out.println("ok");
    }
}
abstract class E{
    public abstract void hi();
}
class F extends E{
    @Override
    public void hi() {

    }
}
abstract class G extends E{}
abstract class H{
//    private abstract void hi();
//    final abstract void hi();
//    static abstract void hi();//这三个关键词与重写违背，都不能修饰抽象方法

}