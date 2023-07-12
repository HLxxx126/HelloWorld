package com.hspedu.chapter10.interface_;

//演示多态传递现象
public class InterfacePolyPass {
    public static void main(String[] args) {
       IG ig = new Teacher();
       //如果IG继承了IH接口，而Teacher类实现了IG接口
        //实际上相当于Teacher类也实现了IH接口
       IH ih = new Teacher();
        }

    }
interface IH{}
interface IG extends IH{}
class Teacher implements IG{}