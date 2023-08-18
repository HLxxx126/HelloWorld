package com.hspedu.chapter15.customGeneric;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}
interface IUsb<U , R>{
    int n = 10;
    //U name = "hsp";//错误，接口中静态成员不能使用泛型，接口默认成员为静态成员
    R get(U u);
    void hi(R r);
    void run(R r1, R r2, U u1, U u2);
    default R method(U u){
        return null;
    }
}
//在继承接口时指定泛型接口的类型
interface IA extends IUsb<String,Double>{}
//当实现IA接口时，因为IA在继承IUsb时指定了U为Sting， R为Double，所以在实现IUsb接口的方法时，使用String替换U，Double替换R
class AA implements IA{

    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}
//实现接口时，直接指定泛型接口的类型
class BB implements IUsb<Integer,Float>{//实现IUsb接口方法时，用Integer替换U，Float替换R

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}
//没有指定类型，默认为Object
class CC implements IUsb{

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }
}