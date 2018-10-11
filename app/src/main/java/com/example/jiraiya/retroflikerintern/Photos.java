package com.example.jiraiya.retroflikerintern;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Photos {

    @SerializedName("page")
    @Expose
    int page;

    @SerializedName("pages")
    @Expose
    int pages;

    @SerializedName("perpage")
    @Expose
    int perpage;

    @SerializedName("total")
    @Expose
    int total;

    @SerializedName("photo")
    @Expose
    ArrayList<Photo> photo;

    public Photos() {
    }

    public Photos(int page, int pages, int perpage, int total, ArrayList<Photo> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<Photo> photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "page=" + page +
                ", pages=" + pages +
                ", perpage=" + perpage +
                ", total=" + total +
                ", photo=" + photo +
                '}';
    }
}
