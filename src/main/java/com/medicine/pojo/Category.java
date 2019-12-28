package com.medicine.pojo;

/**
 * Auther:刘双
 * DATE: 2019-11-25-21:18
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.pojo
 */
public class Category {
    /*类别编号*/
    private String catId;
    /*父类编号*/
    private String catParentId;

    private int catSort;
    /*类别说明*/
    private String catExplain;
    /*类别名称*/
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category() {

    }

    @Override
    public String toString() {
        return "Category{" +
                "catId='" + catId + '\'' +
                ", catParentId='" + catParentId + '\'' +
                ", catSort=" + catSort +
                ", catExplain='" + catExplain + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Category(String catId, String title, String catParentId, int catSort, String catExplain) {
        this.catId = catId;
        this.catParentId = catParentId;
        this.catSort = catSort;
        this.catExplain = catExplain;
        this.title = title;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }


    public String getCatParentId() {
        return catParentId;
    }

    public void setCatParentId(String catParentId) {
        this.catParentId = catParentId;
    }

    public int getCatSort() {
        return catSort;
    }

    public void setCatSort(int catSort) {
        this.catSort = catSort;
    }

    public String getCatExplain() {
        return catExplain;
    }

    public void setCatExplain(String catExplain) {
        this.catExplain = catExplain;
    }
}
