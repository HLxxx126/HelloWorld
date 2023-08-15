package com.hspedu.chapter14.set;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author HLxxx
 * @version 1.0
 */
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new Car("奥拓",1000));
        set.add(new Car("奥迪",300000));
        set.add(new Car("法拉利",10000000));
        set.add(new Car("奥迪",300000));
        set.add(new Car("保时捷",70000000));
        set.add(new Car("奥迪",300000));
        System.out.println("set = " + set);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
