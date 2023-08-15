package com.hspedu.chapter14.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TreeMap_ {
    public static void main(String[] args) {

        //TreeMap treeMap = new TreeMap();//默认构造器创建为无序
        TreeMap treeMap =new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               // return ((String)o1).compareTo((String)o2);//按key的字符串大小排序
                return ((String)o1).length()-((String)o2).length();//按key字符串长度排序
            }
        });
        treeMap.put("jack" , "杰克");
        treeMap.put("tom" , "汤姆");
        treeMap.put("kristina" , "克瑞斯缇娜");
        treeMap.put("smith" , "斯密斯");
        System.out.println("treeMap = " + treeMap);
    }
}
