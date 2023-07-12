package com.hspedu.chapter10.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
       // new IA();//接口不能被实例化
    }
}

interface IA{
    void say();//接口中默认public方法，抽象方法可不用abstract修饰
    void hi();
}
class Cat implements IA{//普通类实现接口需将该接口所有方法实现 快捷键：option+enter
    @Override
    public void say() {

    }

    @Override
    public void hi() {
    }
}
abstract class Tiger implements IA{}//抽象类实现接口时，可以不是实现接口的抽象方法

