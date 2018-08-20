
package com.malimar.models;

import java.util.Date;

/**
 *
 * @author Malimar
 */
public class Semester {
    int semesterID;
    String semesterName;
    Date startDate;
    Date endDate;
    public Semester(){
        
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
}
