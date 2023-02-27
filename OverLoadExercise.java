public class OverLoadExercise {
	public static void main(String[] args) {
    Methods method = new Methods();
    method.m(8); //64
    method.m(8 , 2); //16
    method.m("韩顺平教育 hello"); //字符串信息
  }
}

class Methods {
	public void m(int a) {
		System.out.println("平方=" + a * a);
	}

	public void m(int a, int b) {
		System.out.println("相乘=" + a * b);
	}

	public void m(String str) {
		System.out.println("传入的str=" + str);
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public double max(double a, double b) {
		return a > b ? a : b;
	}

	public double max(double a, double b, double c) {
		double max1 = a > b ? a : b;
		return max1 > c ? max1 : c;
	}
}