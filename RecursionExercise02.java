public class RecursionExercise02 {
	public static void main(String[] args) {
		Tool t = new Tool();
		int day = 1;
		int peachNum = t.peach(day);
		if(peachNum != -1) {
			System.out.println("第" + day +"天有" +peachNum +"个桃子");
		}
	}
}
class Tool {
	public int peach(int day) {
		if(day == 10){
			return 1;
		} else if(day > 0 && day <10) {
			return (peach(day + 1) + 1) *2;
		}else {
			System.out.println("输入的数值有误应为1~10");
			return -1;
		}
	}
}