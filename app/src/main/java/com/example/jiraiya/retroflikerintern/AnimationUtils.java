package com.example.jiraiya.retroflikerintern;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

public class AnimationUtils {

    public static void animate(RecyclerView.ViewHolder holder, boolean goesdown){

        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesdown?400:-400,0);
        objectAnimatorY.setDuration(1300);
        objectAnimatorY.start();
    }
}
