package com.hspedu.chapter13.string;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringMethod02 {
    public static void main(String[] args) {
        String s = "heLLo";
        System.out.println(s.toUpperCase());//toUpperCase转换成大写
        System.out.println(s.toLowerCase());//toLowerCase转换成小写
        String s1 = "宝玉";
        s1 = s1.concat("林黛玉").concat("薛宝钗").concat("together");//concat拼接字符串
        System.out.println(s1);
        s1 = "宝玉 and 薛宝钗 薛宝钗 薛宝钗";
        s1 = s1.replace("薛宝钗","林黛玉");//replace替换字符串中的字符
        System.out.println(s1);
        //split分割字符串，对某些分割字符需要转译
        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        String[] split = poem.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        poem = "E:\\aaa\\bbb";
        split = poem.split("\\\\");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
            //toCharArray转换成字符数组
            s = "happy";
            char[] chs = s.toCharArray();
            for (int j = 0; j < chs.length; j++) {
                System.out.println(chs[j]);
            }
        }
        //compareTo比较两个字符串的大小，如果前者大，则返回正数，后者大则返回负数，相等则返回0
        String a = "jchn";
        String b = "jack";
        System.out.println(a.compareTo(b));//返回‘c’-‘a’=2
        //format 格式字符串
        // %s-字符串 %c-字符 %d-整形 %.2f-浮点型 称为占位符，这些占位符由后面的变量来替换。
        String name = "john";
        int age = 10;
        double score = 98.3 / 3;
        char gender = '男';
        String info =
                "我的姓名是" + name + "年龄是" + age + "成绩是" + score + "性别是" + gender + "。希望大家喜欢我！";
        System.out.println(info);
        String formatStr = "我的姓名是%s 年龄是%d 成绩是%.2f性别是%c。 希望大家喜欢我!";
        String info2 = String.format(formatStr ,name,age,score,gender);
        System.out.println(info2);
    }
}
