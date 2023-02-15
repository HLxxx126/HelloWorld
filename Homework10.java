public class Homework10 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i1 = 1; i1 <= 100; i1++) {
			for (int i2 = 1; i2 <= i1; i2++) {
				sum += i2;
			}
		}
		System.out.println(sum);
	}
}
