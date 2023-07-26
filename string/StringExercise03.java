package com.hspedu.chapter13.string;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringExercise03 {
    public static void main(String[] args) {
        String a = "hsp";//指向常量池的"hsp"
        String b = new String("hsp");//指向堆中对象
        System.out.println(a.equals(b));//T
        System.out.println(a == b);//F
        System.out.println(a == b.intern());
        System.out.println(b == b.intern());
    }
}
