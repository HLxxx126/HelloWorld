public class Homework06 {
	public static void main(String[] args) {
		int i = 288;
		int i1 = i / 100; // i 的百位数
		int i2 = i % 100 / 10; // i 的十位数
		int i3 = i % 10; // i的个位数
		if (i1 * i1 * i1 + i2 * i2 * i2 + i3 * i3 * i3 == i) {
			System.out.println(i + "是水仙花数");
		} else {
			System.out.println(i + "不是水仙花数");
		}
	}
}
