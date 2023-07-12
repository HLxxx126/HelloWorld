package com.hspedu.chapter10.interface_;

public class InterfaceExercise01 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(C.c);
        System.out.println(B.c);
        System.out.println(b.c);
    }
}
interface C{
    int c = 23;
}
class B implements C{}