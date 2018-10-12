package com.example.jiraiya.retroflikerintern;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder>{

    Context context;
    List<Photo> images = Collections.EMPTY_LIST;
    LayoutInflater layoutInflater;
    private int pos=0;


    Adapter(Context context,List<Photo> images){
        this.context = context;
        this.images = images;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = layoutInflater.inflate(R.layout.gallery_images,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(vh);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Photo path = images.get(i);
        Picasso.get().load(path.getUrl_s()).placeholder(R.drawable.jiraiya).into(myViewHolder.image);

        if(i > pos){
            //Scrolling Down
            AnimationUtils.animate(myViewHolder,true);
        }else {
            //Scrolling Up
            AnimationUtils.animate(myViewHolder,false);
        }
        pos = i;

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FullImageFragment fullImageFragment = new FullImageFragment();

                Bundle args = new Bundle();
                args.putString("uri", path.getUrl_s());
                args.putString("id",path.getId());
                fullImageFragment.setArguments(args);

                ((Activity) context).getFragmentManager().beginTransaction().replace(R.id.frame,
                        fullImageFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

}
class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView image;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = (ImageView)itemView.findViewById(R.id.single_image);
    }
}
