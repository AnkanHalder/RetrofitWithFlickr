package com.example.jiraiya.retroflikerintern;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    RecyclerView recyclerView;
    List<String> gsg = new ArrayList<>();
    Adapter adapter;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.gallery_recycler_view);

//        for(int i=0;i<60;i++){
//            GetSetGallery gall = new GetSetGallery();
//            gsg.add(gall);
//        }

        adapter = new Adapter(getContext(),gsg);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),5));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GalleryApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GalleryApi galleryApi = retrofit.create(GalleryApi.class);

        Map<String, String> data = new HashMap<>();
        data.put("api_key", "6f102c62f41998d151e5a1b48713cf13");
        data.put("format", "json");
        data.put("nojsoncallback", "1");
        data.put("extras", "url_s");
        data.put("method", "flickr.photos.getRecent");

        Call<GetSetGallery> fetch =galleryApi.form_uri(data);

        fetch.enqueue(new Callback<GetSetGallery>() {
            @Override
            public void onResponse(Call<GetSetGallery> call, Response<GetSetGallery> response) {
                Log.d("Received",response.toString());
                Log.d("Received",response.body().toString());

                List<Photo> photo = response.body().getPhotos().getPhoto();
                int i=0;
                for(Photo ph : photo){

                    Log.d("URLS","Url "+i+" :"+ph.getUrl_s());
                    if(ph.getUrl_s() != null){
                        gsg.add(ph.getUrl_s());
                    }
                }
                adapter.notifyDataSetChanged();
                Log.d("Received_count","Size "+photo.size());
            }

            @Override
            public void onFailure(Call<GetSetGallery> call, Throwable t) {

                Log.d("Received",call.toString());
                Log.d("Received",t.getMessage());
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });





    }
}
