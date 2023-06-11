public class EightQueen{
	public static void main(String[]args) {
		Queen8 queen8 = new Queen8();
		queen8.check(0);
	}
}
class Queen8{
	int max = 8 ;
	int arr[] = new int[max];
	public void print() {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public boolean judge(int n) {
		for(int i = 0; i < n; i++) {
			if(arr[i]== arr[n] ||  arr[n] == arr[i]+(n-i) || arr[n] == arr[i]-(n-i)) {
					//Math.abs(n - 1)== Math.abs(arr[n] - arr[i])){
				return false;
			}
		}
		return true;
	}
	public void check(int n) {
		if(n == max) {
			print();
			return;
		}
		for(int i = 0; i < max ; i++) {
			arr[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}
}