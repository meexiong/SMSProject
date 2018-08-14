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
public class WorkStatus {
    int id;
    String work_L1;
    String work_L2;

    public int getId() {
        return id;
    }

    public String getWork_L1() {
        return work_L1;
    }

    public String getWork_L2() {
        return work_L2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWork_L1(String work_L1) {
        this.work_L1 = work_L1;
    }

    public void setWork_L2(String work_L2) {
        this.work_L2 = work_L2;
    }
    
    
}
