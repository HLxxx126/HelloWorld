public class FloatDetail {
	public static void main(String[] args) {
		//float num1 = 1.1错误
		float num2 = 1.1F;//对
		double num3 = 1.1;//对
		double num4 = 1.1f;//对
		//十进制
		double num5 = .123;//等于0.123
		//科学记数法
		System.out.println(5.12e2);//512
		System.out.println(5.12E-2);//0.0512
		//通常用double，double精度高
		double num9 = 2.1234567851;
		float num10 = 2.123456841f;
		System.out.println(num9);
		System.out.println(num10);
		//浮点使用陷阱：2.7 和 8.1 / 3比较
		double num11 = 2.7;
		double num12 = 8.1 / 3;
		System.out.println(num11);//2.7
		System.out.println(num12);//接近2.7的小数
		//当我们对运算结果是小数的进行相等判断时要小心
		if(num11 == num12) {
			System.out.println("相等");
		}
             //正确写法
		if(Math.abs(num11 - num12) < 0.0001) {
			System.out.println("差值非常小，到我们规定的精度，认为相等..");
		}
	
  }
}