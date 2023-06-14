public class VarScopeDetail{
	public static void main(String[]args) {
		Person p1 = new Person();
		p1.say();//当执行say方法时，say方法的局部变量比如name，会创建，当say执行完毕后
		//name的局部变量就销毁,但是属性（全局变量）仍然可以使用
		T t1 = new T();
		t1.test();
		t1.test2(p1);
	}
}
class T{
	public void test() {
		Person p1 = new Person();
		System.out.println(p1.name); 
	}
	public void test2(Person p) {
		System.out.println(p.name);
	}
}
class Person{
	String name = "jack";
	
	public void say() {
		String name = "king";
		System.out.println("say() name=" + name);
	}
	public void hi() {
		String address = "北京";
		//String address = "上海"; //错误，重复定义变量
	}
}