package com.example.mvvmjavadagger.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatModel {


    @SerializedName("id")
    @Expose
    private String id = null;
    @SerializedName("url")
    @Expose
    private String url = null;
    @SerializedName("width")
    @Expose
    private Integer width = null;
    @SerializedName("height")
    @Expose
    private Integer height = null;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}