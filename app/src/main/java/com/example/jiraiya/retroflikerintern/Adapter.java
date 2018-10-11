package com.example.jiraiya.retroflikerintern;

import android.content.Context;
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
    List<String> images = Collections.EMPTY_LIST;
    LayoutInflater layoutInflater;

    Adapter(Context context,List<String> images){
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
        String path = images.get(i);
        Picasso.get().load(path).placeholder(R.drawable.jiraiya).into(myViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    void addData(int pos,String uri){
        images.add(pos,uri);
        notifyItemInserted(pos);
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView image;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = (ImageView)itemView.findViewById(R.id.single_image);
    }
}
