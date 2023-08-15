package com.hspedu.chapter14.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add("john");//重复数据
        set.add(null);
        set.add(null);
        System.out.println("set = " + set);//set接口对象不能存放重复元素，可以添加一个null，
        // set接口对象存放数据是无序的，即添加顺序和取出顺序不一致，但是取出的顺序是固定的。

        set.remove(null);//删除 
        //遍历
        //方式一：迭代器
        System.out.println("------迭代器遍历-----");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj = " + obj );
        }
        System.out.println("-----增强for循环------");
        for (Object o :set) {
            System.out.println("o = " + o);
        }
        //set 接口对象，不能通过索引来获取
    }
}
