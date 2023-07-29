package com.hspedu.chapter14.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        //add:添加单个元素
        list.add("jack");
        list.add(10);
        list.add(true);
        System.out.println("list = " + list);
        //remove:删除指定元素
        //list.remove(0);//删除第一个元素
        list.remove("jack");//指定删除某个对象
        System.out.println("list = " + list);
        //contains:查找元素是否存在
        System.out.println(list.contains("jack"));
        //size:获取元素个数
        System.out.println(list.size());
        //isEmpty:判断是否为空
        System.out.println(list.isEmpty());
        //clear：清空
        list.clear();
        System.out.println(list);
        //addAll:添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        list.addAll(list2);
        System.out.println(list);
        //containsAll：查找多个元素是否都存在
        System.out.println(list.containsAll(list2));
        //removeAll：删除多个元素
        list.add("聊斋");
        list.removeAll(list2);
        System.out.println(list);

    }
}
