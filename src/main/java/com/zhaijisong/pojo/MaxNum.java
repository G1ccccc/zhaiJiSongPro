package com.zhaijisong.pojo;

/**
 * @Auther: 龚成
 * @Date: 2020年1月2日19:37:25
 * @Description:
 */
public class MaxNum {
    private String manID;
    private String manName;
    private String manSort;
    private String manRemark;
    private int manQu;
    private String manPre;
    private String manSt;

    public String getManSt() {
        return manSt;
    }

    public void setManSt(String manSt) {
        this.manSt = manSt;
    }

    public String getManID() {
        return manID;
    }

    public void setManID(String manID) {
        this.manID = manID;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManSort() {
        return manSort;
    }

    public void setManSort(String manSort) {
        this.manSort = manSort;
    }

    public String getManRemark() {
        return manRemark;
    }

    public void setManRemark(String manRemark) {
        this.manRemark = manRemark;
    }

    public int getManQu() {
        return manQu;
    }

    public void setManQu(int manQu) {
        this.manQu = manQu;
    }

    public String getManPre() {
        return manPre;
    }

    public void setManPre(String manPre) {
        this.manPre = manPre;
    }

    @Override
    public String toString() {
        return "MaxNo{" +
                "manID='" + manID + '\'' +
                ", manName='" + manName + '\'' +
                ", manSort='" + manSort + '\'' +
                ", manRemark='" + manRemark + '\'' +
                ", manQu=" + manQu +
                '}';
    }

    public MaxNum() {
    }

    public MaxNum(String manID, String manName, String manSort, String manRemark, int manQu) {
        this.manID = manID;
        this.manName = manName;
        this.manSort = manSort;
        this.manRemark = manRemark;
        this.manQu = manQu;
    }
    public MaxNum(String manName, String manSort, int manQu) {
        this.manID = manID;
        this.manName = manName;
        this.manSort = manSort;
        this.manRemark = manRemark;
        this.manQu = manQu;
    }

    public MaxNum(String manName, int manQu) {
        this.manName = manName;
        this.manQu = manQu;
    }
}
