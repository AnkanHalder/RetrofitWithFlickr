package com.example.jiraiya.retroflikerintern;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSetGallery {

    @SerializedName("photos")
    @Expose
    Photos photos;

    public GetSetGallery() {
    }

    public GetSetGallery(Photos photos) {
        this.photos = photos;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "GetSetGallery{" +
                "photos=" + photos +
                '}';
    }
}
