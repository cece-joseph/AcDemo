package com.example.acdemo.ac.model;

import java.util.ArrayList;

public class PaymentHistoryList {

    private ArrayList<PaymentHistory> list = new ArrayList<>();
    public static PaymentHistoryList _instance = null;

    private PaymentHistory paymentHistory;

    private PaymentHistoryList(){

    }

    public static PaymentHistoryList getInstance(){

        if (_instance == null){

            _instance = new PaymentHistoryList();
        }return _instance;
    }

    public void add(PaymentHistory paymentHistory){
       list.add(paymentHistory);
    }

    public ArrayList<PaymentHistory> getList(){
        return list;
    }

    public void setSelectedList(PaymentHistory paymentHistory){
        this.paymentHistory = paymentHistory;
    }

    public PaymentHistory getSelectedList(){
        return paymentHistory;
    }

    public void clearList(){

        if (list.size() != 0){
            list.clear();
        }
    }
}
