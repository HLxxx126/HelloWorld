public class Object01  {
	public static void main(String[] args) {
		Cat cat1 = new Cat();
		cat1.age = 3;
		cat1.name = "小白";
		cat1.colour = "白色";
		cat1.weight = 13.2;
		
		Cat cat2 = new Cat();
		cat2.age = 100;
		cat2.name = "小花";
		cat2.colour = "花色";
		cat2.weight = 33.2;
		System.out.println("第一只猫的信息为 " + cat1.age + " " + cat1.name + " " + cat1.colour +" " + cat1.weight);	
		System.out.println("第二只猫的信息为 " + cat2.age + " " + cat2.name + " " + cat2.colour +" " + cat2.weight);	
	}
}
class Cat{
	int age;
	String name;
	String colour;
	double weight;
}