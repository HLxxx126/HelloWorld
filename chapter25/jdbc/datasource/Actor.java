package com.hspedu.chapter25.jdbc.datasource;

import java.util.Date;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Actor {
    private Integer id;
    private String NAME;
    private String sex;
    private String borndate;
    private String phone;

    public Actor() {
    }

    public Actor(Integer id, String NAME, String sex, String borndate, String phone) {
        this.id = id;
        this.NAME = NAME;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
