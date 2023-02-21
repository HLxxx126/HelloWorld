public class MethodParameter02 {
	public static void main(String[] args) {
		B b = new B();
		int[] arr = { 1, 2, 3 };
		b.test100(arr);
		System.out.println("这是main的arr数组");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		Person p = new Person();
		p.name = "jack";
		p.age = 10;
		b.test200(p);
		System.out.println("main的age " + p.age);
	}
}

class B {
	public void test200(Person p) {
		p.age = 10000;
	}

	public void test100(int[] arr) {
		arr[0] = 200;
		System.out.println("这是test100的arr数组");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}

class Person {
	String name;
	int age;

}