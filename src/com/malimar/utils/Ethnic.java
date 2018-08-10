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
public class Ethnic {
    int ID;
    String Ethnic_L1;
    String Ethnic_L2;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEthnic_L1(String Ethnic_L1) {
        this.Ethnic_L1 = Ethnic_L1;
    }

    public void setEthnic_L2(String Ethnic_L2) {
        this.Ethnic_L2 = Ethnic_L2;
    }

    public int getID() {
        return ID;
    }

    public String getEthnic_L1() {
        return Ethnic_L1;
    }

    public String getEthnic_L2() {
        return Ethnic_L2;
    }
    
}
