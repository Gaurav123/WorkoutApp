package com.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class dietplanmainactivity extends AppCompatActivity {
        Button weightgainbtn,weightloosebtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietplanmainactivity);
        weightgainbtn=findViewById(R.id.weightgain);
        weightloosebtn=findViewById(R.id.weightloose);
        weightgainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dietplanmainactivity.this,gainweight.class));
                finish();
            }
        });
        weightloosebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(dietplanmainactivity.this,looseweight.class));
            finish();
        }
    });
}
}
