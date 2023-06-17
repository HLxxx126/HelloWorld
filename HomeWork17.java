package hl;

public class HomeWork17 {
	public static void main(String[] args) {
		Circle1 circle = new Circle1(2.2);
		System.out.println("周长=" + circle.perimeter());
		System.out.println("面积=" + circle.area());
	}

}

class Circle1 {
	double radius;
	
	public Circle1(double radius) {
		this.radius = radius;
	}

	public double perimeter() {
		return 2 * radius * Math.PI;
	}

	public double area() {
		return Math.PI * radius * radius;
	}
}
