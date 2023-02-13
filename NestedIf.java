import java.util.Scanner;

public class NestedIf {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入初赛成绩:");
		double score = myScanner.nextDouble();
		if (score > 8.0) {
			System.out.println("您的性别是");
			char gender = myScanner.next().charAt(0);
			if (gender == '男') {
				System.out.println("恭喜晋级男子组决赛");
			} else if (gender == '女') {
				System.out.println("恭喜晋级女子组决赛");
			} else {
				System.out.println("性别输入错误，请重新输入");
			}
		} else {
			System.out.println("sorry,你被淘汰了~");
		}
	}
}
