package com.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class excersisefrag extends AppCompatActivity {
    int[] newArray;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excersise_frag);
        newArray=new int[]{
                R.id.chest,R.id.backbody,R.id.abs,R.id.lowerpart


        };




    }

    public void ImageButtonClicked(View view){
        int i=0;
        for(i=0;i<newArray.length;i++){
            int value =i+1;
            Intent intent=new Intent(excersisefrag.this, secexcersise.class);
            intent.putExtra("value",String.valueOf(value));
            startActivity(intent);

        }
    }
}
