package com.hspedu.chapter14.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //增加结点
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("linkedList = " + linkedList);
        //删除结点
        linkedList.remove();//默认删除第一个结点
        System.out.println("linkedList = " + linkedList);

        //修改某个结点对象
        linkedList.set(1,999);
        System.out.println("linkedList = " + linkedList);

        //得到某个结点对象
        Object o = linkedList.get(1);//取得索引为1的对象，即第二个对象
        System.out.println(o);

        //因为LinkedList是 实现了List接口，遍历方式可以为 for循环 增强for循环 和迭代器
       //迭代器
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        //增强for循环
        for (Object o1 :linkedList) {
            System.out.println(o1);
        }
        //for循环
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
