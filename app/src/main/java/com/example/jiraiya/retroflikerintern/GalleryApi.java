package com.example.jiraiya.retroflikerintern;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GalleryApi {

    String BASE_URL = "https://api.flickr.com/services/";

    @GET("rest/")
    Call<GetSetGallery> form_uri(@QueryMap Map<String, String> options);
}
