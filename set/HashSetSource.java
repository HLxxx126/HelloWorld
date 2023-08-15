package com.hspedu.chapter14.set;

import java.util.HashSet;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("hsp" );
        hashSet.add("java");
        System.out.println("set = " + hashSet);
    }
}
