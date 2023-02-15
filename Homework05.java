public class Homework05 {
	public static void main(String[] args) {
		double money = 100000;
		/*
		 * int i=0; while(money > 50000) { money -= 0.05 * money; i++; } while(money
		 * <=50000 && money>= 1000) { money -= 1000; i++; } System.out.println("可通行" + i
		 * + " 次，剩余金额为" + money + "元");
		 */

		int count = 0;
		while (true) {
			if (money > 50000) {
				// money = money - 0.05 * money;
				money *= 0.95;
				count++;
			} else if (money >= 1000 && money <= 50000) {
				money -= 1000;
				count++;
			} else {
				break;
			}
		}
		System.out.println("可通行" + count + " 次，剩余金额为" + money + "元");
	}
}
