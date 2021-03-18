package com.example.acdemo.ac.model;

public class Subject {
    String name;
    int code;
    String type;
    String subject_type;
    int grade;


    public Subject(String name, int code, String type, String subject_type, int grade) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.subject_type = subject_type;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(String subject_type) {
        this.subject_type = subject_type;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
