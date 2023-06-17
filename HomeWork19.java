package hl;

public class HomeWork19 {
	public static void main(String[] args) {
		Dog dog = new Dog("小葱", "棕色", 3);
		dog.show();
	}
}

class Dog {
	String name;
	String colour;
	int age;

	public Dog(String name, String colour, int age) {
		this.name = name;
		this.colour = colour;
		this.age = age;
	}

	public void show() {
		System.out.println("名字 = " + name + " 颜色 = " + colour + " 年龄 = " + age);
	}
}
