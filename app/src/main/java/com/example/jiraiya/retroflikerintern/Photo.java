package com.example.jiraiya.retroflikerintern;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("owner")
    @Expose
    String owner;

    @SerializedName("url_s")
    @Expose
    String url_s;

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("height_s")
    @Expose
    int height_s;

    @SerializedName("width_s")
    @Expose
    int width_s;

    public Photo() {
    }

    public Photo(String id, String owner, String url_s, String title, int height_s, int width_s) {
        this.id = id;
        this.owner = owner;
        this.url_s = url_s;
        this.title = title;
        this.height_s = height_s;
        this.width_s = width_s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUrl_s() {
        return url_s;
    }

    public void setUrl_s(String url_s) {
        this.url_s = url_s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeight_s() {
        return height_s;
    }

    public void setHeight_s(int height_s) {
        this.height_s = height_s;
    }

    public int getWidth_s() {
        return width_s;
    }

    public void setWidth_s(int width_s) {
        this.width_s = width_s;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", url_s='" + url_s + '\'' +
                ", title='" + title + '\'' +
                ", height_s=" + height_s +
                ", width_s=" + width_s +
                '}';
    }
}
