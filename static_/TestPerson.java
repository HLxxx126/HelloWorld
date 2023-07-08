package com.hspedu.chapter10.static_;

public class TestPerson {
    public static void main(String[] args) {
        System.out.println("Number of total is " + Person.getTotalPerson());
        Person p1 = new Person();
        System.out.println("Number of total is " + Person.getTotalPerson());
    }
}
class Person{
    private int id;
    private static int total = 0;
    public static int getTotalPerson(){
        return total;
    }
    public Person(){
        total++;
        id = total;
    }
}