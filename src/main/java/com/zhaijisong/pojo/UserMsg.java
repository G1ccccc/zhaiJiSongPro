package com.zhaijisong.pojo;

import java.sql.Timestamp;

/** @Description: 用户建议表
 * @Param:
 * @return:
 * @Author: 龚成
 * @Date: */
public class UserMsg {
    private String opId;
    private String opName;
    private String opEmail;
    private String opContent;//建议内容
    private Timestamp opDate;//日期

    public UserMsg(String opId, String opName, String opEmail, String opContent, Timestamp opDate, String opRemark) {
        this.opId = opId;
        this.opName = opName;
        this.opEmail = opEmail;
        this.opContent = opContent;
        this.opDate = opDate;
        this.opRemark = opRemark;
    }

    public String getOpId() {

        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpEmail() {
        return opEmail;
    }

    public void setOpEmail(String opEmail) {
        this.opEmail = opEmail;
    }

    public String getOpContent() {
        return opContent;
    }

    public void setOpContent(String opContent) {
        this.opContent = opContent;
    }

    public Timestamp getOpDate() {
        return opDate;
    }

    public void setOpDate(Timestamp opDate) {
        this.opDate = opDate;
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    public UserMsg(String opId, String opName, String opEmail, String opContent, Timestamp opDate, String opRemark, String filed, String filed1) {

        this.opId = opId;
        this.opName = opName;
        this.opEmail = opEmail;
        this.opContent = opContent;
        this.opDate = opDate;
        this.opRemark = opRemark;
        this.filed = filed;
        this.filed1 = filed1;
    }

    private String opRemark;
    private String filed;
    private String filed1;


}

