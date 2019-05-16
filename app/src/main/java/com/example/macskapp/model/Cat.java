package com.example.macskapp.model;

import com.orm.SugarRecord;

public class Cat extends SugarRecord {
    private String catId = null;
    private String catName = "Tita";
    private int catnumber = 0;
    private String url = null;
    private String categoryName= null;
    private String description = "Ez a legjobb leiras ever";
    private String contact = "06-1-234-5678";

    public Cat(){
        super();
    }

    public Cat(String catId, String url, String categoryName){
        super();
        this.catId = catId;
        this.url = url;
        this.categoryName = categoryName;
        setCatName();
    }

    public Cat(String catName, String description, String categoryName, String contact){
        super();
        this.catName = catName;
        this.description = description;
        this.categoryName = categoryName;
        this.contact = contact;
    }

    public String getCatId() {
        return catId;
    }
    public void setId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }
    public void setCatName() {
        this.catName += catnumber;
        catnumber++;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }
    public String getContact() {
        return contact;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
