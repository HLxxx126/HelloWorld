package com.hspedu.poly;

public class Poly01 {
    public static void main(String[] args) {
        Master master = new Master("SKM");
        Dog dog = new Dog("syachi");
        Bone bone = new Bone("大棒骨~");
        master.feed(dog,bone);
        Cat cat = new Cat("tsuna");
        Fish fish = new Fish("黄花鱼~");
        master.feed(cat,fish);
        Pig pig = new Pig("小猪");
        Rice rice = new Rice("米饭");
        master.feed(pig, rice);
    }
}

