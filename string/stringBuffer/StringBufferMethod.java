package com.hspedu.chapter13.string.stringBuffer;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");
        //增
        s.append(',');
        s.append("张三丰");
        s.append("赵敏").append(100).append(true).append(10.5);
        System.out.println(s);
        //删
        s.delete(11,14);//删除【11～14）的字符
        System.out.println(s);
        //改
        s.replace(9,11,"周芷若");//使用周芷若替换【9～11）的字符
        System.out.println(s);
        //查
        int indexOf = s.indexOf("张三丰");//超着指定字符在字符串中第一次出现的索引，如果找不到则返回-1
        System.out.println(indexOf);
        //插
        s.insert(9,"赵敏");//在索引9的地方插入赵敏，原先9位置的字符后移
        System.out.println(s);
        //长度
        System.out.println(s.length());
    }
}
