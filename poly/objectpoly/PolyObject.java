package com.hspedu.poly.objectpoly;

public class PolyObject {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.cry();
        animal = new Cat();
        animal.cry();
    }
}
