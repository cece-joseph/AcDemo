package com.example.acdemo.ac.mvvmpattern;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<ArrayList<MovieModel>> movieList;

    public MovieListViewModel()
    {

        movieList=new MutableLiveData<>();

    }

    public MutableLiveData<ArrayList<MovieModel>> getMovieListObserver()
    {
        return movieList;
    }

    public void makeApiCall()
    {
        ApiInterface apiInterface= RetrofitBase.getInstance().create(ApiInterface.class);
        Call<ArrayList<MovieModel>> call=apiInterface.getMovieList();
        call.enqueue(new Callback<ArrayList<MovieModel>>() {
            @Override
            public void onResponse(Call<ArrayList<MovieModel>> call, Response<ArrayList<MovieModel>> response) {

                movieList.postValue(response.body());
                Log.d("TAG", "response " + response.body());

            }
            @Override
            public void onFailure(Call<ArrayList<MovieModel>> call, Throwable t) {
                movieList.postValue(null);

            }
        });
    }

}
