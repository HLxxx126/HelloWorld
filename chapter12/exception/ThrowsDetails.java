package com.hspedu.chapter12.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ThrowsDetails {
    public static void main(String[] args) {
        f2();
    }
    public static void f2(){//对于运行异常，程序中如果没有处理，默认就是throws的方式处理
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }
    public static void f1() throws FileNotFoundException{
        //f3()抛出了一个编译异常，这时f1（）必须去处理这个编译异常
        f3();//抛出异常或TryCatchFinally
    }
    public static void f3() throws FileNotFoundException{
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
    public static void f4(){
        //f4()中调用f5（）是ok，f5（）抛出的是运行异常，而java并不要求程序员显示处理，因为有默认处理机制
        f5();
    }
    public static void f5() throws  ArithmeticException{

    }

}
class Father{//父类
    public void method() throws RuntimeException {

    }
}
class Son extends Father{//子类
    //子类重写父类方法时，所抛出的异常类型要么与父类一致，要么为父类抛出异常的子类型
   @Override
    public void method() throws NullPointerException{
    }
}
