package com.example.acdemo.ac.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.model.Category;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class CategoriesDeatilsAdapter extends RecyclerView.Adapter<CategoriesDeatilsAdapter.ViewHolderBid> {


    private ArrayList<Category> list;
    private Context context;
    private Category category;

    public CategoriesDeatilsAdapter(Context context) {
        this.context = context;

    }

    public void setList(ArrayList<Category> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderBid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categories_details, parent,false);
        return new ViewHolderBid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderBid holder, final int i) {
        category = list.get(i);
        holder.tv_category.setText(category.getCategory());


    }

    @Override
    public int getItemCount() {
        if (list.size()!=0)
        {
            return list.size();
        }else return list.size();

    }


    class ViewHolderBid extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_category;
        private Chip chip_categories;

        private ViewHolderBid(@NonNull View itemView) {
            super(itemView);

     tv_category=itemView.findViewById(R.id.tv_category);


        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {

            }
        }
    }


}
