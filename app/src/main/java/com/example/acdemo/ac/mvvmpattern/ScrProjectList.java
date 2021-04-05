package com.example.acdemo.ac.mvvmpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.acdemo.R;

import java.util.ArrayList;

public class ScrProjectList extends AppCompatActivity {

    private RecyclerView rv_movies;
    private MoviesAdapter moviesAdapter;
    private MovieListViewModel movieListViewModel;
    private ArrayList<MovieModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_project_list);

        initUi();

        movieListViewModel.getMovieListObserver().observe(this, new Observer<ArrayList<MovieModel>>() {
            @Override
            public void onChanged(ArrayList<MovieModel> movieModels) {
                if (movieModels !=null)
                {
                    list=movieModels;
                    moviesAdapter.setList(list);
                }
                else {
                    Toast.makeText(ScrProjectList.this,"No Data Found",Toast.LENGTH_LONG).show();
                }
            }
        });
        movieListViewModel.makeApiCall();


    }


    public void initUi()
    {
        rv_movies=findViewById(R.id.rv_movies);
        LinearLayoutManager layoutManager=new GridLayoutManager(this,2);
        rv_movies.setLayoutManager(layoutManager);
        moviesAdapter=new MoviesAdapter(this,list);
        rv_movies.setAdapter(moviesAdapter);

        movieListViewModel= ViewModelProviders.of(this).get(MovieListViewModel.class);

    }


}