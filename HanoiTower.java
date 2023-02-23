public class HanoiTower {
	public void move (int n,char a,char b,char c) {
		if(n == 1) {
			System.out.println(a + "->" + c);
		} else {
			move(n - 1,a,c,b);
			System.out.println(a + "->" + c);
			move(n - 1,b,a,c);
		}
	}
	public static void main(String[] args) {
		HanoiTower h1 = new HanoiTower();
		h1.move(1, 'A', 'B', 'C');
	}
}