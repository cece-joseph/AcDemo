package com.example.acdemo.ac.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.adapter.CategoriesAdapter;
import com.example.acdemo.ac.adapter.CoursesAdapter;
import com.example.acdemo.ac.adapter.DesignCoursesAdpater;
import com.example.acdemo.ac.adapter.ITCoursesAdapter;
import com.example.acdemo.ac.communication.Constants;
import com.example.acdemo.ac.model.Category;
import com.example.acdemo.ac.model.Courses;
import com.example.acdemo.ac.model.DesignCourses;
import com.example.acdemo.ac.model.ITCourses;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class FrgFeatured extends Fragment  {
    private View view;
    private CoursesAdapter coursesAdapter;
    private ArrayList<Courses> list;
    private RecyclerView rv_featured_courses;
    private EditText et_search;

    private DesignCourses designCourses;
    private ArrayList<DesignCourses> designCoursesArrayList;
    private RecyclerView rv_design_courses;
    private DesignCoursesAdpater designCoursesAdpater;

    private ITCourses itCourses;
    private ArrayList<ITCourses> itCoursesArrayList;
    private RecyclerView rv_it_courses;
    private ITCoursesAdapter itCoursesAdapter;

    private RecyclerView rv_categories;
    private ArrayList<Category> categoryArrayList;
    private Category category;
    private CategoriesAdapter categoriesAdapter;

    private Chip chip_categories;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_featured, null);
        initFeaturedCourseUi();
        initDesignCoursesUi();
        initItCourseUi();
        initCategories();

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filterFeaturedcourse(editable.toString());
                filterDesignCourse(editable.toString());
                filterItCourse(editable.toString());
            }
        });


        return view;
    }

    public void initFeaturedCourseUi() {
        rv_featured_courses = view.findViewById(R.id.rv_featured_courses);
        et_search = view.findViewById(R.id.et_search);
        coursesAdapter = new CoursesAdapter(getActivity());
        rv_featured_courses.setAdapter(coursesAdapter);
        rv_featured_courses.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        list = new ArrayList<>();
        list.add(new Courses("Machine Learning", "https://hackernoon.com/hn-images/1*Jj8HA6hcXWfiRbMk1Swarg.jpeg", "$ 500", Constants.BUY_COURSE));
        list.add(new Courses("Android Development", "https://codecondo.com/wp-content/uploads/2015/03/20-Ways-To-Learn-Android-Programming-For-Free.png", "Free", Constants.FREE_COURSE));
        list.add(new Courses("Android Development", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6OT5hRYnrDk8rRVaWiHlhsHoxZDX9j-Imog&usqp=CAU", "$ 200", Constants.BUY_COURSE));

        coursesAdapter.setList(list);
        coursesAdapter.notifyDataSetChanged();
    }

    public void initDesignCoursesUi() {
        rv_design_courses = view.findViewById(R.id.rv_design_courses);

        designCoursesAdpater = new DesignCoursesAdpater(getActivity());
        rv_design_courses.setAdapter(designCoursesAdpater);
        rv_design_courses.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        designCoursesArrayList = new ArrayList<>();
        designCoursesArrayList.add(new DesignCourses("Machine Learning", "https://hackernoon.com/hn-images/1*Jj8HA6hcXWfiRbMk1Swarg.jpeg", "$ 500", Constants.BUY_COURSE));
        designCoursesArrayList.add(new DesignCourses("Android Development", "https://codecondo.com/wp-content/uploads/2015/03/20-Ways-To-Learn-Android-Programming-For-Free.png", "Free", Constants.FREE_COURSE));
        designCoursesArrayList.add(new DesignCourses("Android Development", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6OT5hRYnrDk8rRVaWiHlhsHoxZDX9j-Imog&usqp=CAU", "$ 200", Constants.BUY_COURSE));


        designCoursesAdpater.setList(designCoursesArrayList);
        designCoursesAdpater.notifyDataSetChanged();
    }


    public void initItCourseUi() {
        rv_it_courses = view.findViewById(R.id.rv_it_courses);

        itCoursesAdapter = new ITCoursesAdapter(getActivity());
        rv_it_courses.setAdapter(itCoursesAdapter);
        rv_it_courses.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        itCoursesArrayList = new ArrayList<>();
        itCoursesArrayList.add(new ITCourses("Machine Learning", "https://hackernoon.com/hn-images/1*Jj8HA6hcXWfiRbMk1Swarg.jpeg", "$ 500", Constants.BUY_COURSE));
        itCoursesArrayList.add(new ITCourses("Android Development", "https://codecondo.com/wp-content/uploads/2015/03/20-Ways-To-Learn-Android-Programming-For-Free.png", "Free", Constants.FREE_COURSE));
        itCoursesArrayList.add(new ITCourses("Android Development", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6OT5hRYnrDk8rRVaWiHlhsHoxZDX9j-Imog&usqp=CAU", "$ 200", Constants.BUY_COURSE));

        itCoursesAdapter.setList(itCoursesArrayList);
        itCoursesAdapter.notifyDataSetChanged();
    }


    public void initCategories() {
        rv_categories = view.findViewById(R.id.rv_categories);
        categoriesAdapter = new CategoriesAdapter(getActivity());
        rv_categories.setAdapter(categoriesAdapter);
        rv_categories.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        categoryArrayList = new ArrayList<>();
        categoryArrayList.add(new Category("Finance & Accounting"));
        categoryArrayList.add(new Category("Development"));
        categoryArrayList.add(new Category("Marketing"));
        categoryArrayList.add(new Category("Design"));
        categoryArrayList.add(new Category("It & Software"));

        categoriesAdapter.setList(categoryArrayList);
        categoriesAdapter.notifyDataSetChanged();
    }

    public void filterFeaturedcourse(String text) {
        ArrayList<Courses> filteredlist = new ArrayList<>();
        for (Courses courses : list) {
            if (courses.getCourse_name().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(courses);
            }
        }
        coursesAdapter.filterList(filteredlist);
    }

    public void filterDesignCourse(String text) {
        ArrayList<DesignCourses> filteredlist = new ArrayList<>();
        for (DesignCourses designCourses : designCoursesArrayList) {
            if (designCourses.getCourse_name().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(designCourses);
            }
        }
        designCoursesAdpater.filterList(filteredlist);
    }


    public void filterItCourse(String text) {
        ArrayList<ITCourses> filteredlist = new ArrayList<>();
        for (ITCourses itCourses : itCoursesArrayList) {
            if (itCourses.getCourse_name().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(itCourses);
            }
        }
        itCoursesAdapter.filterList(filteredlist);
    }


}
