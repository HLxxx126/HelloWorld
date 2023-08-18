package com.hspedu.chapter15.customGeneric;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CustomGeneric_ {
    public static void main(String[] args) {
        Tiger<Double, String, Integer> g = new Tiger<Double, String, Integer>("john");
        //T = Double;R = String;M = Integer
        g.setT(10.9);//ok
        //g.setT("yy")//错误，类型不对
        System.out.println(g);
        Tiger g2 = new Tiger("john");//ok,T = Obj;R = Obj;M = Obj
        g2.setT("yy");//ok
        System.out.println(g2);

    }
}
//Tiger后面有泛型，所以把Tiger称为自定义泛型类
//泛型标识符一般为单个的大写字母，泛型的标识符可以有多个 即下面的T，R，M
//普通成员可以使用泛型（属性、方法）
class Tiger<T,R,M>{
    String name;
    R r;//属性使用到泛型
    M m;
    T t;
    //T[] ts = new T[8];//错误，使用泛型的数组不能初始化，因为数组在new时 不能确定T的空¥类型，无法在内存开空间
    public Tiger(String name){
        this.name = name;
    }
    public Tiger(String name, R r, M m, T t) {//构造器使用泛型
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }
    //静态方法中不能使用泛型
    //public static void  m1(M m){}//错误，因为静态时和类相关的，在类加载的时候，对象还没有创建
    //所以如果静态方法和静态属性使用了泛型，JVM就无法完成初始化

    public M getM() {//返回类型使用泛型
        return m;
    }

    public void setM(M m) {//方法使用泛型
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }
}