package com.hspedu.chapter11.homework;

import com.hspedu.super_.B;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧",new Horse());
        person.common();
        person.passRiver();
        person.passMountain();
        person.common();
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("一般情况下，使用马前进");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("过河的时候使用船");
    }
}
class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("过火山的时候使用飞机");
    }
}

class VehiclesFactory {
    private static Horse horse = new Horse();//饿汉式
    private VehiclesFactory(){}
    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat(){
        return new Boat();
    }
    public static Plane getPlane(){
        return new Plane();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;
    public void passRiver(){
        if(!(vehicles instanceof Boat)){
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }
    public void common(){
        if(!(vehicles instanceof Horse)){
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }
    public void passMountain(){
        if (!(vehicles instanceof Plane)){
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
}