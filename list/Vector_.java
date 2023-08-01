package com.hspedu.chapter14.list;

import java.util.Vector;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Vector_ {
    public static void main(String[] args) {
        //无参构造器默认大小10
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println(vector);
    }
}
