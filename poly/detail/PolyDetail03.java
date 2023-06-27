package com.hspedu.poly.detail;

public class PolyDetail03 {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb instanceof BB);//true
        System.out.println(bb instanceof AA);//true
        AA aa = new BB();
        System.out.println(aa instanceof AA);
        System.out.println(aa instanceof BB);
        Object obj = new Object();
        System.out.println(obj instanceof AA);
        String str = "hello";
        System.out.println(str instanceof Object);
    }
}
class AA{}
class BB extends AA{}