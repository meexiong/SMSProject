/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

/**
 *
 * @author Malimar
 */
public class Student {
    int stdID;
    String stdNbr;
    String stdName_L1;
    String stdName_L2;
//    public Student(int id, String nbr, String l1, String l2){
//        stdID = id;
//        stdNbr = nbr;
//        stdName_L1=l1;
//        stdName_L2=l2;
//    }

    public void setStdID(int stdID) {
        this.stdID = stdID;
    }

    public void setStdNbr(String stdNbr) {
        this.stdNbr = stdNbr;
    }

    public void setStdName_L1(String stdName_L1) {
        this.stdName_L1 = stdName_L1;
    }

    public void setStdName_L2(String stdName_L2) {
        this.stdName_L2 = stdName_L2;
    }

    public int getStdID() {
        return stdID;
    }

    public String getStdNbr() {
        return stdNbr;
    }

    public String getStdName_L1() {
        return stdName_L1;
    }

    public String getStdName_L2() {
        return stdName_L2;
    }
    
}
