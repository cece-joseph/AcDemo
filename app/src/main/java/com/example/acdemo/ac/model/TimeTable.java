package com.example.acdemo.ac.model;

public class TimeTable {

    private String day;
    private String subject_name;
    private String teacher_name;
    private String start_time;
    private String end_time;


    public TimeTable(String day, String subject_name, String teacher_name, String start_time, String end_time) {
        this.day = day;
        this.subject_name = subject_name;
        this.teacher_name = teacher_name;
        this.start_time = start_time;
        this.end_time = end_time;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
