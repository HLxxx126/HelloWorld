public class Homework12 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100+1);
		}
		System.out.println("数组的元素为");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n倒序元素为");
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i] + "\t");
		}
		double sum = arr[0];
		int max = arr[0];
		int maxIndex = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxIndex = i;
				sum += arr[i];
			}	
		}
		System.out.println("\n元素中最大值为" + max + "下标为" + maxIndex);
		System.out.println("元素的和为" + sum + "平均数为" + (sum / arr.length) );
		int findNum = 8;
		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == findNum) {
				index = i;
				System.out.println("找到了数字" + findNum + "元素下标为" + i);
				break;
			}
		}
		if(index == -1) {
			System.out.println("没有找到数字" + findNum);
		}
	}
}