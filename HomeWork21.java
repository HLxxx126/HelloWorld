package hl;

public class HomeWork21 {
	public static void main(String[] args) {

	}
}

class Employee {
	String name;
	char gender;
	String position;
	int age;
	double sal;

	public Employee(String name, char gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public Employee(String position, double sal) {
		this.position = position;
		this.sal = sal;
	}

	public Employee(String name, char gender, int age, String position, double sal) {
		this(name, gender, age);
		this.age = age;
		this.sal = sal;
	}
}