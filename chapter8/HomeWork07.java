package com.hspedu.chapter8;

public class HomeWork07 {
    public static void main(String[] args) {
        LabeledPoint black = new LabeledPoint("Black", 1929, 230.07);
    }
}
class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x) {
        this.x = x;
    }
}
class LabeledPoint extends Point{
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }
}
