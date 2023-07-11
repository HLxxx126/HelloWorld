package com.hspedu.chapter10.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle c = new Circle(2);
        System.out.println("面积 = " + c.calArea());
    }
}
class Circle{
    private double radius;
    private final double PI;// = 3.14;

    public Circle(double radius) {
        this.radius = radius;
        //PI = 3.14;
    }
    {
        PI = 3.14;
    }
    public double calArea(){
        return PI * radius * radius;
    }
}