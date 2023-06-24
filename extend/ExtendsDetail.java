package com.hspedu.extend;

public class ExtendsDetail {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println("======第二个对象======");
        Sub sub2 = new Sub("wtnb");
        System.out.println("======第三个对象======");
        Sub sub3 = new Sub("wtnb",30);
        sub.sayOK();
    }
}
