package com.example.acdemo.ac.mvvmpattern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.acdemo.R;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolderBid> {

    private ArrayList<MovieModel> list;
    private Context context;
    private MovieModel movieModel;

    public MoviesAdapter(Context context,ArrayList<MovieModel> list) {
        this.context = context;
        this.list=list;

    }

    public void setList(ArrayList<MovieModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderBid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movies, parent,false);
        return new ViewHolderBid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderBid holder, final int i) {
        movieModel = list.get(i);
        holder.tv_movie_name.setText(movieModel.getName());

        Glide.with(context).load(movieModel.getImageurl()).error(R.color.input_background).into(holder.iv_movie_image);

    }

    @Override
    public int getItemCount() {

        if (list !=null) {
            return list.size();
        }
        return 0;
    }


    class ViewHolderBid extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView iv_movie_image;
        private TextView tv_movie_name;

        private ViewHolderBid(@NonNull View itemView) {
            super(itemView);
            iv_movie_image=itemView.findViewById(R.id.iv_movie_image);
            tv_movie_name=itemView.findViewById(R.id.tv_movie_name);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {

            }
        }
    }


}
