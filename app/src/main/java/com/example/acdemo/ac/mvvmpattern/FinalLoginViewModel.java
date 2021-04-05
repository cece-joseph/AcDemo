package com.example.acdemo.ac.mvvmpattern;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalLoginViewModel extends ViewModel {
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> userpass = new MutableLiveData<>();
   // Context context;

    private MutableLiveData<FinalLoginModel> userMutableLiveData;

    public MutableLiveData<FinalLoginModel> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }


   /* public void sendLoginRequest(String name, String pass) {
        // showToast("Inside Login View Model");
        //progressBar.set(View.VISIBLE);
        ApiInterface apiInterface = RetrofitBase.getInstance().create(ApiInterface.class);
        HashMap<String, String> params = new HashMap();
        params.put("o_email", name);
        params.put("o_password", pass);

        Log.d("TAG", "values  " + name + "  " + pass);

        Call<FinalLoginModel> call = apiInterface.owner_login(params);
        call.enqueue(new Callback<FinalLoginModel>() {
            @Override
            public void onResponse(Call<FinalLoginModel> call, Response<FinalLoginModel> response) {
                //progressBar.set(View.GONE);
               // showToast(response.body().toString());
                userMutableLiveData.postValue(response.body());
                Log.d("TAG", "response " + response.body());

            }

            @Override
            public void onFailure(Call<FinalLoginModel> call, Throwable t) {
               // progressBar.set(View.GONE);
               // showToast(t.getMessage());
                Log.d("TAG","failure "+t.getMessage());
                userMutableLiveData.postValue(null);


            }
        });
    }*/

  /*  public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
*/
}
