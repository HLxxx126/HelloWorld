package com.hspedu.poly.detail;

public class PolyDetail {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        animal.show();
        animal.sleep();
        animal.run();
        Cat cat = (Cat) animal;
        ((Cat) animal).catchMouse();
    }
}
