package com.hspedu.chapter10.interface_;

public interface AInterface {
    public int n1 = 10;
    public void hi();//在接口中抽象方法可省略Abstract关键字
    default public void ok(){//在jdk8后，可以有默认实现方法，需使用default关键字修饰
        System.out.println("ok.....");
    }
    public static void cry(){//在jdk8后，可以有静态实现方法
        System.out.println("cry.....");
    }

}
