package com.zhaijisong.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class ExcelDemo {
    public ExcelDemo() {
    }

    private int id;
    private String name;
    private int sex;
    private Date borndate;
    //导入获取日期数据
    private String borndatestr;

    public ExcelDemo(int id, String name, int sex, String borndatestr) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndatestr = borndatestr;
    }

    public String getBorndatestr() {

        return borndatestr;
    }

    public void setBorndatestr(String borndatestr) {
        this.borndatestr = borndatestr;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public ExcelDemo(int id, String name, int sex,Date borndate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
    }
}
