package com.example.acdemo.ac.model;

import java.util.ArrayList;

public class SubjectList {

    private ArrayList<Subject> list = new ArrayList<>();
    public static SubjectList _instance = null;

    private Subject subject;

    private SubjectList(){

    }

    public static SubjectList getInstance(){

        if (_instance == null){

            _instance = new SubjectList();
        }return _instance;
    }

    public void add(Subject subject){
       list.add(subject);
    }

    public ArrayList<Subject> getList(){
        return list;
    }

    public void setSelectedList(Subject subject){
        this.subject = subject;
    }

    public Subject getSelectedList(){
        return subject;
    }

    public void clearList(){

        if (list.size() != 0){
            list.clear();
        }
    }
}
