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

    public Photo(String id, String owner, String url_s, String title) {
        this.id = id;
        this.owner = owner;
        this.url_s = url_s;
        this.title = title;
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

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", url_s='" + url_s + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
