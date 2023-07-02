package com.roomdb.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button start_btn, stop_btn;
    private TextView first_textview, second_textview;

    private CountDownTimer countDownTimerOne, countDownTimerTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of variables
        start_btn = findViewById(R.id.btn_start);
        stop_btn = findViewById(R.id.btn_stop);

        first_textview = findViewById(R.id.time_one);
        second_textview = findViewById(R.id.time_two);


        stop_btn.setEnabled(false);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start  both counter
                timeOne();
                timeTwo();

                //enable stop button and disabled stop button while countDown will start
                start_btn.setEnabled(false);
                stop_btn.setEnabled(true);


            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimerOne.cancel();
                countDownTimerTwo.cancel();

                //disable stop button and enable start button after countdown stop

                stop_btn.setEnabled(false);
                start_btn.setEnabled(true);
            }
        });

    }
    private void timeTwo() {

        countDownTimerTwo =new CountDownTimer(120000,1000) {
            @Override
            public void onTick(long l) {
                long minute = TimeUnit.MILLISECONDS.toMinutes(l)%60;
                long seconds = TimeUnit.MILLISECONDS.toSeconds(l)%60;

                second_textview.setText(String.format("%02d : %02d",minute,seconds));
            }

            @Override
            public void onFinish() {
                first_textview.setText("2 minutes Finished!");
                first_textview.setTextColor(Color.parseColor("#63FF00"));
            }
        }.start();

    }

    private void timeOne() {
        countDownTimerOne = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                first_textview.setText("00 : " + String.format("%02d", l / 1000));

            }

            @Override
            public void onFinish() {
                first_textview.setText("10s Finished!");
                first_textview.setTextColor(Color.parseColor("#63FF00"));


            }
        }.start();


    }

}