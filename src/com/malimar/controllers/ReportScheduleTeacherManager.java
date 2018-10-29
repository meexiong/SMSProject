/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

/**
 *
 * @author Malimar
 */
import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.ReportScheduleTeacher;
import com.malimar.utils.RemoveTableIndex;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class ReportScheduleTeacherManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    
    public boolean showScheduleTeacher(JTable table, DefaultTableModel model, String date){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select stdate, enddate, courseName_"+ LangType +" As coursename, semesterName, sum(price) as sumprice \n" +
                    "from vw_ScheduleTeacher\n" +
                    "where SubString(stDate, 7, 10) = '"+ date +"'\n" +
                    "group by stdate, enddate, courseName_"+ LangType +", SemesterName\n" +
                    "order by stdate, endDate";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("stDate"), rs.getString("enddate"), rs.getString("coursename"), rs.getString("semesterName"), rs.getDouble("sumprice")});
            }
            rs.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public HashMap<String, Object[]> getmapCourse(String dt){
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "Select courseName_"+LangType+" AS coursename from vw_ScheduleTeacher\n" +
                    "where SubString(stDate, 7, 10) = '"+ dt +"'\n" +
                    "group by stdate, enddate, CourseName_"+ LangType +", SemesterName\n" +
                    "order by stdate, endDate";
            
//            sql = "Select courseName_"+LangType+" AS coursename from vw_ScheduleTeacher\n" +                    
//                    "group by stdate, enddate, CourseName_"+ LangType +", SemesterName\n" +
//                    "order by stdate, endDate";
            
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("coursename"), new Object[]{rs.getString("coursename"), rs.getString("coursename"), rs.getString("coursename")});
            }
            rs.close();
            return map;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
