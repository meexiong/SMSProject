
package com.malimar.controllers;

import com.malimar.models.Schedule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class SchaduleManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public HashMap<String, Object[]>mapSemester(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "Select semesterid, semesterName from tbl_Semester";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                smap.put(rs.getString("semestername"), new Object[]{rs.getInt("semesterid"), rs.getString("SemesterName"), rs.getString("Semestername")});
            }
            rs.close();
            return smap;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void showSemesterInfo(Schedule sd){
        try {
            String sql = "Select startdate, enddate from tbl_Semester \n" +
                    "where semestername = N'"+ sd.getSemesterName() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                sd.setStartDate(rs.getDate("startDate"));
                sd.setEndDate(rs.getDate("enddate"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
