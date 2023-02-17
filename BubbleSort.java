public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 24, 69, 80, 57, 13 };
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int n = 1; n <= arr.length - 1 - i; n++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			System.out.println("\n====第" + (i + 1) + "轮====");
			for (int n = 0; n < arr.length; n++) {
				System.out.print(arr[i] + "\t");
			}
		}
	}
}