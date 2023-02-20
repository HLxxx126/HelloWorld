public class MethedExercise01 {
	public static void main(String[] args) {
		AA a = new AA();
		if(a.isOdd(28)) {
			System.out.println("是奇数");
		} else {
			System.out.println("是偶数");
		}
		a.print(4, 8, '&');
	}
}
class AA {
	public boolean isOdd(int num) {
		return num % 2 != 0 ? true: false;
	}
	public void print(int row, int col,char c) {
		for(int i = 1 ; i <= row ; i++) {
			for(int j = 1; j <= col; j++) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}