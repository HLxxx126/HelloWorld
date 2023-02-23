public class MiGong {
	public boolean findWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if (findWay(map, i + 1, j)) {
					return true;
				} else if (findWay(map, i, j + 1)) {
					return true;
				} else if (findWay(map, i - 1, j)) {
					return true;
				} else if (findWay(map, i, j - 1)) {
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		int[][] map = new int[8][7];
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int j = 0; j < 8; j++) {
			map[j][0] = 1;
			map[j][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		System.out.println("====现在的地图====");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		MiGong mg = new MiGong();
		mg.findWay(map, 1, 1);
		System.out.println("====找到的路====");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}