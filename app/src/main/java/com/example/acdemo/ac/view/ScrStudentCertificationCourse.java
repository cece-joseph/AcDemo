package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.acdemo.R;
import com.example.acdemo.ac.fragment.FrgFeatured;
import com.example.acdemo.ac.fragment.FrgMycourses;
import com.example.acdemo.ac.fragment.FrgProfile;
import com.example.acdemo.ac.fragment.FrgWishlist;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class ScrStudentCertificationCourse extends AppCompatActivity {

    private ChipNavigationBar chip_nav_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_student_certification_form);

        /*getSupportActionBar().setTitle("Certification Courses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        getSupportFragmentManager().beginTransaction().replace(R.id.rv_container,new FrgFeatured()).commit();

        initUi();

    }


    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }

    public void initUi()
    {
        chip_nav_bar=findViewById(R.id.chip_nav_bar);
        chip_nav_bar.setItemSelected(R.id.chip_nav_featured,true);

        chip_nav_menu();
    }

    public void chip_nav_menu()
    {
        chip_nav_bar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;
                switch (i)
                {

                    case R.id.chip_nav_featured:
                        fragment=new FrgFeatured();
                        break;

                   /* case R.id.chip_nav_search:
                        fragment=new FrgSearch();
                        break;*/

                    case R.id.chip_nav_my_courses:
                        fragment=new FrgMycourses();
                        break;


                    case R.id.chip_nav_wishlist:
                        fragment=new FrgWishlist();
                        break;


                    case R.id.chip_nav_account:
                       fragment=new FrgProfile();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.rv_container,fragment).commit();
            }
        });
    }




}