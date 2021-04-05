package com.example.acdemo.ac.mvvmpattern;

import com.example.acdemo.ac.communication.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitBase {

    public static Retrofit retrofit = null;


    public static Retrofit getInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    //.client()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
