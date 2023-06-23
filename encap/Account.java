package com.hspedu.encap;

import java.security.PrivateKey;

public class Account {
    private String name;
    private double balance;
    private String password;

    public Account(){
    }
    public Account(String name, double balance, String password){
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() == 2 || name.length() == 3 || name.length() == 4) {
            this.name = name;
        } else {
            System.out.println("姓名长度不对，应为2-4位，显示默认值：佚名");
            this.name = "佚名";
    }
}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20){
            this.balance = balance;
        }else{
            System.out.println("余额必须大于20，显示默认余额21");
            this.balance = 21;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6){
            this.password = password;
        } else{
            System.out.println("密码长度有误，密码必须为6位，显示默认密码：123456");
            this.password = "123456";
        }

    }

    public String info(){
        return "姓名 = " + name + " 余额 = " + balance + " 密码 = " + password;
    }
}
