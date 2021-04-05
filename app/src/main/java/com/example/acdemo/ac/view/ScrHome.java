package com.example.acdemo.ac.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acdemo.R;
import com.example.acdemo.ac.adapter.PaymentHistoryAdapter;
import com.example.acdemo.ac.adapter.TimeTableAdapter;
import com.example.acdemo.ac.model.PaymentHistory;
import com.example.acdemo.ac.model.TimeTable;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ScrHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private PaymentHistoryAdapter paymentHistoryAdapter;
    private ArrayList<PaymentHistory> list;
    private RecyclerView rv_payment_history;

    private RecyclerView rv_time_table;
    private ArrayList<TimeTable> timeTableArrayList;
    private TimeTableAdapter timeTableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //   navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_notes_24, this.getTheme());
        toggle.setHomeAsUpIndicator(drawable);

        //toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));


        View view = navigationView.inflateHeaderView(R.layout.nav_header1);
        TextView name = view.findViewById(R.id.name);
        ImageView imageView = view.findViewById(R.id.imageView);

        initPaymentHistory();
        initTimeTable();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initPaymentHistory() {
        rv_payment_history = findViewById(R.id.rv_payment_history);

        paymentHistoryAdapter = new PaymentHistoryAdapter(this);
        rv_payment_history.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_payment_history.setAdapter(paymentHistoryAdapter);

        list = new ArrayList<>();
        list.add(new PaymentHistory("FY BCA", "₹ 25000", "22-Mar-2020", "Confirm"));
        list.add(new PaymentHistory("TY BCA", "₹ 24000", "22-Mar-2020", "Pending"));
        list.add(new PaymentHistory("TY BCA", "₹ 24500", "22-Mar-2020", "Pending"));


        paymentHistoryAdapter.setList(list);
        paymentHistoryAdapter.notifyDataSetChanged();


    }

    public void initTimeTable() {
        rv_time_table = findViewById(R.id.rv_time_table);
        timeTableAdapter = new TimeTableAdapter(this);
        rv_time_table.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_time_table.setAdapter(timeTableAdapter);

        timeTableArrayList = new ArrayList<>();
        timeTableArrayList.add(new TimeTable("Monday","Android","Ankit Tiwari","8:00 am","8:30 am"));
        timeTableArrayList.add(new TimeTable("Tuesday","Data Structures","Asif Khan","8:30 am","9:00 am"));
        timeTableArrayList.add(new TimeTable("Wednesday","C++ Programming","Geeta Deshmukh","9:00 am","9:30 am"));
        timeTableArrayList.add(new TimeTable("Thursday","OT","Rehman Shaikh","9:30 am","10:00 am"));
        timeTableArrayList.add(new TimeTable("Monday","OT","Rehman Shaikh","9:30 am","10:00 am"));
        timeTableArrayList.add(new TimeTable("Tuesday","OT","Rehman Shaikh","9:30 am","10:00 am"));
        timeTableArrayList.add(new TimeTable("Wednesday","OT","Rehman Shaikh","9:30 am","10:00 am"));
        timeTableArrayList.add(new TimeTable("Thursday","OT","Rehman Shaikh","9:30 am","10:00 am"));
        timeTableArrayList.add(new TimeTable("Monday","OT","Rehman Shaikh","9:30 am","10:00 am"));
        timeTableAdapter.setList(timeTableArrayList);
        timeTableAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_addmission_form:
                Intent intent = new Intent(ScrHome.this, ScrStudentAdmission.class);
                startActivity(intent);
                break;


            case R.id.nav_profile:
                Intent intent1 = new Intent(ScrHome.this, ScrProfile.class);
                startActivity(intent1);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}