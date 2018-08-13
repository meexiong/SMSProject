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
public class ClassL {
    int clid;
    int clsid;

    String clnameL1;
    String clnameL2;
    
    public void setClsid(int clsid) {
        this.clsid = clsid;
    }

    public int getClsid() {
        return clsid;
    }

    public int getClid() {
        return clid;
    }

    public String getClnameL1() {
        return clnameL1;
    }

    public String getClnameL2() {
        return clnameL2;
    }

    public void setClid(int clid) {
        this.clid = clid;
    }

    public void setClnameL1(String clnameL1) {
        this.clnameL1 = clnameL1;
    }

    public void setClnameL2(String clnameL2) {
        this.clnameL2 = clnameL2;
    }
    
    
}
