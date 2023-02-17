import java.util.Scanner;

public class SeqSearch {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String[] names = { "白眉鹰王", "金毛狮王", "紫衫龙王", "青翼蝠王" };
		System.out.println("请输入名字：");
		String findName = myScanner.next();
		int index = -1; // 标识符
		for (int i = 0; i < names.length; i++) {
			if (findName.equals(names[i])) {
				System.out.println("恭喜你找到" + findName);
				System.out.println("下标为" + i);
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("sorry，没有找到");
		}
	}
}