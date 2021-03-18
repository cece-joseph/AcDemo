package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.acdemo.R;

public class ScrSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // startAnimation();
        startNextScreen();
    }

    public void startAnimation()
    {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void startNextScreen()
    {
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {

                    sleep(3000);
                    Intent intent=new Intent(ScrSplash.this, ScrSelectUserType.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
}