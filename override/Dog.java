package com.hspedu.override;

public class Dog extends Animal {
    public void cry() {
        System.out.println("汪汪汪。。。");//Dog的cry方法重写了Animal的cry方法
    }
    public String m1(){
        return null;
    }
    public void eat() {

    }
}
