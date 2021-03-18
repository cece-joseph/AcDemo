package com.example.acdemo.ac.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acdemo.R;
import com.example.acdemo.ac.model.Courses;
import com.example.acdemo.ac.model.PaymentHistory;
import com.example.acdemo.ac.view.ScrCertificationCourseDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PaymentHistoryAdapter extends RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolderBid> {


    private ArrayList<PaymentHistory> list;
    private Context context;
    private PaymentHistory paymentHistory;

    public PaymentHistoryAdapter(Context context) {
        this.context = context;

    }

    public void setList(ArrayList<PaymentHistory> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderBid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_payment_history, parent,false);
        return new ViewHolderBid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderBid holder, final int i) {
        paymentHistory = list.get(i);

        if (paymentHistory.getStatus().contains("Confirm"))
        {
            holder.tv_status.setText("Confirm");
            holder.ll_status.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));
            holder.tv_status.setTextColor(context.getResources().getColor(R.color.white));
        }else {
            holder.tv_status.setText("Pending");
            holder.ll_status.setBackgroundColor(context.getResources().getColor(R.color.colorRed));
            holder.tv_status.setTextColor(context.getResources().getColor(R.color.white));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolderBid extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_branch_name,tv_status,tv_fee_amount,tv_paid_on;
        private LinearLayout ll_status;

        private ViewHolderBid(@NonNull View itemView) {
            super(itemView);

            tv_branch_name=itemView.findViewById(R.id.tv_branch_name);
            tv_status=itemView.findViewById(R.id.tv_status);
            tv_fee_amount=itemView.findViewById(R.id.tv_fee_amount);
            tv_paid_on=itemView.findViewById(R.id.tv_paid_on);
            ll_status=itemView.findViewById(R.id.ll_status);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
            }
        }
    }


}
