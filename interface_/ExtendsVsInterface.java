package com.hspedu.chapter10.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("悟空");
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.flying();
    }
}
//接口
interface Fish{
    void swimming();
}
interface Bird{
    void flying();
}
class Monkey{
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climbing(){
        System.out.println(name + "会爬树。。");
    }
}
//继承
//当子类继承了父类，就自动拥有父类的功能
//如果子类需要扩展功能，可以通过实现接口的方式扩展
class LittleMonkey extends Monkey implements Fish,Bird{
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "通过学习，像小鱼会游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName() + "通过学习，像小鸟会飞翔");
    }
}