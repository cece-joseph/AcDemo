package com.example.acdemo.ac.model;

import java.util.ArrayList;

public class CoursesList {

    private ArrayList<Courses> list = new ArrayList<>();
    public static CoursesList _instance = null;

    private Courses courses;

    private CoursesList(){

    }

    public static CoursesList getInstance(){

        if (_instance == null){

            _instance = new CoursesList();
        }return _instance;
    }

    public void add(Courses courses){
       list.add(courses);
    }

    public ArrayList<Courses> getList(){
        return list;
    }

    public void setSelectedList(Courses courses){
        this.courses = courses;
    }

    public Courses getSelectedList(){
        return courses;
    }

    public void clearList(){

        if (list.size() != 0){
            list.clear();
        }
    }
}
