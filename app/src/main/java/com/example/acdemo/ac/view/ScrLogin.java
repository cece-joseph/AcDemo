package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acdemo.R;
import com.example.acdemo.ac.communication.Constants;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class ScrLogin extends AppCompatActivity implements View.OnClickListener, PaymentResultListener {
    private EditText et_username,et_pass;
    private TextView tv_forgot_password,tv_sign_up,tv_sign_in;
    String username,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_login);
        Intent intent=getIntent();

        type=intent.getStringExtra("type");
        initUi();



    }

    public void initUi()
    {
        et_username=findViewById(R.id.et_username);
        et_pass=findViewById(R.id.et_pass);
        tv_forgot_password=findViewById(R.id.tv_forgot_password);

        tv_sign_up=findViewById(R.id.tv_sign_up);
        tv_sign_up.setOnClickListener(this);

        tv_sign_in=findViewById(R.id.tv_sign_in);
        tv_sign_in.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_sign_up:
                Intent intent=new Intent(ScrLogin.this, ScrSignUp.class);
                startActivity(intent);
                break;

            case R.id.tv_sign_in:
              /*  Intent i=new Intent(ScrLogin.this, ScrHome.class);
                startActivity(i);*/
                //startPaymentMethod();

                if (type.equals(Constants.FREE_COURSE))
                {
                    Intent i=new Intent(ScrLogin.this, ScrStartCourse.class);
                    startActivity(i);
                    finish();
                }else if (type.equals(Constants.BUY_COURSE)){
                    startPaymentMethod();

                }else {
                    Intent i=new Intent(ScrLogin.this, ScrHome.class);
                    startActivity(i);
                    finish();

                }
                break;
        }
    }


    public void startPaymentMethod() {
        int amount = 500;
        Checkout checkout = new Checkout();
        checkout.setImage(R.drawable.ac_logo);

        final Activity activity = this;

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Cecelia Joseph");

            jsonObject.put("description", "");
            jsonObject.put("currency", "INR");
            jsonObject.put("amount", amount * 100);

            JSONObject prefill = new JSONObject();
            prefill.put("email", "ceceliajoseph26@gmail.com");
            prefill.put("contact", "8551010395");
            prefill.put("prefill", prefill);
            checkout.open(activity, jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void showPaymentSuccessDialog() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_payment_success);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button bt_pay_success = dialog.findViewById(R.id.bt_pay_success);
        bt_pay_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ScrLogin.this, ScrHomeCertificationCourseDetails.class);
                startActivity(i);
                finish();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    private void showPaymentFailedDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_payment_failed);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button bt_pay_failed = dialog.findViewById(R.id.bt_pay_failed);
        TextView bt_exit = dialog.findViewById(R.id.bt_exit);
        bt_pay_failed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPaymentMethod();
            }
        });

        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onPaymentSuccess(String s) {
       showPaymentSuccessDialog();
    }

    @Override
    public void onPaymentError(int i, String s) {

        showPaymentFailedDialog();
    }
}