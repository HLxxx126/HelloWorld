package com.hspedu.chapter14.HomeWork_14;

import java.util.*;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);
        System.out.println(map);
        map.put("jack",2600);//将jack的工资改为2600
        System.out.println(map);
        //为所有员工加薪100
        Set keySet = map.keySet();//遍历
        for (Object key :keySet) {
            map.put(key,(Integer)map.get(key) + 100);
        }
        System.out.println(map);
        //遍历EntrySet
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        //遍历所有工资
        Collection value = map.values();
        for (Object values :value) {
            System.out.println(values);
        }

    }
}
