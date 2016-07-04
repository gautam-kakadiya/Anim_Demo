package com.example.sysadmin.animdemo;

import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by sysadmin on 4/7/16.
 */
public class AnimationUtils {
    public static void setAnimation(MyRViewAdapter.MyViewHolder holder,boolean goesDown){
        ObjectAnimator loadin = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true?200:-200,0);
        loadin.setDuration(500);
        loadin.setInterpolator(new DecelerateInterpolator());
        loadin.start();
    }
}
