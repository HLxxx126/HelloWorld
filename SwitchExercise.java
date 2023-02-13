import java.util.Scanner;
public class SwitchExercise {
 public static void main(String[] args) {
	 //作业1
  System.out.println("请输入一个字符（a~e）：");
  Scanner myScanner = new Scanner(System.in);
  char c1 = myScanner.next().charAt(0);
  switch(c1) {
   case 'a' : 
        System.out.println("A");
   break;
 case 'b' : 
        System.out.println("B");
   break;
case 'c' : 
        System.out.println("C");
   break;
 case 'd' : 
        System.out.println("D");
   break;
 case 'e' : 
        System.out.println("E");
   break;
 default :
       System.out.println("输入的字符有误");
  }
  //作业2
 System.out.println("请输入成绩");
 double score = myScanner.nextDouble();
 if(score >= 0 && score <= 1000) {
 switch((int) (score/60)) {
   case 0 :
     System.out.println("不合格");
     break;
   case 1 :
     System.out.println("合格");
     break;
   //default :
  //  System.out.println("输入的成绩有误");
   }
  } else {
  System.out.println("输入的成绩需在0~100");
  }
 //作业3
 System.out.println("输入月份");
 int month = myScanner.nextInt();
 switch(month) {
  case 3 :
  case 4 :
  case 5 :
    System.out.println("这是春季");
    break;
  case 6 :
  case 7 :
  case 8 :
    System.out.println("这是夏季");
    break;
  case 9 :
  case 10 :
  case 11 :
    System.out.println("这是秋季");
    break;
  case 12 :
  case 1 :
  case 2 :
    System.out.println("这是冬季");
    break;
  default :
   System.out.println("输入的月份有误");
  }
 }
}