/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Semester;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class SemesterManager {

    Connection c = DatabaseManagerSQL.getConnection();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public boolean insert(Semester sm) {
        try {
            GetMaxID gm = new GetMaxID();
            String insert = "Insert into tbl_Semester(SemesterID, SemesterName, StartDate, EndDate)values(?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID("tbl_Semester", "SemesterID"));
            p.setString(2, sm.getSemesterName());
            p.setString(3, df.format(sm.getStartDate()));
            p.setString(4, df.format(sm.getEndDate()));
            return p.executeUpdate() == 1;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean update(Semester sm){
        try {
            String update = "Update tbl_Semester set SemesterName=?, StartDate=?, EndDate=? where SemesterID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setString(1, sm.getSemesterName());
            p.setString(2, df.format(sm.getStartDate()));
            p.setString(3, df.format(sm.getEndDate()));
            p.setInt(4, sm.getSemesterID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public void load(DefaultTableModel model){
        try {
            String query = "Select SemesterID, SemesterName, format(StartDate,'dd-MM-yyyy') as strDate, format(EndDate,'dd-MM-yyyy') as enDate from tbl_Semester";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("SemesterID");
                String semesterName = rs.getString("SemesterName");
                String startDate = rs.getString("strDate");
                String endDate = rs.getString("enDate");
                Object[] obj = new Object[]{id, semesterName, startDate, endDate};
                model.addRow(obj);
            }
        } catch (SQLException e) {
        }
    }
}
