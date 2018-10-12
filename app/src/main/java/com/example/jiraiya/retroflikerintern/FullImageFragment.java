package com.example.jiraiya.retroflikerintern;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class FullImageFragment extends Fragment {

    ImageView full_image;
    TextView textview_id;
    public FullImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String uri = getArguments().getString("uri");
        String id = getArguments().getString("id");
        View v= inflater.inflate(R.layout.fragment_full_image, container, false);
        full_image = (ImageView)v.findViewById(R.id.full_image);
        textview_id = (TextView)v.findViewById(R.id.image_id);
        textview_id.setText("ID- "+id);
        Picasso.get().load(uri).placeholder(R.drawable.jiraiya).into(full_image);
        return v;
    }

}
