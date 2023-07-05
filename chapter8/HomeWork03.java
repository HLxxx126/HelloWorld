package com.hspedu.chapter8;

public class HomeWork03 {
    public static void main(String[] args) {
        Worker tom = new Worker("Tom", 200, 21,1.0);
        tom.print();
        Manger jack = new Manger("Jack", 500, 18,1.2);
        jack.setBonus(1000);
        jack.print();
    }
}
class Employee{
    private String name;
    private double dailyWages;
    private int days;
    private double grade;

    public Employee(String name, double dailyWages, int days, double grade) {
        this.name = name;
        this.dailyWages = dailyWages;
        this.days = days;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDailyWages() {
        return dailyWages;
    }

    public void setDailyWages(double dailyWages) {
        this.dailyWages = dailyWages;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void print(){
        System.out.println("姓名："+ name + ", 工资为" + days * dailyWages * grade);
    }
}

class Worker extends Employee{
    public Worker(String name, double dailyWages, int days, double grade) {
        super(name, dailyWages, days, grade);
    }

    @Override
    public void print() {

        super.print();
    }
}
class Manger extends Employee{
    private double bonus;
    public Manger(String name, double dailyWages, int days, double grade) {
        super(name, dailyWages, days, grade);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void print() {
        System.out.println("经理 " + getName() +", 工资为" + (getBonus() + getDailyWages() * getDays() * getGrade()));
    }
}