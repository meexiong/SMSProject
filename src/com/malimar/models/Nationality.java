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
public class Nationality {
    int nationalID;
    String nationalName_L1;
    String nationalName_L2;
    public Nationality(){
        
    }

    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }

    public void setNationalName_L1(String nationalName_L1) {
        this.nationalName_L1 = nationalName_L1;
    }

    public void setNationalName_L2(String nationalName_L2) {
        this.nationalName_L2 = nationalName_L2;
    }

    public int getNationalID() {
        return nationalID;
    }

    public String getNationalName_L1() {
        return nationalName_L1;
    }

    public String getNationalName_L2() {
        return nationalName_L2;
    }
    
}
