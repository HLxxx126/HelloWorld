package com.hspedu.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("jacknamm");
        person.setAge(300);
        person.setSalary(30000);
        System.out.println(person.info());
        Person p2 =new Person("wtnbskk", 130, 50000);
        System.out.println(p2.info());
    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        setName(name);
        setAge(age);
        setSalary(salary);
    }
//自己写太慢了，可以使用快捷键

    public String getName() {
        return name;
    }

    public void setName(String name) {
       if (name.length() >= 2 && name.length() <= 6 ){
           this.name = name;
       } else {
           System.out.println("名字的长度不对，需要（2-6）字符，显示默认名字");
           this.name = "无名氏";
       }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("年龄设置啊不对，年龄需要在1-120之间，给默认年龄20");
            this.age = 20;
        }
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String info(){
        return "信息为 name = " + name + ",age = " + age + ",salary = " + salary;
    }
}
