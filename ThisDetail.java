public class ThisDetail{
	public static void main(String[]args) {
		F t1 = new F();
		t1.f2();
		t1.f3();
	}
}
class F{
	String name = "jack";
	int num = 100;
	public void f3() {
		String name = "Simth";
		//传统方式
		System.out.println("name=" + name + " num= " + num);//Simth
		//也可以用this访问
		System.out.println("name=" + this.name + " num= " + this.num);//jack
	}
	public void f1() {
		System.out.println("f1() 方法被调用");
	}
	public void f2() {
		System.out.println("f2() 方法被调用");
		//调用本类的方法f1
		//第一种方法
		f1();
		//第二种方法
		this.f1();
	}
	public F() {
		//这里去访问  F(String name , int age)构造器
		//访问构造器语法：this（参数列表）；必须放置第一条语句
		this("jack" , 100);
		System.out.println("F() 构造器");
	}
	public F(String name , int age) {
		System.out.println("F(String name , int age) 构造器");
	}
}