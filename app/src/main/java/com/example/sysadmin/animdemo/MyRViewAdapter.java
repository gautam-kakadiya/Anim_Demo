package com.example.sysadmin.animdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sysadmin on 1/7/16.
 */
public class MyRViewAdapter extends RecyclerView.Adapter<MyRViewAdapter.MyViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    private Bitmap bmp;
    private Context context;
    private int previospos=0;
    private int currentpos;
    public MyRViewAdapter(Context context,Bitmap bmp){
        inflater = LayoutInflater.from(context);
        this.bmp = bmp;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =inflater.inflate(R.layout.item_card_view,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.img.setImageBitmap(bmp);
        holder.cv.setOnClickListener(this);
        currentpos = position;
        if(currentpos>previospos) {
            AnimationUtils.setAnimation(holder, true);
        }else{
            AnimationUtils.setAnimation(holder,false);
        }
        previospos = currentpos;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onClick(View view) {
        Intent callIntent = new Intent(context,DescriptionActivity.class);
        String transitionName = "transition";
        Pair<View, String> p1 = Pair.create(view,"cardTransition");
        //Pair<View, String> p2 = Pair.create(view,"cardTransition");
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context,p1);
        ActivityCompat.startActivity((Activity) context, callIntent, options.toBundle());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        CardView cv;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgview);
            cv = (CardView) itemView.findViewById(R.id.list_item);
        }
    }
}
