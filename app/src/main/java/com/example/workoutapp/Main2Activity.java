package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        homedata[] homedata = new homedata[]{
                new homedata("Excercise",R.drawable.excerciseicon),
                new homedata("Diet Plan",R.drawable.diet),
                new homedata("Videos",R.drawable.video_icon),
        };


        homedataAdapter homedataAdapter = new homedataAdapter(homedata,Main2Activity.this);
        recyclerView.setAdapter(homedataAdapter);
    }
}
