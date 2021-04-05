package com.example.acdemo.ac.mvvmpattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.acdemo.R;
import com.example.acdemo.ac.view.ScrLogin;
import com.example.acdemo.databinding.ActivityScrSelectBinding;

import java.util.Objects;

public class ScrLoginTesting extends AppCompatActivity{

    private LoginViewModelTesting loginViewModel;

    private ActivityScrSelectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = ViewModelProviders.of(ScrLoginTesting.this).get(LoginViewModelTesting.class);

        binding = DataBindingUtil.setContentView(ScrLoginTesting.this, R.layout.activity_scr_select);

        binding.setLifecycleOwner(this);

        binding.setLoginViewModelTesting(loginViewModel);


        loginViewModel.getUser().observe(this, new Observer<LoginModelTesting>() {
            @Override
            public void onChanged(@Nullable LoginModelTesting loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    binding.txtEmailAddress.setError("Enter an E-Mail Address");
                    binding.txtEmailAddress.requestFocus();
                }
                else if (!loginUser.isEmailValid()) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    binding.txtEmailAddress.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    binding.txtPassword.setError("Enter a Password");
                    binding.txtPassword.requestFocus();
                }
                else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    binding.txtPassword.setError("Enter at least 6 Digit password");
                    binding.txtPassword.requestFocus();
                }
                else {
                    // Toast.makeText(ScrLoginTesting.this,"Login",Toast.LENGTH_LONG).show();
                    //loginViewModel.makeLoginApicall();
                    binding.lblEmailAnswer.setText(loginUser.getStrEmailAddress());
                    binding.lblPasswordAnswer.setText(loginUser.getStrPassword());
                }




            }



        });

    }




   /* @Override
    public void onClick(View v) {

        login();
    }*/
}