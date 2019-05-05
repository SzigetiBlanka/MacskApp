package com.example.macskapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatResult {

    @SerializedName("Id")
    @Expose
    public String catId;

    @SerializedName("url")
    @Expose
    public String catUrl;

    @SerializedName("categories.name")
    @Expose
    public String categoryname;

    public Cat createCat(){
        return new Cat(catId, catUrl, categoryname);
    }
}
