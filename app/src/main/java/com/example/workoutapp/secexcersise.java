package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class secexcersise extends AppCompatActivity {
    Button startbtn;
    TextView mTextview;
    private CountDownTimer countDownTimer;
    private boolean mTimerrunning;
    private long mTimeLeftmillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secexcersise);
        startbtn=findViewById(R.id.startButton);
        mTextview=findViewById(R.id.time2);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerrunning){
                    stopTime();
                }
                else {
                    startTime();
                }
            }
        });

    }
    private void stopTime()
    {
        countDownTimer.cancel();
        mTimerrunning=false;
        startbtn.setText("Start");
    }
    private void startTime()
    {
        final CharSequence value1=mTextview.getText();
        String num1=value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);

        final int number=Integer.valueOf(num2)*60+Integer.valueOf(num3);
        mTimeLeftmillis=number*1000;
        countDownTimer=new CountDownTimer(mTimeLeftmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                mTimeLeftmillis =millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newValue=Integer.valueOf(number)+1;

            }
        }.start();
        startbtn.setText("Pause");
        mTimerrunning=true;
    }

    private void updateTimer() {
        int minutes= (int) mTimeLeftmillis/60000;
        int seconds= (int) mTimeLeftmillis%60000 / 1000;

        String timeLeftText="";
        if (minutes<10)
            timeLeftText="0";
        timeLeftText=timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mTextview.setText(timeLeftText);

    }

    }

