package com.hspedu.object_;

public class ToString {
    public static void main(String[] args) {
        Monster monster = new Monster("小妖怪", "巡山", 3889.3);
        System.out.println(monster.toString() + " hashCode = " +monster.hashCode());//重写前toString是hashcode的16进制
        System.out.println(monster);//默认调用toString，等价monster.toString()
    }
}
class Monster{
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }
    //重写toString方法，输出对象的属性//用快捷键可生成


    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}