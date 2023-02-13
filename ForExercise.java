public class ForExercise {
	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		for (int n = 1;n <= 100; n++) {
		  if(n % 9 ==0) {
			System.out.println("n=" + n);  
			count++;
			sum += n;
		  }
	  }
		System.out.println("count=" + count);
		System.out.println("sum=" + sum);
	}
}	