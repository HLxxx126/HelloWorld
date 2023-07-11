package com.hspedu.chapter10.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        CC cc = new CC();
        new EE().cal();
    }
}
class AA{
    final public double TAX_RATE = 0.08;//命名规范
    final public double TAX_RATE2;
    final public double TAX_RATE3;
    public AA(){
        TAX_RATE2 = 1.1;
    }
    {
        TAX_RATE3 = 8.8;
    }
}
class BB{
     public static final double TAX_RATE = 99.9;
    public static final double TAX_RATE2;
//    public static final double TAX_RATE3;
//    public B(){
//        TAX_RATE3 = 3.3;
//    }
   static  {
        TAX_RATE2 = 3.3;
    }
}
final class CC{}//不能被继承，但能实例化对象
class DD{
    public final void cal(){
        System.out.println("cal()");
    }
}
class EE extends DD{}//不能重写final的方法，但能继承调用