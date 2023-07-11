package com.hspedu.chapter10.codeblock;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println(Cat.n1);
//        DD dd = new DD();
//        DD dd1 = new DD();
        System.out.println(DD.n1);
    }
}
class DD{
    public static int n1 = 888;
    static {
        System.out.println("DD的静态代码1被执行。。。");
    }
    {
        System.out.println("DD的普通代码1被执行。。。");
    }
}
class Cat{
    public static int n1 = 999;
    static {
            System.out.println("Cat的静态代码1被执行。。。");
    }
}
class BB{
    static {
        System.out.println("BB的静态代码1被执行。。。");
    }
}
class AA extends BB{
    static {
        System.out.println("AA的静态代码1被执行。。。");
    }
}