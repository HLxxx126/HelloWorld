package com.hspedu.object_;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c);
        System.out.println(b == c);
        B bObj = a;
        System.out.println(bObj == c);

    }
}
class A extends B{}
class B{}
