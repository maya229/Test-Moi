package com.example.testmoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroActivity extends AppCompatActivity {


    ImageView logo,splashImg;
    Button B;
    LottieAnimationView lottieAnimationView;

    private static int Splash_Time_out = 5500;
    SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);



        Button button = (Button) findViewById(R.id.createNewBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
                finish();
            }
        });



        logo=findViewById(R.id.logo);
        splashImg=findViewById(R.id.img);
        lottieAnimationView=findViewById(R.id.lottie);
        B=findViewById(R.id.createNewBtn);

        splashImg.animate().setDuration(1000).setStartDelay(4000);
        logo.animate().setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().setDuration(500).setStartDelay(4000);
        B.animate().setDuration(200).setStartDelay(1000);



}}