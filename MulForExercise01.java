import java.util.Scanner;

public class MulForExercise01 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		double totalScore = 0;
		int passNum = 0;
		for (int j = 1; j <= 3; j++) {
			double sum = 0;
			for (int i = 1; i <= 5; i++) {
				System.out.println("请输入第" + j + "个班的第" + i + "个学生的成绩");
				double score = myScanner.nextDouble();
				if (score >= 60) {
					passNum++;
				}
				sum += score;
			}
			System.out.println("sum= " + sum + "平均分= " + (sum / 5));
			totalScore += sum;
		}
		System.out.println("三个班总分= " + totalScore + "平均分= " + (totalScore / 15));
		System.out.println("及格的人数为 " + passNum);
	}
}
