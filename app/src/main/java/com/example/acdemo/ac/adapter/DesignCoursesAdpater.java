package com.example.acdemo.ac.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.model.Courses;
import com.example.acdemo.ac.model.CoursesList;
import com.example.acdemo.ac.model.DesignCourses;
import com.example.acdemo.ac.view.ScrCertificationCourseDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DesignCoursesAdpater extends RecyclerView.Adapter<DesignCoursesAdpater.ViewHolderBid> {


    private ArrayList<DesignCourses> list;
    private Context context;
    private DesignCourses designCourses;

    public DesignCoursesAdpater(Context context) {
        this.context = context;

    }

    public void setList(ArrayList<DesignCourses> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderBid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_courses, parent, false);
        return new ViewHolderBid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderBid holder, final int i) {
        designCourses = list.get(i);

        holder.tv_course_title.setText(designCourses.getCourse_name());
        holder.tv_course_price.setText(designCourses.getCourse_price());

        Picasso.with(context).load(designCourses.getCourse_image()).fit().centerCrop().error(R.color.input_background).into(holder.iv_course_image);

        holder.bt_view_courses.setTag(designCourses);
        holder.bt_view_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Courses courses1= (Courses) view.getTag();
                CoursesList.getInstance().setSelectedList(courses1);

                Intent intent = new Intent(context, ScrCertificationCourseDetails.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void filterList(ArrayList<DesignCourses> filteredList) {
        list = filteredList;
        notifyDataSetChanged();
    }

    class ViewHolderBid extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_course_title, tv_course_price;
        private ImageView iv_course_image;
        private LinearLayout bt_view_courses;

        private ViewHolderBid(@NonNull View itemView) {
            super(itemView);
            tv_course_title = itemView.findViewById(R.id.tv_course_title);
            tv_course_price = itemView.findViewById(R.id.tv_course_price);
            iv_course_image = itemView.findViewById(R.id.iv_course_image);
            bt_view_courses = itemView.findViewById(R.id.bt_view_courses);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
            }
        }
    }


}
