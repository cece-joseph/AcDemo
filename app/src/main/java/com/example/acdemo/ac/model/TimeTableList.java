package com.example.acdemo.ac.model;

import java.util.ArrayList;

public class TimeTableList {

    private ArrayList<TimeTable> list = new ArrayList<>();
    public static TimeTableList _instance = null;

    private TimeTable timeTable;

    private TimeTableList(){

    }

    public static TimeTableList getInstance(){

        if (_instance == null){

            _instance = new TimeTableList();
        }return _instance;
    }

    public void add(TimeTable timeTable){
       list.add(timeTable);
    }

    public ArrayList<TimeTable> getList(){
        return list;
    }

    public void setSelectedList(TimeTable timeTable){
        this.timeTable = timeTable;
    }

    public TimeTable getSelectedList(){
        return timeTable;
    }

    public void clearList(){

        if (list.size() != 0){
            list.clear();
        }
    }
}
