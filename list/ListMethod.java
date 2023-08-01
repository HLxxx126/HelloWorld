package com.hspedu.chapter14.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");
        //在索引1的位置插入一个人名
        list.add(1,"韩顺平");
        System.out.println("list = " + list);
        //在索引1的位置插入多个人名
        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1,list2);
        System.out.println(list);
        //查找obj在集合中出现的首次位置
        System.out.println(list.indexOf("tom"));
        //查找obj在集合中出现的末次位置
        list.add("tom");
        System.out.println("list = " + list);
        System.out.println(list.lastIndexOf("tom"));
        //删除索引对应的元素
        list.remove(0);
        System.out.println("list = " + list);
        //替换指定索引的元素
        list.set(1,"mary");
        System.out.println("list = " + list);
        //抽取[ , ）指定索引的元素
        List reslist = list.subList(0, 2);
        System.out.println("reslist = " + reslist);

    }
}
