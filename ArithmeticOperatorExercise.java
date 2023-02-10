public class ArithmeticOperatorExercise {
  public static void main(String[] args) {
	//假如还有59天放假，问合XX个星期零XX天
	int days = 59;
	int weeks = days / 7;
	int leftDays = 59 % 7;
	System.out.println(days + "天，合" + weeks + "个星期零" + leftDays + "天");
	 //定义一个变量保存华氏温度，华氏温度转换摄氏温度的公式为：5/9*（华氏温度-100），求出华氏温度对应的摄氏温度。
	double fahrenheit = 234.5;
	double celsius = 5.0 / 9 * (fahrenheit - 100);
	System.out.println("华氏温度是" +fahrenheit + "对应的摄氏温度是" + celsius);
  }
}