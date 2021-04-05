package com.example.acdemo.ac.mvvmpattern;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("marvel")
    Call<ArrayList<MovieModel>> getMovieList();

    @GET("login_owner.php")
    Call<LoginModelTesting> owner_login(@QueryMap Map<String ,String > params);

}


