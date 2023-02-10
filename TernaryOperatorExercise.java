public class TernaryOperatorExercise {
  public static void main(String[] args) {
	//实现3个数中最大数
	int n1 = 55;
	int n2 = 33;
	int n3 = 123;
	//思路
	//1.先得到n1和n2中最大数，保存到max1
	//2.再用max1和n3比价得出最大数，保存到max2
	int max1 = n1 > n2 ? n1 : n2;
	int max2 = max1 > n3 ? max1 : n3;
	System.out.println("最大数= " + max2);
	//使用一条语句完成
	int max = (n1 > n2 ? n1 : n2) > n3 ? (n1 > n2 ? n1 : n2) : n3;
	System.out.println("最大数= " + max);
	}	
}
	