package com.example.acdemo.ac.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.adapter.CategoriesDeatilsAdapter;
import com.example.acdemo.ac.model.Category;

import java.util.ArrayList;

public class FrgWishlist extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView iv_no_data_found;
    private TextView tv_no_data_found,tv_no_data;
    private Button bt_explore_courses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_wishlist, container,false);
        initCategories();
        return view;
    }

    public void initCategories() {
        iv_no_data_found=view.findViewById(R.id.iv_no_data_found);
        tv_no_data_found=view.findViewById(R.id.tv_no_data_found);
        tv_no_data=view.findViewById(R.id.tv_no_data);

        bt_explore_courses=view.findViewById(R.id.bt_explore_courses);
        bt_explore_courses.setOnClickListener(this);


        tv_no_data_found.setText("No Courses added to Whishlist");
        tv_no_data.setText("Want to Save something later ? \n Enroll to a course now ");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bt_explore_courses:
                Fragment fragment = new FrgFeatured();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rv_container, fragment);
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
