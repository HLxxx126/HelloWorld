package com.hspedu.chapter14.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        //map接口常用方法
        Map map = new HashMap();
        map.put("邓超", new Book("", 100));
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋晶", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        System.out.println("map = " + map);

        //remove 根据key删除映射关系
        map.remove(null);
        System.out.println("map = " + map);
        //get 根据key获取value
        Object value = map.get("鹿晗");
        System.out.println(value);
        //size 获取元素个数
        System.out.println(map.size());
        //isEmpty 判断个数是否为0
        System.out.println(map.isEmpty());
        //clear 清除（清空）
        map.clear();
        System.out.println("map = " + map);
        //containsKey 查找key是否存在
        System.out.println(map.containsKey("hsp"));
        map.put("hsp","hsp的老婆");
        System.out.println(map.containsKey("hsp"));
    }
}

class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
