package com.hspedu.chapter13.string;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringExercise06 {
    public static void main(String[] args) {
        String s1 = "hspedu";//指向池中的“hspedu”
        String s2 = "java";//指向池中的“java”
        String s5 = "hspedujava";//指向池中的“hspedujava”
        String s6 =(s1 + s2).intern();//指向池中的“hspedujava”
        System.out.println(s5 == s6);//T
        System.out.println(s5.equals(s6));//T
    }
}
