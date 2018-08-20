/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Schadule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Malimar
 */

public class SchaduleManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    
    
    public HashMap<String, Object[]>mapSemester(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            sql = "Select semesterid, semesterName from tbl_Semester";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                smap.put(rs.getString("semestername"), new Object[]{rs.getString("semesterid"), rs.getString("SemesterName"), rs.getString("Semestername")});
                
            }
            rs.close();
            return smap;            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void showStDateEndDate(Schadule sd, String SchaduleName){
        try {
            sql = "Select startdate, enddate from tbl_Semester \n" +
                    "where semestername = N'"+ SchaduleName +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                sd.setStdate(rs.getDate("startDate"));
                sd.setEndDate(rs.getDate("enddate"));
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean insertSchadule(){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "";
            
        } catch (Exception e) {
        }
        return false;
    }
    
}
