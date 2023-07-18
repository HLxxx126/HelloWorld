package com.hspedu.chapter11.Enumeration;

public class Enumeration01 {
    public static void main(String[] args) {
        //使用
        Season_ spring = new Season_("春天","温暖");
        Season_ winter = new Season_("冬天","寒冷");
        Season_ summer = new Season_("夏天","炎热");
        Season_ autumn = new Season_("秋天","凉爽");
        //因为对于季节，他的对象（具体值）是固定的4个，不会有更多
        //按现在设计思路，不能体现季节是固定的四个对象
        //因此这样的设计不太好====》枚举类
    }
}
class Season_{//类
    private String name;
    private String desc;//描述

    public Season_(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}