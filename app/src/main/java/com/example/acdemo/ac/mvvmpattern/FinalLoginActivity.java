package com.example.acdemo.ac.mvvmpattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.acdemo.R;
import com.example.acdemo.databinding.ActivityFinalLoginBinding;

import java.util.Objects;

public class FinalLoginActivity extends AppCompatActivity {
    private ActivityFinalLoginBinding activityFinalLoginBinding;
    private FinalLoginViewModel finalLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finalLoginViewModel = ViewModelProviders.of(FinalLoginActivity.this).get(FinalLoginViewModel.class);

        activityFinalLoginBinding = DataBindingUtil.setContentView(FinalLoginActivity.this, R.layout.activity_final_login);

        activityFinalLoginBinding.setLifecycleOwner(this);

        activityFinalLoginBinding.setFinalloginview(finalLoginViewModel);

        finalLoginViewModel.getUser().observe(this, new Observer<FinalLoginModel>() {
            @Override
            public void onChanged(@Nullable FinalLoginModel loginUser) {
               /* activityFinalLoginBinding.setPresenter(new Presenter() {
                    @Override
                    public void loginData() {
                        final String name= activityFinalLoginBinding.editTextTextEmailAddress.getText().toString();
                        final String pass=activityFinalLoginBinding.editTextTextPassword.getText().toString();

                        finalLoginViewModel.sendLoginRequest(name,pass);
                        Toast.makeText(FinalLoginActivity.this,"Login Cliked "+name+pass,Toast.LENGTH_LONG).show();
                    }
                });*/
               activityFinalLoginBinding.editTextTextEmailAddress.setText(loginUser.getStrEmailAddress());
               activityFinalLoginBinding.editTextTextPassword.setText(loginUser.getStrPassword());
                Toast.makeText(FinalLoginActivity.this,"Login Cliked ",Toast.LENGTH_LONG).show();

            }


        });

    }
}