public class DoWhile02 {
  public static void main(String[] args) {
    int i = 1;
    do {
      System.out.println(i);
      i++;
    } while(i <=100) ;
    int n = 1;
    int sum = 0;
    do {
      sum += n;
      System.out.println(sum);
      n++;
    } while(n <=100) ;
  }
}
