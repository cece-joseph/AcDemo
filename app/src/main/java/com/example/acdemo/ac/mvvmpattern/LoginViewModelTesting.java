 package com.example.acdemo.ac.mvvmpattern;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModelTesting  extends ViewModel {
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginModelTesting> userMutableLiveData;

    public MutableLiveData<LoginModelTesting> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void makeLoginApicall()
    {

       com.example.acdemo.ac.mvvmpattern.ApiInterface apiInterface= RetrofitBase.getInstance().create(ApiInterface.class);


        Map<String,String> params = new HashMap<>();
        params.put("o_email",EmailAddress.getValue());
        params.put("o_password",Password.getValue());
        Log.d("TAG", "call_loginIn_Api: " + EmailAddress.getValue());
        Call<LoginModelTesting> call=apiInterface.owner_login(params);
        call.enqueue(new Callback<LoginModelTesting>() {
            @Override
            public void onResponse(Call<LoginModelTesting> call, Response<LoginModelTesting> response) {
                //userMutableLiveData.postValue(response.body());
                userMutableLiveData.setValue(response.body());
                Log.d("TAG","res "+response.body().toString());
            }

            @Override
            public void onFailure(Call<LoginModelTesting> call, Throwable t) {

                //userMutableLiveData.postValue(null);
                userMutableLiveData.setValue(null);
                Log.d("TAG","res "+t.getMessage());
            }
        });

    }
    public void onClick(View view) {

        LoginModelTesting loginUser = new LoginModelTesting(EmailAddress.getValue(), Password.getValue());
        userMutableLiveData.setValue(loginUser);


      //  makeLoginApicall();
    }
}
