package com.hspedu.chapter14.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("hashSet = " + hashSet);//HashSet可以存放努力了，但是只能有一个null，即元素不能重复
    }
}
