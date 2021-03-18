package com.example.acdemo.ac.model;

public class PaymentHistory {

    String branch_name;
    String fee_amount;
    String paid_on;
    String status;

    public PaymentHistory(String branch_name, String fee_amount, String paid_on, String status) {
        this.branch_name = branch_name;
        this.fee_amount = fee_amount;
        this.paid_on = paid_on;
        this.status = status;
    }


    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(String fee_amount) {
        this.fee_amount = fee_amount;
    }

    public String getPaid_on() {
        return paid_on;
    }

    public void setPaid_on(String paid_on) {
        this.paid_on = paid_on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
