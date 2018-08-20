/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

import java.util.Date;

/**
 *
 * @author Malimar
 */
public class Course {
    int courseID;
    String courseName_L1;
    String courseName_L2;
    double coursePrice;
    public Course(){
        
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setCourseName_L1(String courseName_L1) {
        this.courseName_L1 = courseName_L1;
    }

    public void setCourseName_L2(String courseName_L2) {
        this.courseName_L2 = courseName_L2;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName_L1() {
        return courseName_L1;
    }

    public String getCourseName_L2() {
        return courseName_L2;
    }

    public double getCoursePrice() {
        return coursePrice;
    }
    
}
