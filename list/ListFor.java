package com.hspedu.chapter14.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ListFor {
    public static void main(String[] args) {
        //List的三种遍历方式
        //List 接口的实现子类 Vector LinkedList也适用
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("鱼香肉丝");
        list.add("北京烤鸭");
        //方式一 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
        //方式二 增强for
        System.out.println("-----增强for-----");
        for (Object o :list) {
            System.out.println(o);
        }
        //方式三 普通for循环
        System.out.println("-----for-----");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("对象 = " + list.get(i));
        }

    }
}
