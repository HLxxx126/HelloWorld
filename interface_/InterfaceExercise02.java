package com.hspedu.chapter10.interface_;

public class InterfaceExercise02 {
    public static void main(String[] args) {
        new C_().pX();
    }
}
interface A_{
    int x = 0;
}
class B_{
    int x = 1;
}
class C_ extends B_ implements A_{
    public void pX(){
//        System.out.println(x);//错误，x不明确
        System.out.println(A_.x +" " + super.x);
    }
}