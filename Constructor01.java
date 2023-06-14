public class Constructor01{
	public static void main(String[]args) {
		Person1 p1 = new Person1("Smith", 80);
		Person1 p2 = new Person1("Tom");
		System.out.println("p1的信息如下");
		System.out.println("p1对象name=" + p1.name);
		System.out.println("p1对象age=" + p1.age);
		Dog dog1 = new Dog();
	}  
}
class Dog{
	//默认构造器Dog（）{
	//}
}
class Person1{
	String name;
	int age;
	public Person1(String pname, int page) {
		System.out.println("构造器被调用～～完成对象属性的初始化");
		name = pname;
		age = page;
	}
	public Person1(String pname) {
		name=pname;
	}
}