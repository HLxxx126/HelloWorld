//克隆对象
public class MethodExercise02 {
	public static void main(String[] args) {
		Person p = new Person();
		p.name = "SKM";
		p.age = 30;
		
		Mytool tool = new Mytool();
		Person p2 = tool.copyPerson(p);
		System.out.println("p的年龄" + p.age + " p的名字" + p.name);
		System.out.println("p2的年龄" + p2.age + " p2的名字" + p2.name);
		System.out.println(p == p2);
	}
}
class Person {
	String name;
	int age;
}

class Mytool {
	public Person copyPerson(Person p) {
		Person p2 = new Person();
		p2.name = p.name;
		p2.age = p.age;
		return p2;
	}
}