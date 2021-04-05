package com.example.acdemo.ac.finalmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.acdemo.R;
import com.example.acdemo.ac.finalmvvm.presenter.Presenter;
import com.example.acdemo.ac.finalmvvm.viewmodel.NameModel;
import com.example.acdemo.databinding.ActivityScrFinalMvvmBinding;

public class ScrFinalMvvm extends AppCompatActivity {

    ActivityScrFinalMvvmBinding binding;
    private NameModel nameModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_scr_final_mvvm);
        nameModel= ViewModelProviders.of(this).get(NameModel.class);
        binding.setNamemodel(nameModel);

       nameModel.getData().observe(this, new Observer<String>() {
           @Override
           public void onChanged(String s) {
               binding.tvDisplay.setText(s);
           }
       });

        binding.setPresenter(new Presenter() {
            @Override
            public void getData() {
                nameModel.data.setValue("First");
            }
        });
    }
}