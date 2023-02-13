public class IfExercise01 {
	public static void main(String[] args) {
		double a = 22.5;
		double b = 33.8;
		if (a > 10.0 && b < 20) {
			System.out.println("两个数的和为" + (a + b));
		}
		int num1 = 1;
		int num2 = 2;
		int sum = num1 + num2;
		if (sum % 3 == 0 && sum % 5 == 0) {
			System.out.println("和可以被3又能被5整除");
		} else {
			System.out.println("和不可以被3又能被5整除");
		}
		int year = 2050;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "不是闰年");
		}
	}
}