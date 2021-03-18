package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acdemo.R;

public class ScrChooseCourseType extends AppCompatActivity implements View.OnClickListener {
    private Boolean isAdmissionClicked = false;
    private Boolean isCertificationClicked = false;

    private LinearLayout ll_admission,ll_certification;
    private TextView tv_admission,tv_certification,tv_error_header;
    private ImageView iv_admission,iv_certification;
    private Button bt_continue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_choose_course_type);

    initUI();
    setSelectedUserType();
    }

    private void initUI() {
        ll_admission = findViewById(R.id.ll_admission);
        ll_admission.setOnClickListener(this);
        ll_certification = findViewById(R.id.ll_certification);
        ll_certification.setOnClickListener(this);

        iv_admission = findViewById(R.id.iv_admission);
        iv_certification = findViewById(R.id.iv_certification);

        tv_error_header = findViewById(R.id.tv_error_header);

        tv_admission = findViewById(R.id.tv_admission);
        tv_certification = findViewById(R.id.tv_certification);

        bt_continue = findViewById(R.id.bt_continue);
        bt_continue.setOnClickListener(this);
    }

    public void setSelectedUserType() {
        iv_admission.setImageResource(R.drawable.ic_tick_blue);
        tv_admission.setTextColor(getResources().getColor(R.color.black));

        iv_certification.setImageResource(R.drawable.ic_tick_light);
        tv_certification.setTextColor(getResources().getColor(R.color.grey));
        tv_error_header.setText("Continue with Admission");
        isAdmissionClicked = true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bt_continue:

                if (isAdmissionClicked){
                   Intent intent=new Intent(ScrChooseCourseType.this, ScrHome.class);
                   startActivity(intent);
                }else{
                    Intent intent=new Intent(ScrChooseCourseType.this, ScrStudentCertificationCourse.class);
                    startActivity(intent);
                }



                break;

            case R.id.ll_admission:

                iv_admission.setImageResource(R.drawable.ic_tick_blue);
                tv_admission.setTextColor(getResources().getColor(R.color.black));

                iv_certification.setImageResource(R.drawable.ic_tick_light);
                tv_certification.setTextColor(getResources().getColor(R.color.grey));

                tv_error_header.setText("Continue with Admission");
                isAdmissionClicked = true;
                isCertificationClicked = false;

                break;

            case R.id.ll_certification:
                iv_certification.setImageResource(R.drawable.ic_tick_blue);
                tv_certification.setTextColor(getResources().getColor(R.color.black));

                iv_admission.setImageResource(R.drawable.ic_tick_light);
                tv_admission.setTextColor(getResources().getColor(R.color.grey));

                tv_error_header.setText("Continue with Certification");
                isCertificationClicked = true;
                isAdmissionClicked = false;

                break;

        }
    }


}