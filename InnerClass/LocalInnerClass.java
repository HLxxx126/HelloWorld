package com.hspedu.chapter10.InnerClass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02的hashcode = " + outer02);

    }
}
class Outer02{//外部类
    private int n1 =100;
    private void m2(){
        System.out.println("Outer02 m2()");
    }//私有方法
    public void m1(){//方法
        //局部内部类是定义在外部类的局部位置，通常在方法
        class Inner02{//局部内部类,本质仍是类
            //可以访问外部类的所有成员，包括私有的
            //不能添加访问修饰符，但可以用final修饰
            //作用域仅仅在定义它的方法或代码块中
            private int n1 = 800;//如果外部类和内部类的成员重名，默认遵循就近原则，如果想访问外部类成员用外部类名.this.成员
            public void f1(){
                System.out.println("n1 = " + n1);//直接访问外部类成//就近原则访问内部类成员
                System.out.println("n1 = " + Outer02.this.n1);//访问外部类成
                System.out.println("Outer02.this hashcode = " + Outer02.this);

                m2();
            }
        }
        //外部类在方法中，可以创建局部内部类的对象，然后调用方法
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}