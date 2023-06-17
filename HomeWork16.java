package hl;

public class HomeWork16 {
	public static void main(String[] args) {
		int[] oldArr = { 10, 20, 30 };
		A03 a03 = new A03();
		int[] newArr = a03.copyArr(oldArr);
		System.out.println("====以下为复制数组的值====");
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + "\t");
		}
	}
}

class A03 {
	public int[] copyArr(int[] oldArr) {
		int[] newArr = new int[oldArr.length];
		for (int i = 0; i < oldArr.length; i++) {
			newArr[i] = oldArr[i];
		}
		return newArr;
	}
}
