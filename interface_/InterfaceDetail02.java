package com.hspedu.chapter10.interface_;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        System.out.println(IB.n1);//说明n1是static
//        IB.n1 = 30;//说明n1是final
    }
}
interface IB{
    int n1 = 10;//等价public static final int n1 = 10;
    void hi();
}
interface IC{
    void say();
}
interface ID extends IB,IC{}//接口不能继承其他类但能继承其他多个接口
class Pig implements IB,IC{//一个类可同时实现多个接口
    @Override
    public void hi() {
        System.out.println("hi...");
    }

    @Override
    public void say() {
        System.out.println("say..");
    }
}