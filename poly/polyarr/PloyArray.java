package com.hspedu.poly.polyarr;

public class PloyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("iwmt",30);
        persons[1] = new Student("skm",30,60.2);
        persons[2] = new Student("mgr",27,59.8);
        persons[3] = new Teacher("abe",29,5900.8);
        persons[4] = new Teacher("rul",20,3800);
        for (int i = 0; i < persons.length ; i++) {
            System.out.println( persons[i].say() );
            if (persons[i] instanceof Student){
//                Student student = (Student) persons[i];//向下转型
//                student.study();
                ((Student) persons[i]).study();
            } else if (persons[i] instanceof Teacher){
                ((Teacher)persons[i]).teach();
            } else if (persons[i] instanceof Person){
            }else {
                System.out.println("信息有误，请检查");
            }
        }
    }
}
