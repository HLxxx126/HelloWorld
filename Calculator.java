/*
This is an Abacus that is used to slide beads around and do math.
It was created by Laura in 2019.
*/
public class Calculator {
	public static void main(String[] args) {
		Calculator myCalculator = new Calculator();
		System.out.println(myCalculator.add(5, 7));
		System.out.println(myCalculator.subtract(45, 11));
		System.out.println(myCalculator.multiply(8, 11));
		System.out.println(myCalculator.divide(60, 11));
		System.out.println(myCalculator.modulo(8, 3));
	}

	public int add(int a, int b) {
		int sum = a + b;
		return sum;
	}

	public int subtract(int a, int b) {
		int difference = a - b;
		return difference;
	}

	public int multiply(int a, int b) {
		int result = a * b;
		return result;
	}

	public double divide(double a, double b) {
		double result = a / b;
		return result;
	}

	public int modulo(int a, int b) {
		int result = a % b;
		return result;
	}
}
