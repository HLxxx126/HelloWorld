package com.hspedu.chapter8.homework5.homework09;

public class HomeWork09 {
    public static void main(String[] args) {
        Student student = new Student("小明", '男', 15, "00023102");
        Teacher teacher = new Teacher("张飞", '男', 30, 5);
        student.printInfo();
        teacher.printInfo();
        Person[] person = new Person[4];
        person[0] = new Teacher("张飞", '男', 30, 5);
        person[1] = new Teacher("孔明", '男', 40, 14);
        person[2] = new Student("小明", '男', 15, "00023102");
        person[3] = new Student("小张", '男', 14, "00023100");
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - 1 - i; j++) {
                Person temp = null;
                if (person[j].getAge() < person[j + 1].getAge()) {
                    temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < person.length; i++) {

            System.out.println(person[i]);
            person[i].test(person[i]);
        }
    }
}
class Person {
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {
        return name + "爱玩";
    }
    public String basicInfo(){
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
    public void test(Person p){
        if (p instanceof Student){
            ((Student)p).study();
        }else if (p instanceof Teacher){
            ((Teacher)p).teach();
        }else {
            System.out.println();
        }
    }
}

class Student extends Person {
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习。");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    public void printInfo(){
        System.out.println("学生的信息：");
        System.out.println(super.basicInfo());
        System.out.println("学号：" + stu_id);
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                '}'+ super.toString();
    }
}

class Teacher extends Person {
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学。");
    }

    public String play() {
        return super.play() + "象棋";
    }

    public void printInfo() {
        System.out.println("老师的信息：");
        System.out.println(super.basicInfo());
        System.out.println("工龄：" + work_age);
        teach();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "work_age=" + work_age +
                '}' + super.toString();
    }
}