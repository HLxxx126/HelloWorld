//九九乘法表
public class MulForExercise02 {
	public static void main(String[] args) {
		int i;
		int j;
		for (i = 1; i <= 9; i++) {
			for (j = 1; j <= i; j++) {
				System.out.print(j + " * " + i + " = " + (j * i) + "\t");
			}
			System.out.println();
		}
	}
}
