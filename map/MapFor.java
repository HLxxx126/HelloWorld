package com.hspedu.chapter14.map;

import java.util.*;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class MapFor {//map的遍历方法
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋晶", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
        //第一组 先取出所有的key，通过key取出对应的value
        Set keySet= map.keySet();
        //（1）增强for
        System.out.println("-----------------");
        for (Object key :keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2)迭代器
        System.out.println("-----------------");
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        //第二组 把所有value取出
        Collection values = map.values();
        //这里可以使用所有Collections使用的遍历方法
        //（1）增强for
        System.out.println("-----------------");
        for (Object value :values) {
            System.out.println("value = " + value);
        }
        //(2)迭代器
        System.out.println("-----------------");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value =  iterator1.next();
            System.out.println("value = " + value);

        }
        //第三组 通过EntrySet来获取
        Set entrySet = map.entrySet();
        //(1)增强for
        System.out.println("-----------------");
        for (Object entry :entrySet) {
            //将entry转成Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        //(2)迭代器
        System.out.println("-----------------");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry =  iterator2.next();
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());

        }


    }
}
