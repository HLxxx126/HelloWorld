package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ClassCastException_ {
    public static void main(String[] args) {
        A b = new B();//向上转型
        B b2 = (B)b;//向下转型
        C c = (C)b;//这里抛出ClassCastException异常
    }
}
class A{}
class B extends A{}
class C extends A{}