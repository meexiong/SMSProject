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
public class Schedule {
    int semesterID;
    String semesterName;
    Date Createdate;
    String CreatebyUser;
    Date startDate;
    Date endDate;
    boolean schStatus;

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public void setCreatedate(Date Createdate) {
        this.Createdate = Createdate;
    }

    public void setCreatebyUser(String CreatebyUser) {
        this.CreatebyUser = CreatebyUser;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setSchStatus(boolean schStatus) {
        this.schStatus = schStatus;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public Date getCreatedate() {
        return Createdate;
    }

    public String getCreatebyUser() {
        return CreatebyUser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isSchStatus() {
        return schStatus;
    }
    
}
