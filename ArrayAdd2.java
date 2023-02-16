import java.util.Scanner;

public class ArrayAdd2 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		do {
			int[] arr = { 1, 2, 3 };
			int[] arrNew = new int[arr.length + 1];
			for (int i = 0; i < arr.length; i++) {
				arrNew[i] = arr[i];
			}
			System.out.println("请输入添加的数字：");
			int addNum = myScanner.nextInt();
			arrNew[arrNew.length - 1] = addNum;
			arr = arrNew;
			System.out.println("====扩容后的数组元素====");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}
			System.out.println("是否添加新的数字？ y/n");
			char answer = myScanner.next().charAt(0);
			if (answer == 'n') {
				break;
			}
		} while (true);
	}
}