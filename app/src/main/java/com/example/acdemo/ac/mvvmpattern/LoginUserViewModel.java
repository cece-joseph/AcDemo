package com.example.acdemo.ac.mvvmpattern;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserViewModel extends Observable {

    private Context context;
    public ObservableInt progressBar;
     public final ObservableField<String> username=new ObservableField<>("");
     public final ObservableField<String> userpass=new ObservableField<>("");


    public LoginUserViewModel(Context context) {
        this.context = context;
        progressBar = new ObservableInt(View.GONE);

    }


 /*   public void sendLoginRequest(String name, String pass) {
        // showToast("Inside Login View Model");
        progressBar.set(View.VISIBLE);
        ApiInterface apiInterface = RetrofitBase.getInstance().create(ApiInterface.class);
        HashMap<String, String> params = new HashMap();
        params.put("o_email", name);
        params.put("o_password", pass);

        Log.d("TAG", "values  " + name + "  " + pass);

        Call<String> call = apiInterface.owner_login(params);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressBar.set(View.GONE);
                showToast(response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressBar.set(View.GONE);
                showToast(t.getMessage());
            }
        });
    }
*/

    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
