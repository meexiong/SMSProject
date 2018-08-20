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
public class Schadule {
    int SEMTID;
    Date Createdate;
    String CreatebyUser;
    Date Stdate;
    Date EndDate;
    int OpenSC;

    public void setOpenSC(int OpenSC) {
        this.OpenSC = OpenSC;
    }

    public int getOpenSC() {
        return OpenSC;
    }

    public void setStdate(Date Stdate) {
        this.Stdate = Stdate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public Date getStdate() {
        return Stdate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setSEMTID(int SEMTID) {
        this.SEMTID = SEMTID;
    }

    public void setCreatedate(Date Createdate) {
        this.Createdate = Createdate;
    }

    public void setCreatebyUser(String CreatebyUser) {
        this.CreatebyUser = CreatebyUser;
    }

    
    public int getSEMTID() {
        return SEMTID;
    }

    public Date getCreatedate() {
        return Createdate;
    }

    public String getCreatebyUser() {
        return CreatebyUser;
    }    
}
