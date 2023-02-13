import java.util.Scanner;

public class Switch01 {
	public static void main(String[] args) {
		System.out.println("请输入一个字符（a~g）");
		Scanner myScanner = new Scanner(System.in);
		char c1 = myScanner.next().charAt(0);
		switch (c1) {
		case 'a':
			System.out.println("今天是星期一");
			break;
		case 'b':
			System.out.println("今天是星期二");
			break;
		case 'c':
			System.out.println("今天是星期三");
			break;
		case 'd':
			System.out.println("今天疯狂星期四");
			break;
		case 'e':
			System.out.println("今天是星期五");
			break;
		case 'f':
			System.out.println("今天是星期六");
			break;
		case 'g':
			System.out.println("今天是星期日");
			break;
		default:
			System.out.println("输入的字符不正确，请重新输入");
		}
		System.out.println("退出switch继续执行程序");
	}
}