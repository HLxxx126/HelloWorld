package com.hspedu.chapter14.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TreeSet_ {
    public static void main(String[] args) {
        //当使用无参构造器创建TreeSet时，仍然是无序的
        //希望按字符串大小排序
        //使用TreeSet提供的一个构造器 ，可传入一个比较器（匿名内部类），并指定排序规则
        //TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               // return ((String)o1).compareTo((String)o2);
                return ((String)o1).length()-((String)o2).length();//按字符串长度排序
            }
        });
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
        System.out.println("treeSet = " + treeSet);
    }
}
