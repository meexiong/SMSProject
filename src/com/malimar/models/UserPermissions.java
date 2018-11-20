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
public class UserPermissions {
    String jTab;
    int w;
    int denys;

    public void setDenys(int denys) {
        this.denys = denys;
    }

    public int getDenys() {
        return denys;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getW() {
        return w;
    }

    public void setjTab(String jTab) {
        this.jTab = jTab;
    }

    public String getjTab() {
        return jTab;
    }
    
}
