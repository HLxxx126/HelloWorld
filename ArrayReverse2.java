public class ArrayReverse2 {
	public static void main(String[] args) {
		int[] arr = { 11, 22, 33, 44, 55, 66 };
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[arr.length - i - 1];
		}
		arr = arr2;
		System.out.println("====翻转后的数组====");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}