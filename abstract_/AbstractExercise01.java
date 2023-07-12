package com.hspedu.chapter10.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manger manger = new Manger("jack", "JACK", 50000, 200000);
        CommonEmployee commonEmployee = new CommonEmployee("tom", "TOM", 20000);
        manger.work();
        commonEmployee.work();
    }
}
abstract class Employee{
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();
    }
    class CommonEmployee extends Employee{
        public CommonEmployee(String name, String id, double salary) {
            super(name, id, salary);
        }
        @Override
        public void work() {
            System.out.println("普通员工" + getName() +"工作中。。。"  );
        }
    }
class Manger extends Employee{
    private double bonus;

    public Manger(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理" + getName() +"工作中。。。");
    }
}