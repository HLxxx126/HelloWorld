package com.hspedu.chapter10.InnerClass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();
        //外部其他类，使用成员内部类的2种方法
        Outer08.Inner08 inner08 = outer08.new Inner08();//1.相当于把new Inner08（）当作是outer08的成员
        inner08.say();
        //2.在外部类中，编写一个方法，可以返回Inner08的对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();
    }
}

class Outer08 {//外部类
    private int n1 = 10;
    public String name = "张";
    private void hi(){
        System.out.println("hi()方法。。。");
    }

    //成员内部类定义在外部类的成员位置上
    //成员内部类可以添加任意访问修饰符
    public class Inner08 {//成员内部类
        private double sal = 99.8;
        private int n1 = 66;//如果成员内部类成员和外部类重名，遵循就近原则，可通过外部类名.this.属性访问外部类成员

        public void say() {//可以直接访问外部类的所有成员包括私有的
            System.out.println("Outer08 的 n1 = " + n1 + " Outer08 的 name =  " + name + " 外部类 n1 = " + Outer08.this.n1);
            hi();
        }
    }
    public Inner08 getInner08Instance(){
        return new Inner08();
    }

    //写方法
    public void t1() {//使用成员内部类
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}