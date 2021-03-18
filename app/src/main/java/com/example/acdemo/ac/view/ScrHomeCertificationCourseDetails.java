package com.example.acdemo.ac.view;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acdemo.R;
import com.example.acdemo.ac.communication.Constants;
import com.example.acdemo.ac.model.Courses;
import com.example.acdemo.ac.model.CoursesList;

public class ScrHomeCertificationCourseDetails extends AppCompatActivity implements View.OnClickListener {
    private Button bt_buy_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_certification_course_details);
      }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }



    private void showGenerateCertificateDialog() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_course_completd);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button bt_generate_certificate = dialog.findViewById(R.id.bt_generate_certificate);
        bt_generate_certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
    }
}