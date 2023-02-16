import java.util.Scanner;

public class ArrayReduce {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int[] arr = { 1, 2, 3, 4, 5 };
		do {
			int[] arrNew = new int[arr.length - 1];
			for (int i = 0; i < arr.length - 1; i++) {
				arrNew[i] = arr[i];
			}
			arr = arrNew;
			System.out.println("是否继续缩减数组？ y/n");
			char answer = myScanner.next().charAt(0);
			if (answer == 'n') {
				break;
			}
			System.out.println("====缩减后的数组元素====");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}
		} while (arr.length > 1);
	}
}