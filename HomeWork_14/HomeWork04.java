package com.hspedu.chapter14.HomeWork_14;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork04 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);
        set.add((new Person(1001,"CC")));
        System.out.println(set);
        set.add((new Person(1001,"AA")));
        System.out.println(set);
    }
}
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}