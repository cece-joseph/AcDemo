package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.acdemo.R;

public class ScrStartCourse extends AppCompatActivity implements View.OnClickListener {

    private Button bt_get_started;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_start_course);


        initUi();
    }

    public void initUi()
    {
        bt_get_started=findViewById(R.id.bt_get_started);
        bt_get_started.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bt_get_started:
                Intent intent = new Intent(ScrStartCourse.this, ScrHomeCertificationCourseDetails.class);
                Toast.makeText(ScrStartCourse.this,"Joined Course Sucessfully !",Toast.LENGTH_LONG).show();
                startActivity(intent);
                break;
        }
    }
}