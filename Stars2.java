public class Stars2 {
	public static void main(String[] args) {
		int halfLevel = 10;
		for (int i = 1; i <= halfLevel; i++) {
			for (int k = 1; k <= halfLevel - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				if (j == 1 || j == (2 * i - 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int f = 1; f <= halfLevel - 1; f++) {
			for (int t = 1; t <= f; t++) {
				System.out.print(" ");
			}
			for (int d = 2 * halfLevel - 1 - 2 * f; d >= 1; d--) {
				if (d == 1 || d == 2 * halfLevel - 1 - 2 * f) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}

	}
}
