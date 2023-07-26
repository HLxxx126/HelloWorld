package com.hspedu.chapter13.string;

import com.hspedu.poly.polyarr.Person;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringExercise05 {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        p1.name = "hspedu";
        Person1 p2 = new Person1();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name == "hspedu");

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2);

    }
}
class Person1{
    public String name;
}
