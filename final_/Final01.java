package com.hspedu.chapter10.final_;

public class Final01 {
    public static void main(String[] args) {
        E e = new E();
//        e.TAX_RATE = 0.09;
    }
}
final class A{}//如果要求A类不能被其他类继承，用final修饰A类
//class B extends A{}
class C {
    final public void hi(){}//如果要求hi不能被子类重写 用final修饰hi（）
}
class D extends C{
//    @Override
//    public void hi() {
//        System.out.println("重写了C类hi（）。。");
//    }
}
class E{
    final public double TAX_RATE = 0.08;
}
class F{
    public void cry(){
        final double NUM = 0.01;//也被称为局部常量
//        NUM = 0.9;
        System.out.println("NUM = " + NUM);
    }
}