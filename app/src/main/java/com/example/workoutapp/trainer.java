package com.example.workoutapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class trainer extends AppCompatActivity {

    TextView title1,description;
    ImageView imageView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainer);

        //title1=(TextView)findViewById(R.id.title);
        //description=(TextView)findViewById(R.id.desciption);
        //imageView=(ImageView) findViewById(R.id.imageview);
    }

}
