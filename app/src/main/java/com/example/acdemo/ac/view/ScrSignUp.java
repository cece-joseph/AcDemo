package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.acdemo.R;

public class ScrSignUp extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_login,tv_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_sign_up);

        initUi();

    }

    public void initUi() {

        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);

        tv_sign_up=findViewById(R.id.tv_sign_up);
        tv_sign_up.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                Intent intent = new Intent(ScrSignUp.this, ScrLogin.class);
                startActivity(intent);
                break;

            case R.id.tv_sign_up:
                Intent i = new Intent(ScrSignUp.this, ScrLogin.class);
                startActivity(i);
                break;
        }
    }
}