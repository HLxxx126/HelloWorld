package com.hspedu.chapter15.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class GenericDetail {
    public static void main(String[] args) {
        //给泛型指向数据类型时，要求是引用类型，不能是基本数据类型
    List<Integer> list = new ArrayList<Integer>();//ok
    //List<int> list1 = new ArrayList<int>();//错误

        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        Pig<A> aPig1 = new Pig<A>(new B());//给泛型指定具体类型后，可以传入该类型或者其子类型
        aPig1.f();
        //泛型的使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        //在实际开发中，往往简写，编译器会进行类型推断
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        //如果这么写，泛型默认是Object
        ArrayList arrayList = new ArrayList();
    }
}
class A{}
class B extends A{}
class Pig<E>{
    E e;

    public Pig(E e) {
        this.e = e;
    }
    public void f(){
        System.out.println(e.getClass());//运行类型
    }
}