package com.example.macskapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatsResult {
    @SerializedName("cats")
    @Expose
    private List<Cat> cats;

    /**
     * @return The cats
     */
    public List<Cat> getCats() {
        return cats;
    }

    /**
     * @param cats The cats
     */
    public void setMovies(List<Cat> cats) {
        this.cats = cats;
    }
}
