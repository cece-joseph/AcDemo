package com.example.acdemo.ac.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.adapter.CategoriesAdapter;
import com.example.acdemo.ac.adapter.CategoriesDeatilsAdapter;
import com.example.acdemo.ac.model.Category;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class FrgMycourses extends Fragment implements View.OnClickListener {
    private View view;
    private Button bt_explore_courses;
   /* private RecyclerView rv_categories;
    private ArrayList<Category> categoryArrayList;
    private Category category;
    private CategoriesDeatilsAdapter categoriesAdapter;*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_my_courses, container,false);
        initCategories();
        return view;
    }

    public void initCategories() {
      /*  rv_categories = view.findViewById(R.id.rv_categories);
        categoriesAdapter = new CategoriesDeatilsAdapter(getActivity());
        rv_categories.setAdapter(categoriesAdapter);
        rv_categories.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        categoryArrayList = new ArrayList<>();
        categoryArrayList.add(new Category("Finance & Accounting"));
        categoryArrayList.add(new Category("Development"));
        categoryArrayList.add(new Category("Marketing"));
        categoryArrayList.add(new Category("Design"));
        categoryArrayList.add(new Category("Business"));
        categoryArrayList.add(new Category("Photography"));
        categoryArrayList.add(new Category("It & Software"));

        categoriesAdapter.setList(categoryArrayList);
        categoriesAdapter.notifyDataSetChanged();*/

        bt_explore_courses=view.findViewById(R.id.bt_explore_courses);
        bt_explore_courses.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = new FrgFeatured();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rv_container, fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
