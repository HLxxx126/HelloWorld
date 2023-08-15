package com.hspedu.chapter14.map;

import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("john" , 100);
        //properties.put(null , 100);空指针异常
        //properties.put("john" , null); Properties继承HashTable，key 和 value 不能为空
        properties.put("lic" , 100);
        properties.put("lic" , 88);//相同的key value会替换

        System.out.println("properties = " + properties);
        //通过k，获取对应值
        System.out.println(properties.get("lic"));//88
        //删除
        properties.remove("lic");
        System.out.println("properties = " + properties);
        //修改
        properties.put("john","约翰");
        System.out.println("properties = " + properties);
    }
}
