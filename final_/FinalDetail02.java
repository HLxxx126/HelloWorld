package com.hspedu.chapter10.final_;

public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.num);
    }
}
final class AAA{
    //final类中没必要修饰成final方法
    //public final void cry(){}
}
class BBB{//final和static一起使用不会导致类加载效率更高
    public final static int num = 10000;
    static {
        System.out.println("BBB静态代码块被执行");
    }
}