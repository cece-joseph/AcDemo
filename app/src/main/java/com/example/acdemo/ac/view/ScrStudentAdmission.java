package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acdemo.R;
import com.example.acdemo.ac.adapter.SubjectAdapter;
import com.example.acdemo.ac.model.Subject;

import java.util.ArrayList;
import java.util.Calendar;

public class ScrStudentAdmission extends AppCompatActivity implements View.OnClickListener {

    private EditText et_date_of_birth;
    private LinearLayout ll_admission_details,ll_passport_and_visa_details,ll_religion_and_address_details,ll_parent_details,ll_education_details,ll_subject_details,ll_document_details;
    private ImageButton ib_addmission_details,ib_passposrt_and_visa_details,ib_religion_and_address_details,ib_parent_details,ib_education_details,ib_subject_details,ib_document_details;
    private Button tv_next_addmission_details,tv_next_religion_address_details,tv_next_passport_visa_details,tv_next_subject_details;
    private TextView tv_add_subject;


    private RecyclerView rv_subject;
    private SubjectAdapter subjectAdapter;
    private ArrayList<Subject> list;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_student_applicaion_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Admission Form");
        initUi();
    }

    public void initUi() {

        rv_subject=findViewById(R.id.rv_subject);
        subjectAdapter=new SubjectAdapter(this);
        layoutManager=new GridLayoutManager(this,1);
        rv_subject.setLayoutManager(layoutManager);

        list=new ArrayList<>();
        list.add(new Subject("English",2,"Theory","Compulsory",100));
        list.add(new Subject("Maths",4,"Practical","Elective",100));
        list.add(new Subject("Science",2,"Both","Compulsory",50));

        subjectAdapter.setList(list);
        rv_subject.setAdapter(subjectAdapter);

        et_date_of_birth = findViewById(R.id.et_date_of_birth);
        et_date_of_birth.setOnClickListener(this);

        ll_admission_details=findViewById(R.id.ll_admission_details);
        ll_passport_and_visa_details=findViewById(R.id.ll_passport_and_visa_details);
        ll_religion_and_address_details=findViewById(R.id.ll_religion_and_address_details);
        ll_parent_details=findViewById(R.id.ll_parent_details);
        ll_education_details=findViewById(R.id.ll_education_details);
        ll_document_details=findViewById(R.id.ll_document_details);
        ll_subject_details=findViewById(R.id.ll_subject_details);

        ib_addmission_details=findViewById(R.id.ib_addmission_details);
        ib_passposrt_and_visa_details=findViewById(R.id.ib_passposrt_and_visa_details);
        ib_religion_and_address_details=findViewById(R.id.ib_religion_and_address_details);
        ib_parent_details=findViewById(R.id.ib_parent_details);
        ib_education_details=findViewById(R.id.ib_education_details);
        ib_document_details=findViewById(R.id.ib_document_details);
        ib_subject_details=findViewById(R.id.ib_subject_details);

        ib_addmission_details.setOnClickListener(this);
        ib_passposrt_and_visa_details.setOnClickListener(this);
        ib_religion_and_address_details.setOnClickListener(this);
        ib_parent_details.setOnClickListener(this);
        ib_education_details.setOnClickListener(this);
        ib_document_details.setOnClickListener(this);
        ib_subject_details.setOnClickListener(this);

        tv_next_addmission_details=findViewById(R.id.tv_next_addmission_details);
        tv_next_religion_address_details=findViewById(R.id.tv_next_religion_address_details);
        tv_next_passport_visa_details=findViewById(R.id.tv_next_passport_visa_details);
        tv_next_subject_details=findViewById(R.id.tv_next_subject_details);


        tv_add_subject=findViewById(R.id.tv_add_subject);
        tv_add_subject.setOnClickListener(this);

        tv_next_addmission_details.setOnClickListener(this);
        tv_next_religion_address_details.setOnClickListener(this);
        tv_next_passport_visa_details.setOnClickListener(this);
        tv_next_subject_details.setOnClickListener(this);


    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }


    public void showDatePicker(final EditText editText) {
        Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                String selectedDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                editText.setText(selectedDate);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_date_of_birth:
                showDatePicker(et_date_of_birth);
                break;

            case R.id.ib_addmission_details:
                if (ll_admission_details.getVisibility() == View.VISIBLE) {
                    ll_admission_details.setVisibility(View.GONE);
                    ib_addmission_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more));
                } else {
                    ll_admission_details.setVisibility(View.VISIBLE);
                    ib_addmission_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less));

                }

                break;


            case R.id.ib_passposrt_and_visa_details:
                if (ll_passport_and_visa_details.getVisibility() == View.VISIBLE) {
                    ll_passport_and_visa_details.setVisibility(View.GONE);
                    ib_passposrt_and_visa_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more));
                } else {
                    ll_passport_and_visa_details.setVisibility(View.VISIBLE);
                    ib_passposrt_and_visa_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less));

                }

                break;

            case R.id.ib_religion_and_address_details:
                if (ll_religion_and_address_details.getVisibility() == View.VISIBLE) {
                    ll_religion_and_address_details.setVisibility(View.GONE);
                    ib_religion_and_address_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more));
                } else {
                    ll_religion_and_address_details.setVisibility(View.VISIBLE);
                    ib_religion_and_address_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less));

                }

                break;


            case R.id.ib_parent_details:
                if (ll_parent_details.getVisibility() == View.VISIBLE) {
                    ll_parent_details.setVisibility(View.GONE);
                    ib_parent_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more));
                } else {
                    ll_parent_details.setVisibility(View.VISIBLE);
                    ib_parent_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less));

                }

                break;

            case R.id.ib_education_details:
                if (ll_education_details.getVisibility() == View.VISIBLE) {
                    ll_education_details.setVisibility(View.GONE);
                    ib_education_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more));
                } else {
                    ll_education_details.setVisibility(View.VISIBLE);
                    ib_education_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less));

                }

                break;

            case R.id.ib_subject_details:
                if (ll_subject_details.getVisibility() == View.VISIBLE) {
                    ll_subject_details.setVisibility(View.GONE);
                    ib_subject_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more));
                } else {
                    ll_subject_details.setVisibility(View.VISIBLE);
                    ib_subject_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less));

                }

                break;

            case R.id.ib_document_details:
                if (ll_document_details.getVisibility() == View.VISIBLE) {
                    ll_document_details.setVisibility(View.GONE);
                    ib_document_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more));
                } else {
                    ll_document_details.setVisibility(View.VISIBLE);
                    ib_document_details.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less));

                }

                break;

            case R.id.tv_next_addmission_details:
                ll_admission_details.setVisibility(View.GONE);
                ll_passport_and_visa_details.setVisibility(View.VISIBLE);
                break;

            case R.id.tv_next_passport_visa_details:
                ll_passport_and_visa_details.setVisibility(View.GONE);
                ll_religion_and_address_details.setVisibility(View.VISIBLE);
                break;

        }
    }
}