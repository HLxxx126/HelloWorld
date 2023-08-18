package com.hspedu.chapter15.customGeneric;



/**
 * @author HLxxx
 * @version 1.0
 */
public class CustomMethodGenericExercise {
    public static void main(String[] args) {
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);
        apple.fly(new Dog());
    }
}
class Apple<T,R,M>{
    public <E> void fly(E e){
        System.out.println(e.getClass().getSimpleName());
    }
    public void eat(R r){}
    public void run(M m){}
}
class Dog{}