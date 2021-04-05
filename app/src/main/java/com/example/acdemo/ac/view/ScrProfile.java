package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.acdemo.R;
import com.example.acdemo.databinding.ActivityScrProfileBinding;

public class ScrProfile extends AppCompatActivity {

    ActivityScrProfileBinding activityScrProfileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityScrProfileBinding = ActivityScrProfileBinding.inflate(getLayoutInflater());
        setContentView(activityScrProfileBinding.getRoot());


    }

}





