package com.hspedu.override;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("dbxt",31);
        System.out.println(person.say());
        Student student = new Student("dbxt",31,"wtnb",69);
        System.out.println(student.say());
    }
}
class Person{
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String say(){
        return "My name is " + name + ". I'm " + age + " years old.";
    }
}
class Student extends Person{

    private String id;
    private int score;
    public Student(String name, int age, String id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }
    public String say() {
        return super.say() + " years old. My id is " + id +". My score is " + score + ".";
    }
}
