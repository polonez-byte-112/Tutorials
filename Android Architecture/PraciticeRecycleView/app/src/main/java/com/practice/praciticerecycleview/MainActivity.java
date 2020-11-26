package com.practice.praciticerecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

  String s1[];
  String s2[];
    int images[]= {R.drawable.netflix, R.drawable.twitch, R.drawable.snapchat, R.drawable.firefox, R.drawable.chrome, R.drawable.amazon, R.drawable.webbrowser,R.drawable.tinder,R.drawable.discord,R.drawable.googledrive, R.drawable.insta};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recycleView);

        s1 = getResources().getStringArray(R.array.app_names);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}