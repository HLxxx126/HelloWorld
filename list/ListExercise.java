package com.hspedu.chapter14.list;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("pink");
        list.add("black" );
        list.add("purple");
        list.add("blue");
        list.add("orange");
        list.add("red");
        list.add("yellow");
        list.add("white");
        list.add("green");
        list.add(1,"韩顺平教育");
        list.get(4);
        list.remove(5);
        list.set(6,"snow");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }


    }
}
