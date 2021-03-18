package com.example.acdemo.ac.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.model.Subject;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolderBid> {


    private ArrayList<Subject> list;
    private Context context;
    private Subject subject;

    public SubjectAdapter(Context context) {
        this.context = context;

    }

    public void setList(ArrayList<Subject> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderBid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_subject, parent,false);
        return new ViewHolderBid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderBid holder, final int i) {
        subject = list.get(i);
        holder.tv_subject_name.setText(subject.getName());
        holder.tv_code.setText(String.valueOf(subject.getCode()));
        holder.tv_type.setText(subject.getType());
        holder.tv_subject_type.setText(subject.getSubject_type());
        holder.tv_grade_weight.setText(String.valueOf(subject.getGrade()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolderBid extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_subject_name,tv_code,tv_type,tv_subject_type,tv_grade_weight;

        private ViewHolderBid(@NonNull View itemView) {
            super(itemView);
            tv_subject_name=itemView.findViewById(R.id.tv_subject_name);
            tv_code=itemView.findViewById(R.id.tv_code);
            tv_type=itemView.findViewById(R.id.tv_type);
            tv_subject_type=itemView.findViewById(R.id.tv_subject_type);
            tv_grade_weight=itemView.findViewById(R.id.tv_grade_weight);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {

            }
        }
    }


}
