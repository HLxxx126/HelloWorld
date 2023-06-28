package com.hspedu.poly.polyarr;

public class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double sal) {
        super(name, age);
        this.salary = sal;
    }

    public double getSal() {
        return salary;
    }

    public void setSal(double sal) {
        this.salary = sal;
    }

    @Override
    public String say() {
        return super.say() + " salary = " + salary;
    }
    public void teach(){
        System.out.println("老师 " + getName() + "正在授课。。");
    }
}
