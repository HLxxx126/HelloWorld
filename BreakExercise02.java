import java.util.Scanner;

public class BreakExercise02 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String name = " ";
		String passwd = " ";
		int chance = 3;
		for (int i = 1; i <= 3; i++) {
			System.out.println("请输入姓名： ");
			name = myScanner.next();
			System.out.println("请输入密码： ");
			passwd = myScanner.next();
			if ("丁真".equals(name) && "666".equals(passwd)) {
				System.out.println("登录成功~");
				break;
			}
			chance--;
			System.out.println("姓名或密码错误，你还有" + chance + "次登录机会");
		}
	}
}
