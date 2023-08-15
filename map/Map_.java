package com.hspedu.chapter14.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","韩顺平");//k-v
        map.put("no2","张无忌");
        map.put("no1","张三丰");//map中的key不允许重复，当有相同k时会进行替换
        map.put("no3","张三丰");//可以 k-v
        map.put(null,null);//k可以为空，v也可以为空，但是k只能有一个为空
        map.put(null,"abc");//等价替换
        map.put("no4",null);//可以k-v
        //常用String来作key，其他类也可以
        map.put(1,"赵敏");
        map.put(new Object(),"金毛狮王");
        //key和value存在单向一对一关系，即通过指定的key能找到对应的value
        System.out.println(map.get("no1"));//通过get方法传入一个key，能返回对应value
        System.out.println("map = " + map);
    }
}
