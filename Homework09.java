public class Homework09 {
	public static void main(String[] args) {
		/*double sum1 = 0;//分母为偶数的和
		double sum2 = 0;//分母为奇数的 
		double sum = 0;
		for(int i = 1;i <=50;i++) {
			sum1 -= 1.0 / (2 * i);
			sum2 += 1.0 /(2 * i - 1);		
			}
		sum = sum1 + sum2;
		System.out.println(sum);*/
		double sum = 0;
		for (int i = 1; i <= 100; i++) {
			if(i % 2 != 0) { //分母为奇数
				sum = sum + (1.0 / i);
			} else { //偶数
				sum = sum - (1.0 / i);
			}
		}
		System.out.println(sum);
	}
}
