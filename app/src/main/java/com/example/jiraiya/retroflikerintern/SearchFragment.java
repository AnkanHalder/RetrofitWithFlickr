package com.example.jiraiya.retroflikerintern;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
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
public class SearchFragment extends Fragment {

    SearchView searchView;
    RecyclerView search_recycler;
    Adapter adapter;
    List<Photo> filtered = new ArrayList<>();
    Call<GetSetGallery> fetch;
    ProgressDialog pd;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search, container, false);
        searchView = (SearchView)view.findViewById(R.id.search_view);
        search_recycler =(RecyclerView)view.findViewById(R.id.search_recycler);

        adapter = new Adapter(getContext(),filtered);
        search_recycler.setAdapter(adapter);
        search_recycler.setLayoutManager(new GridLayoutManager(getContext(),3));
        pd= new ProgressDialog(getContext());
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        api_call("nature");

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(getContext(), "Searching for "+s, Toast.LENGTH_SHORT).show();
                api_call(s);
                searchView.setIconified(true);
                searchView.onActionViewCollapsed();
                hide_keyboard();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    void hide_keyboard(){
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    void api_call(String quary){

        pd.show();
        filtered.clear();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Map<String, String> data = new HashMap<>();
        data.put("api_key", "6f102c62f41998d151e5a1b48713cf13");
        data.put("format", "json");
        data.put("nojsoncallback", "1");
        data.put("extras", "url_s");
        data.put("method", "flickr.photos.search");
        data.put("text",quary);

        fetch =api.search_form_uri(data);

//        if(fetch != null)
//            fetch.cancel();

        fetch.enqueue(new Callback<GetSetGallery>() {
            @Override
            public void onResponse(Call<GetSetGallery> call, Response<GetSetGallery> response) {

                List<Photo> filtered_photo = response.body().getPhotos().getPhoto();

                for(Photo ph : filtered_photo){
                    if(ph.getUrl_s() != null){
                        filtered.add(ph);
                    }
                }
                adapter.notifyDataSetChanged();
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<GetSetGallery> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
