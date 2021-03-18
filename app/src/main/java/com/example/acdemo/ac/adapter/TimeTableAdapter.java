package com.example.acdemo.ac.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.model.Courses;
import com.example.acdemo.ac.model.TimeTable;
import com.example.acdemo.ac.view.ScrCertificationCourseDetails;
import com.squareup.picasso.Picasso;

import java.sql.Time;
import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ViewHolderBid> {


    private ArrayList<TimeTable> list;
    private Context context;
    private TimeTable timeTable;

    public TimeTableAdapter(Context context) {
        this.context = context;

    }

    public void setList(ArrayList<TimeTable> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderBid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_time_table, parent,false);
        return new ViewHolderBid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderBid holder, final int i) {
        timeTable = list.get(i);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(ArrayList<TimeTable> filteredList)
    {
        list=filteredList;
        notifyDataSetChanged();
    }

    class ViewHolderBid extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_course_title,tv_course_price;
        private ImageView iv_course_image;
        private Button bt_view_courses;

        private ViewHolderBid(@NonNull View itemView) {
            super(itemView);


        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
            }
        }
    }


}
