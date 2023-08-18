package com.hspedu.chapter15.generic;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Generic03 {
    public static void main(String[] args) {
        Person<String> person = new Person<String>("韩顺平教育");//即把String赋给E
        person.show();//String
        Person<Integer> person1 = new Person<Integer>(100);//即把Integer赋给E
        person1.show();//Integer
    }
}
class Person<E>{
    E s;//E表示s的数据类型，该数据类型在定义Person对象的时候指定，即在编译期间，就确定E是什么类型

    public Person(E s) {//E也可以是参数类型
        this.s = s;
    }
    public E f(){//返回类型
        return s;
    }
    public void show(){
        System.out.println(s.getClass());//显示s的运行类型
    }
}