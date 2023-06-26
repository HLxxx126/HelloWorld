package com.hspedu.super_;

import java.sql.SQLOutput;

public class B extends A{
   public int n1 = 888;
   public void test(){
       System.out.println("super.n1 = " + super.n1);//100
       System.out.println("super.age = " + super.age);//111
       super.cal();//A类的
   }
    public void hi(){
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }
    public void sum(){
        System.out.println("B类的sum（）方法...");
//        cal();
//        this.cal();//等价cal
        super.cal();//不查找子类直接查找父类，其他规则一样
          //调用A类cal（）三种方法都可以
    }
    public void cal(){
        System.out.println("B类的cal（）方法...");
        super.cal();
        System.out.println(n1);
        System.out.println(this.n1);
        System.out.println(super.n1);
    }
    public void ok(){
        super.test100();
        super.test200();
        super.test300();
    }
    public B(){
        super();
    }
}
