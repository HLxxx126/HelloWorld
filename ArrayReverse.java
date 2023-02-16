public class ArrayReverse {
	public static void main(String[] args) {
		int[] arr = { 11, 22, 33, 44, 55, 66 };
		int len = arr.length;
		int temp = 0;
		for (int i = 0; i < len / 2; i++) {
			temp = arr[len - 1 - i];
			arr[len - 1 - i] = arr[i];
			arr[i] = temp;
		}
		System.out.println("====翻转后的数组====");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}