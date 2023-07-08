package com.hspedu.chapter10.static_;

public class ChildGame {
    public static void main(String[] args) {
//        int count =0;
        Child child1 = new Child("白骨精");
        child1.join();
        child1.count++;
//        count++;
        Child child2 = new Child("狐狸精");
        child2.join();
        child2.count++;
//        count++;
        Child child3 = new Child("老鼠精");
        child3.join();
        child3.count++;
//        count++;
//        System.out.println("共有" + count + "个小孩加入了游戏。。");
        System.out.println("共有" + Child.count + "个小孩加入了游戏。。");

    }
}
class Child{
    private String name;
    public static int count = 0;
    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void join(){
        System.out.println(name + "加入了游戏。。");
    }
}