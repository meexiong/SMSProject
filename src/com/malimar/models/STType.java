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
public class STType {
    
   private int stcid;
   private String stname_L1;
   private String stname_L2;

    public void setStcid(int stcid) {
        this.stcid = stcid;
    }

    public void setStname_L1(String stname_L1) {
        this.stname_L1 = stname_L1;
    }

    public void setStname_L2(String stname_L2) {
        this.stname_L2 = stname_L2;
    }

    public int getStcid() {
        return stcid;
    }

    public String getStname_L1() {
        return stname_L1;
    }

    public String getStname_L2() {
        return stname_L2;
    }
   
    
}
