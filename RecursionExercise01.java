//斐波那契数
public class RecursionExercise01 {
	public static void main(String[] args) {
		T t = new T();
		int n = 18;
		int res = t.Fibonacci(n);
		if (res != -1) {
			System.out.println("当n = " + n + "时，斐波拉契数为 " + res);
		}
	}
}

class T {
	public int Fibonacci(int n) {
		if (n > 0) {
			if (n == 1 || n == 2) {
				return 1;
			} else {
				return Fibonacci(n - 1) + Fibonacci(n - 2);
			}
		} else {
			System.out.println("输入的n需大于0");
			return -1;
		}
	}
}