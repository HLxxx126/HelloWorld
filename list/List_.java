package com.hspedu.chapter14.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        list.add("tom");
        System.out.println("list = " + list );//List集合地点类中元素有序，即添加顺序和取出顺序一致，且可重复
        //List集合中的每个元素都有其对应的顺序索引，即支持索引//索引从0开始
        System.out.println(list.get(0));
    }
}
