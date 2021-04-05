package com.example.acdemo.ac.mvvmpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.acdemo.R;

public class ScrTesting extends AppCompatActivity implements View.OnClickListener {

    FrgmentTesting fragment;
    Button bt_submit;


    public ScrTesting()
    {

    }

    public ScrTesting(FrgmentTesting fragment)
    {
        this.fragment=fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_testing);


        fragment = new FrgmentTesting(this);
        loadFragment(fragment);

        bt_submit=findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(this);


    }



    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onClick(View v) {
        fragment.Validate();

    }
}