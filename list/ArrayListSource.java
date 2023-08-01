package com.hspedu.chapter14.list;

import java.util.ArrayList;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();//使用无参构造器创建ArrayList对象

        for (int i = 0; i <= 10; i++) {//使用for循环给list添加1-10的数据
            list.add(i);
        }
        for (int i = 11; i <= 15 ; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
    }
}
