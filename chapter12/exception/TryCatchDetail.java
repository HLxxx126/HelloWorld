package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TryCatchDetail {
    public static void main(String[] args) {
        //1.如果发生异常，则异常发生后的代码不会执行，直接进入catch块
        //2.如果异常没有发生，则顺序执行try代码块，不会进入catch
        //3.如果希望不管是否发生异常都执行某段代码（比如关闭链接，释放资源等）则使用finally
        try {
            String str = "韩顺平";
            int a = Integer.parseInt(str);
            System.out.println("数字 ： " + a);
        } catch (NumberFormatException e) {
            System.out.println("异常信息 = " + e.getMessage());
        }finally {
            System.out.println("finally代码块被执行。。。");
        }
        System.out.println("程序继续。。。");
    }
}
