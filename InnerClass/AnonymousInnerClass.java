package com.hspedu.chapter10.InnerClass;

//匿名内部类的使用
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}
class Outer04{
    private int n1 = 10;
    public void method(){//外部类
    //基于接口的匿名内部类
        IA tiger = new IA(){
            @Override
            public void cry() {
                System.out.println("老虎叫唤。。。");
            }
        };
        tiger.cry();
        //基于类的匿名内部类
        Father jack = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test（）");
            }
        };
        jack.test();
        //基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("小狗吃骨头");
            }
        };
        animal.eat();
    }
}
interface IA{
    public void cry();
}
class Father{
    public Father(String name){
    }
    public void test(){
    }
}
abstract class Animal{//抽象类
    abstract void eat();
}