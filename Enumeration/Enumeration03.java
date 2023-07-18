package com.hspedu.chapter11.Enumeration;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.AUTUMN);
    }
}

enum Season2 {//自定义枚举类实现

    //    public final static Season2 SPRING = new Season2("春天","温暖");
//    public final static Season2 WINTER = new Season2("冬天","寒冷");
//    public final static Season2 SUMMER = new Season2("夏天","炎热");
//    public final static Season2 AUTUMN = new Season2("秋天","凉爽");
//如果使用enum关键字来实现枚举类
// 1.使用enum关键字替代class
// 2. public final static Season2 SPRING = new Season2("春天","温暖");直接使用 SPRING("春天", "温暖");
// 3.如果有多个常量， 用 , 号间隔
// 4.如果使用enum关键字实现枚举，要求将定义常量对象写在最前面
// 5.如果使用的是无参构造器，创建常量对象，可以省略（）
    SPRING("春天", "温暖"),
    WINTER("冬天","寒冷"),
    SUMMER("夏天","炎热"),
    AUTUMN ("秋天","凉爽");//,WHAT;
    private String name;
    private String desc;//描述
    private Season2(){//无参构造器

    }

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDesc() {
        return desc;
    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}