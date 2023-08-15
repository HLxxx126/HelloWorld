package com.hspedu.chapter14.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashMap.put(1,new Employ("jack",30000,1));
        hashMap.put(2,new Employ("tom",2000,2));
        hashMap.put(3,new Employ("milan",19000,3));
        Set set = hashMap.keySet();
        System.out.println("----第一种遍历方式-----");
        for (Object key : set) {
            Employ emp = (Employ) hashMap.get(key);
            if (emp.getSal() > 18000){
                System.out.println(emp);
            }
        }
        System.out.println("----第二种遍历方式-----");
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object entry =  iterator.next();
            Map.Entry m = (Map.Entry) entry;
            Employ emp = (Employ) m.getValue();
            if (emp.getSal() > 18000){
                System.out.println(emp);
            }
        }


    }
}
class Employ{
    private String name;
    private double sal;
    private int id;

    public Employ(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}