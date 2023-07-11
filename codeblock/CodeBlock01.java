package com.hspedu.chapter10.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie movie = new Movie("おそ松さん");
        new Movie("唐探3",100,"陈思成");
    }
}
class Movie{
    private String name;
    private double price;
    private String director;
    {
        System.out.println("电影屏幕打开。。。");
        System.out.println("广告开始。。。");
        System.out.println("电影正式开始。。。");
    }
    public Movie(String name) {

        this.name = name;
    }
    public Movie(String name, double price) {

        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}