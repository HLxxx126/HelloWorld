package com.hspedu.chapter11.homework;

import com.hspedu.chapter10.interface_.Computer;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,8);
        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        },10,8);
    }
}
interface ICalculate{
    public double work(double n1 , double n2);
}
class Cellphone{
    public void testWork(ICalculate iCalculate,double n1,double n2){
       double result = iCalculate.work(n1,n2);
        System.out.println("运算结果为 " + result);
    }
}