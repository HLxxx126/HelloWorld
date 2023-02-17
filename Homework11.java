public class Homework11 {
	public static void main(String[] args) {
		int[] arr = { 10, 12, 45, 90 };
		int addNum = 23;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (addNum <= arr[i]) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			index = arr.length;
		}
		int[] arr2 = new int[arr.length + 1];
		for (int i = 0, j = 0; i < arr2.length; i++) {
			if (i != index) {
				arr2[i] = arr[j];
				j++;
			} else {
				arr2[i] = addNum;
			}
		}
		arr = arr2;
		System.out.println("插入元素后，数组的元素为");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}