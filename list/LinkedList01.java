package com.hspedu.chapter14.list;

/**
 * @author HLxxx
 * @version 1.0
 */
public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("老韩");
        //连接三个结点，形成双向链表
        jack.next = tom;
        tom.next = hsp;

        hsp.pre = tom;
        tom.pre = jack;

        Node first = jack;//让first引用指向jack，就是双向链表的头结点
        Node last = hsp;//让last引用指向hsp，就是双向链表的尾结点
        //从头到尾进行遍历
        System.out.println("====从头到尾进行遍历====");
        while (true){
            if (first == null){
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        //从尾到头的遍历
        System.out.println("====从尾到头进行遍历====");
        while (true){
            if (last == null){
                break;
            }
            //输出first 信息
            System.out.println(last);
            last = last.pre;
        }

        //链表添加对象 在tom和老韩之间插入smith
        //1.创建smith的Node结点 2.更改结点指向
        Node smith = new Node("smith");
        smith.next = hsp;
        smith.pre = tom;
        tom.next = smith;
        hsp.pre = smith;

        //再次遍历重置first和last
        first = jack;
        System.out.println("====插入smith后从头到尾进行遍历====");
        while (true){
            if (first == null){
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        last = hsp;
        System.out.println("====插入smith后从尾到头进行遍历====");
        while (true){
            if (last == null){
                break;
            }
            //输出first 信息
            System.out.println(last);
            last = last.pre;
        }


    }
}
//定义一个Node类，Node对象 表示双向链表的一个结点
class Node{
    public Object item;//真正存放数据的地方
    public Node next;//指向下一个结点
    public Node pre;//指向前一个结点
    public Node(Object name){//构造器
        this.item = name;
    }
    public String toString(){
        return "Node name = " + item;
    }
}