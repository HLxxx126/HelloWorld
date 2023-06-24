package com.hspedu.extend.exercise;

public class ExtendsExercise03 {
    public static void main(String[] args) {
        PC pc = new PC("intel",16, 500, "IBM");
        NotePad notePad = new NotePad("DEll",32,200,"red");
        pc.printInfo();
        notePad.printInfo();
    }
}
class Computer{
   private String CPU;
   private int memory;
    private int disk;
    public Computer(String CPU, int memory, int disk) {
        this.CPU = CPU;
        this.memory = memory;
        this.disk = disk;
    }
    public String getDetails(){
        return "CPU为" + CPU + " 内存为" + memory + " 硬盘为" + disk;
    }
    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }
}
class PC extends Computer{
   private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public PC(String CPU, int memory, int disk, String brand) {
        super(CPU, memory, disk);
        this.brand = brand;
    }
    public void printInfo(){
        System.out.println("PC信息如下：");
        System.out.println(getDetails() + " 品牌为" + brand);
    }
}
class NotePad extends Computer{
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NotePad(String CPU, int memory, int disk, String color) {
        super(CPU, memory, disk);
        this.color = color;
    }
    public void printInfo(){
        System.out.println("NotePad信息如下：");
        System.out.println(getDetails() + " 颜色为" + color);
    }
}
