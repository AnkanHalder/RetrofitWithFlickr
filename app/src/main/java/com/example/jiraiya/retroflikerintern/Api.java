package com.example.jiraiya.retroflikerintern;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Api {

    String BASE_URL = "https://api.flickr.com/services/";

    @GET("rest/")
    Call<GetSetGallery> form_uri(@QueryMap Map<String, String> options);

    @GET("rest/")
    Call<GetSetGallery> search_form_uri(@QueryMap Map<String, String> options);

}
