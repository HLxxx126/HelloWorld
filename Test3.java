package hl;

public class Test3 {
	int count = 9;

	public void count1() {
		count = 10;
		System.out.println("count1 = " + count);
	}

	public void count2() {
		System.out.println("count1 = " + count++);

	}

	public static void main(String[] args) {
		// 1. new Test()是匿名对象，在堆里，只能用一次
		// 2.new Test ().count1() 创建好匿名对象后，就调用count1方法
		new Test3().count1();
		Test3 t1 = new Test3();
		t1.count2();
		t1.count2();
	}
}