package com.example.acdemo.ac.mvvmpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.acdemo.R;
import com.example.acdemo.databinding.ActivityLoginUserBinding;

public class LoginUserActivity extends AppCompatActivity {
    private ActivityLoginUserBinding activityLoginUserBinding;
    private LoginUserViewModel loginUserViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityLoginUserBinding= DataBindingUtil.setContentView(this,R.layout.activity_login_user);
        //activityLoginUserBinding.setLifecycleOwner(this);

        loginUserViewModel=new LoginUserViewModel(this);
        activityLoginUserBinding.setLoginview(loginUserViewModel);

        activityLoginUserBinding.setPresenter(new Presenter() {
            @Override
            public void loginData() {

               // showToast("Login Activity");

                final String name=activityLoginUserBinding.editTextTextEmailAddress.getText().toString();
                final String pass=activityLoginUserBinding.editTextTextPassword.getText().toString();
              //  loginUserViewModel.sendLoginRequest(name,pass);
            }
        });
    }

    public void showToast(String msg)
    {
        Toast.makeText(LoginUserActivity.this,msg,Toast.LENGTH_LONG).show();
    }
}