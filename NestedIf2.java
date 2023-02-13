import java.util.Scanner;

public class NestedIf2 {
	public static void main(String[] args) {
  Scanner myScanner = new Scanner(System.in);
  System.out.println("请输入月份（1~12）");
  int month = myScanner.nextInt();
  if(month >= 4 && month <= 10) {
    System.out.println("请输入年龄");
    int age = myScanner.nextInt();
    double price = 62.8;
    if(age >= 18 && age <60) {
    System.out.println("票价为：" + price + "元");
   } else if(age <18) {
    System.out.println("票价为：" + (price / 2) + "元");
   } else if(age >= 60) {
    System.out.println("票价为：" + (price / 3) + "元");
   }
  } else if ((month >= 1 && month < 4) || (month > 10 && month <= 12)) {
	int age = myScanner.nextInt();
    if(age >= 18 && age <60) {
    System.out.println("票价为：40元");
   } else {
    System.out.println("票价为：20元");
   }
  } else {
    System.out.println("输入月份有误，请重新输入");
  }
 }
}