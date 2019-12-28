package com.medicine.pojo;

import java.util.*;

/**
 * @Auther: 刘涵
 * @Date: 2019-11-25 14:28
 * @Description:职务信息
 */
public class DutyList {
   /** 职务编号
    *             
    * 
    * @pdOid 0281223e-8bec-4d35-bc88-46c35a320954 */
   private String dutId;
   /** 职务名称
    *             
    * 
    * @pdOid 3ca5b1b0-442d-4e68-9505-2c85d5214ffa */
   private String dutName;
   /** 职务排序
    *             
    * 
    * @pdOid 8e45bef9-371d-40d6-afc4-80423d26cb2b */
   private int dutSort;
   /** 父类职务
    *             
    * 
    * @pdOid 408b4c9b-edea-40a9-a219-0e6b17a54426 */
   private String dutFatherNo;
   /** 职务描述
    *             
    * 
    * @pdOid 42378917-deb1-407c-8bbb-5e65a87e6868 */
   private String dutRemark;

   public String getDutId() {
      return dutId;
   }

   public void setDutId(String dutId) {
      this.dutId = dutId;
   }

   public String getDutName() {
      return dutName;
   }

   public void setDutName(String dutName) {
      this.dutName = dutName;
   }

   public int getDutSort() {
      return dutSort;
   }

   public void setDutSort(int dutSort) {
      this.dutSort = dutSort;
   }

   public String getDutFatherNo() {
      return dutFatherNo;
   }

   public void setDutFatherNo(String dutFatherNo) {
      this.dutFatherNo = dutFatherNo;
   }

   public String getDutRemark() {
      return dutRemark;
   }

   public void setDutRemark(String dutRemark) {
      this.dutRemark = dutRemark;
   }

   public DutyList(String dutId, String dutName, int dutSort, String dutFatherNo, String dutRemark) {
      this.dutId = dutId;
      this.dutName = dutName;
      this.dutSort = dutSort;
      this.dutFatherNo = dutFatherNo;
      this.dutRemark = dutRemark;
   }

   public DutyList() {
   }

   @Override
   public String toString() {
      return "DutyList{" +
              "dutId='" + dutId + '\'' +
              ", dutName='" + dutName + '\'' +
              ", dutSort=" + dutSort +
              ", dutFatherNo='" + dutFatherNo + '\'' +
              ", dutRemark='" + dutRemark + '\'' +
              '}';
   }
}
