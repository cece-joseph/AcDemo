package com.example.acdemo.ac.mvvmpattern;

import android.util.Log;
import android.util.Patterns;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalLoginModel {

    private String strEmailAddress;
    private String strPassword;

    public FinalLoginModel(String EmailAddress, String Password) {
        strEmailAddress = EmailAddress;
        strPassword = Password;
    }

    public String getStrEmailAddress() {
        return strEmailAddress;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getStrEmailAddress()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getStrPassword().length() > 5;
    }
}
