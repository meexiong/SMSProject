/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

import java.util.logging.Logger;

/**
 *
 * @author Malimar
 */
public class Region {
    int REID;
    String RE_Name_L1;
    String Re_Name_L2;

    public int getREID() {
        return REID;
    }

    public String getRE_Name_L1() {
        return RE_Name_L1;
    }

    public String getRe_Name_L2() {
        return Re_Name_L2;
    }

    public void setREID(int REID) {
        this.REID = REID;
    }

    public void setRE_Name_L1(String RE_Name_L1) {
        this.RE_Name_L1 = RE_Name_L1;
    }

    public void setRe_Name_L2(String Re_Name_L2) {
        this.Re_Name_L2 = Re_Name_L2;
    }
    
    
}
