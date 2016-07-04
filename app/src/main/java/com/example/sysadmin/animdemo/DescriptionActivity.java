package com.example.sysadmin.animdemo;

import android.animation.Animator;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        if(Build.VERSION.SDK_INT>=21){

            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition_a));
            getWindow().setSharedElementReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition_b));
            Slide slide = new Slide();
            slide.setDuration(500);
            slide.setInterpolator(new DecelerateInterpolator());
            View decor = getWindow().getDecorView();
            int id = R.id.action_bar_container;
            slide.excludeTarget(decor.findViewById(id),true);
            slide.excludeTarget(android.R.id.statusBarBackground,true);
            getWindow().setEnterTransition(slide);
        }
        /*View v = findViewById(R.id.container_view);
        int cx = v.getWidth()/2;
        int cy = v.getHeight()/2;

        float finalradius = (float) Math.hypot(cx,cy);
        if(Build.VERSION.SDK_INT>=21) {
            Animator anim = ViewAnimationUtils.createCircularReveal(v, cx, cy, 0, finalradius);
            v.setVisibility(View.VISIBLE);
            anim.start();
        }*/
    }
}
