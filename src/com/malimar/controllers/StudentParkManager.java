/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.StudentPark;
import com.malimar.utils.MsgBox;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */

public class StudentParkManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public boolean insertStudentPark(StudentPark sp){
        try {
            GetMaxID gmd = new GetMaxID();
            sql = "insert into tbl_parkStudy (PSID, PSName_L1, PSname_l2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gmd.getIntID("tbl_ParkStudy", "PSID"));
            p.setString(2, sp.getPsName_L1());
            p.setString(3, sp.getPsName_L2());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;            
        } catch (Exception e) {
        }
        return false;
    }
    public boolean updateStudentPark(StudentPark sp){
        try {
            sql = "Update tbl_ParkStudy set PSName_L1 = ?, PSName_L2 = ? where PSID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, sp.getPsName_L1().trim());
            p.setString(2, sp.getPsName_L2().trim());
            p.setInt(3, sp.getPsid());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
        }
        return false;
    }
    public void showData(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select * from tbl_parkStudy order by PSID";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("psid"), rs.getString("PSName_l1"), rs.getString("PSName_L2")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
}
