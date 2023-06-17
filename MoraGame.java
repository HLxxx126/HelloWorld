package hl;

import java.util.Random;
import java.util.Scanner;

public class MoraGame {
	public static void main(String[] args) {
		Tom tom = new Tom();
		tom.showInfo();
	}
}

class Tom {
	int tomGuessNum;
	int comGuessNum;
	int winCountNum;
	int count = 1;

	public void showInfo() {
		for (count = 1; count <= 3; count++) {
			System.out.println("第" + count + "局");
			tomGuessNum();
			comGuessNum();

			if (tomGuessNum - comGuessNum == -1 || tomGuessNum - comGuessNum == 2) {
				System.out.println("你赢了");
			} else if (tomGuessNum - comGuessNum == 0) {
				System.out.println("平手");
			} else {
				System.out.println("你输了");
			}
		}
		System.out.println("共赢了" + winCountNum() + "局");
	}

	public int comGuessNum() {
		Random r = new Random();
		comGuessNum = r.nextInt(3);
		System.out.println("电脑出的是" + comGuessNum);
		return comGuessNum;
	}

	public int tomGuessNum() {
		System.out.println("请出拳");
		Scanner scanner = new Scanner(System.in);
		tomGuessNum = scanner.nextInt();
		return tomGuessNum;
	}

	public int winCountNum() {
		int winCountNum = 0;
		if (tomGuessNum - comGuessNum == -1 || tomGuessNum - comGuessNum == 2) {
			winCountNum += 1;
		}
		return winCountNum;

	}
}
