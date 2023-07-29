package com.hspedu.chapter14.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));

        //使用增强for循环,在Collection集合
        //增强for底层方法仍是迭代器，即增强for就是简化版本的迭代器遍历
        //快捷键I

        for(Object book : col){
            System.out.println("book = " + book);
        }//增强for也可以在数组上使用
        int[] nums = {1, 8, 10, 90};
        for (int i : nums){
            System.out.println("i = " + i);
        }
    }
}
