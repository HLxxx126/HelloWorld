public class This01{
	public static void main(String[]args) {
		Dog1 dog1 =new Dog1("Tom" , 3);
		System.out.println("dog1的hashcode=" + dog1.hashCode());
		dog1.info();
		Dog1 dog2 =new Dog1("Jack" , 2);
		System.out.println("dog2的hashcode=" + dog2.hashCode());
		dog2.info();
	}
}
class Dog1{
	String name;
    int age;
	public Dog1(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("this.hashCode=" + this.hashCode());
	}
     public void info() {
    	System.out.println("this.hashCode=" + this.hashCode());
		System.out.println(name + "\t" + age + "\t");
	}
}