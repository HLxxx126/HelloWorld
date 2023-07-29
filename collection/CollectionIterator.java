package com.hspedu.chapter14.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
        //System.out.println("col = " + col);
        //遍历col集合
        //先得到col对应的迭代器
        Iterator iterator = col.iterator();
        //使用while循环遍历
        /*while (iterator.hasNext()) {//判断是否还有数据
            //返回下一个元素，类型是object
            Object obj = iterator.next();
            System.out.println("obj = " + obj);
        }*/
        //快捷键itit+回车//ctrl+j显示所有快捷键

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj = " + obj);
        }
        //退出while后，iterator迭代器指向最后的元素
        //再次iterator.next（）会抛出NoSuchElementException异常
        //如果希望再次遍历，需要重置迭代器
        iterator = col.iterator();
        System.out.println("----第二次遍历----");
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;


    }
}