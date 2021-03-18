package com.example.acdemo.ac.model;

public class ITCourses {
    private String course_name;
    private String course_image;
    private String course_price;
    private String type;


    public ITCourses(String course_name, String course_image, String course_price, String type) {
        this.course_name = course_name;
        this.course_image = course_image;
        this.course_price = course_price;
        this.type = type;
    }


    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_image() {
        return course_image;
    }

    public void setCourse_image(String course_image) {
        this.course_image = course_image;
    }

    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
