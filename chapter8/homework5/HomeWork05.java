package com.hspedu.chapter8.homework5;

public class HomeWork05 {
    public static void main(String[] args) {
        Worker amy = new Worker("Amy", 2000);
        amy.print();
        Peasant jim = new Peasant("Jim", 1500);
        jim.print();
        Waiter steve = new Waiter("Steve", 1800);
        steve.print();
        Teacher tim = new Teacher("Tim", 2800);
        tim.setClassDay(180);
        tim.setClassSal(300);
        tim.print();
        Scientist tom = new Scientist("Tom", 5000);
        tom.setBonus(250000);
        tom.print();
    }
}

class Employee {
    private String name;
    private double sal;
    private int salMonth = 12;

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    public void print() {
        System.out.println("姓名" + name + "年工资为" + (salMonth * sal));
    }
}

class Worker extends Employee {
    public Worker(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void print() {
        System.out.print("工人");
        super.print();
    }
}

class Peasant extends Employee {
    public Peasant(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void print() {
        System.out.print("农民");
        super.print();
    }
}

class Waiter extends Employee {
    public Waiter(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void print() {
        System.out.print("服务员");
        super.print();
    }
}

class Teacher extends Employee {
    private int classDay;
    private double classSal;

    public Teacher(String name, double sal) {
        super(name, sal);
    }

    public Teacher(String name, double sal, int classDay, double classSal) {
        super(name, sal);
        this.classDay = classDay;
        this.classSal = classSal;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void print() {
        System.out.println("教师 " + getName() + "年工资为" + (getClassSal() * getClassDay() + getSal() * getSalMonth()));
    }
}

class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double sal) {
        super(name, sal);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void print() {
        System.out.println("科学家" + getName() + "年工资为" + (getBonus() + getSal() * getSalMonth()));
    }
}
