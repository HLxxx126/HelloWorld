package com.hspedu.extend;

public class Sub extends Base {
    public Sub(String name, int age){
        super();
        System.out.println("子类Sub(String name, int age)....构造器被调用");
    }
    public Sub() {
        super("wtnb", 30);
        System.out.println("子类sub()....构造器被调用");
    }
    public Sub(String name){
        super("wtnb", 30);
        System.out.println("子类Sub(String name)....构造器被调用");
    }
    public void sayOK() {
        System.out.println(n1 + " " + n2 + " " + n3);
        test100();
        test200();
        test300();
        callTest400();
        System.out.println("n4= " + getN4());
    }
}
