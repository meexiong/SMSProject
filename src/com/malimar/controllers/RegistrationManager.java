
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RegistrationManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public HashMap<String, Object[]>mapSemester(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "Select semesterid, semesterName from tbl_Semester where SemStatus=0";
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
    public HashMap<String, Object[]>mapStudent(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "exec pd_StudentInfo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                smap.put(rs.getString("StdName_"+LangType+""), new Object[]{rs.getInt("StdID"),rs.getString("StdNbr"), rs.getString("StdName_"+LangType+""), rs.getString("Gen_"+LangType+""), rs.getString("NT_Name_"+LangType+""), rs.getString("ET_Name_"+LangType+""), rs.getString("RE_Name_"+LangType+"")});
            }
            rs.close();
            return smap;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
