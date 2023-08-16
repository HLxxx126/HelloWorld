package com.hspedu.chapter14.HomeWork_14;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car car = new Car("宝马",400000);
        Car car1 = new Car("宾利",5000000);
        arrayList.add(car);
        arrayList.add(car1);
        System.out.println("arrayList = " + arrayList);
        arrayList.remove(0);
        System.out.println(arrayList.contains(car));//f
        System.out.println(arrayList.size());//1
        System.out.println(arrayList.isEmpty());//f
       arrayList.addAll(arrayList);//2个宾利
        arrayList.containsAll(arrayList);//t
        //arrayList.removeAll(arrayList);//相当于清空
        for (Object o :arrayList) {
            System.out.println(o);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}