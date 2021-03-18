package com.example.acdemo.ac.model;

import java.util.ArrayList;

public class DesignCoursesList {

    private ArrayList<DesignCourses> list = new ArrayList<>();
    public static DesignCoursesList _instance = null;

    private DesignCourses designCourses;

    private DesignCoursesList(){

    }

    public static DesignCoursesList getInstance(){

        if (_instance == null){

            _instance = new DesignCoursesList();
        }return _instance;
    }

    public void add(DesignCourses designCourses){
       list.add(designCourses);
    }

    public ArrayList<DesignCourses> getList(){
        return list;
    }

    public void setSelectedList(DesignCourses designCourses){
        this.designCourses = designCourses;
    }

    public DesignCourses getSelectedList(){
        return designCourses;
    }

    public void clearList(){

        if (list.size() != 0){
            list.clear();
        }
    }
}
