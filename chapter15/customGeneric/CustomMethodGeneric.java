package com.hspedu.chapter15.customGeneric;

import java.util.ArrayList;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CustomMethodGeneric {
    private static double k;

    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马",100);//当调用方法时传入参数，编译器就会确定类型
        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(),11.3f);
    }
}
class Car{//普通类
    public void run(){//普通方法
    }
    public <T,R> void fly(T t, R r){//泛型方法//这边的泛型是提供给fly方法使用的
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}
class Fish<T,R>{//泛型方法也可以在泛型类中使用
    public void run(){//普通方法
    }
    public<U,M> void eat(U u,M m){//泛型方法
    }
    public void hi(T t){//不是泛型方法，而是hi方法使用了类声明的泛型
    }
    public<K> void hello(R r,K k){ //泛型方法可以使用类声明的泛型，也可使用自己声明的泛型
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }
}
