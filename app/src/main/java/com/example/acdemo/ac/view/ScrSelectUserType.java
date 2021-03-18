package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acdemo.R;

public class ScrSelectUserType extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_admin,ll_teacher,ll_student;
    private TextView tv_admin,tv_teacher,tv_student,tv_error_header;
    private Button bt_continue;

    private boolean isAdminClicked=false;
    private boolean isTeacherClicked=false;
    private boolean isStudentClicked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_select_user_type);
        initUi();
    }

    public void initUi()
    {

        ll_admin=findViewById(R.id.ll_admin);
        ll_teacher=findViewById(R.id.ll_teacher);
        ll_student=findViewById(R.id.ll_student);

        ll_admin.setOnClickListener(this);
        ll_teacher.setOnClickListener(this);
        ll_student.setOnClickListener(this);

        tv_admin=findViewById(R.id.tv_admin);
        tv_teacher=findViewById(R.id.tv_teacher);
        tv_student=findViewById(R.id.tv_student);
        tv_error_header=findViewById(R.id.tv_error_header);

        bt_continue=findViewById(R.id.bt_continue);
        bt_continue.setOnClickListener(this);

        setSelectedUserType();
    }

    public void setSelectedUserType() {
       // iv_admission.setImageResource(R.drawable.ic_tick_blue);
        tv_student.setTextColor(getResources().getColor(R.color.white));
        ll_student.setBackgroundColor(getResources().getColor(R.color.black));


        //iv_certification.setImageResource(R.drawable.ic_tick_light);
        tv_admin.setTextColor(getResources().getColor(R.color.black));
        tv_teacher.setTextColor(getResources().getColor(R.color.black ));
        tv_error_header.setText("Continue as Student");
        isStudentClicked = true;
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt_continue:
                if (isStudentClicked==true)
                {
                    Intent intent=new Intent(ScrSelectUserType.this, ScrChooseCourseType.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(ScrSelectUserType.this, ScrAdmin_TeacherLogin.class);
                    startActivity(intent);
                }
                break;

            case R.id.ll_admin:

                isAdminClicked=true;
                isTeacherClicked=false;
                isStudentClicked=false;

                ll_admin.setBackgroundColor(getResources().getColor(R.color.black));
                tv_admin.setTextColor(getResources().getColor(R.color.white));

                tv_teacher.setTextColor(getResources().getColor(R.color.black ));
                tv_student.setTextColor(getResources().getColor(R.color.black ));

                ll_teacher.setBackgroundColor(getResources().getColor(R.color.white));
                ll_student.setBackgroundColor(getResources().getColor(R.color.white));


                break;

            case R.id.ll_teacher:

                isAdminClicked=false;
                isTeacherClicked=true;
                isStudentClicked=false;

                ll_teacher.setBackgroundColor(getResources().getColor(R.color.black));
                tv_teacher.setTextColor(getResources().getColor(R.color.white));

                tv_admin.setTextColor(getResources().getColor(R.color.black ));
                tv_student.setTextColor(getResources().getColor(R.color.black ));

                ll_admin.setBackgroundColor(getResources().getColor(R.color.white));
                ll_student.setBackgroundColor(getResources().getColor(R.color.white));

                break;

            case R.id.ll_student:

                isAdminClicked=false;
                isTeacherClicked=false;
                isStudentClicked=true;

                ll_student.setBackgroundColor(getResources().getColor(R.color.black));
                tv_student.setTextColor(getResources().getColor(R.color.white));

                tv_teacher.setTextColor(getResources().getColor(R.color.black ));
                tv_admin.setTextColor(getResources().getColor(R.color.black ));

                ll_teacher.setBackgroundColor(getResources().getColor(R.color.white));
                ll_admin.setBackgroundColor(getResources().getColor(R.color.white));

                break;
        }}
}