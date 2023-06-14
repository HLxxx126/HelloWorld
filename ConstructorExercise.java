public class ConstructorExercise{
	public static void main(String[]args) {
		Person2 p1 = new Person2();
		Person2 p2 = new Person2("SKM" , 30);
		System.out.println("p1的信息 name=" + p1.name + " age=" + p1.age);
		System.out.println("p2的信息 name=" + p2.name + " age=" + p2.age);
	}
}
class Person2 {
	String name;
	int age;
	public Person2() {
		age = 18;
	}
	public Person2(String pName , int pAge) {
		name =pName;
		age =pAge;
	}
}