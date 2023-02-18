public class Methed01 {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.speak();
		p1.cal01();
		p1.cal02(8);
		int returnSum = p1.getSum(8, 10);
		System.out.println("getSum方法返回的值=" + returnSum);
	}
}
class Person {
	String name;
	int age;

	public void speak() {
		System.out.println("我是一个好人");
	}

	public void cal01() {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println("1~1000相加的和为" + sum);
	}

	public void cal02(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("1~" + n + "相加的和为" + sum);
	}

	public int getSum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
}