package com.example.sysadmin.animdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRViewAdapter mRviewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int id =  R.mipmap.ic_launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        Log.d("Height",dpHeight+"");
        Log.d("Width",dpWidth+"");*/

        mRecyclerView = (RecyclerView) findViewById(R.id.rview);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),id);
        mRviewAdapter = new MyRViewAdapter(this,bmp);
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRviewAdapter);
    }
}
