/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.StudentType;
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
public class StudentTypeManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public boolean insertSttype(StudentType stm){
        try {
            GetMaxID mg = new GetMaxID();
            String sql = "Insert into tbl_studentType (STYCID, stname_l1, stname_l2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, mg.getIntID("Tbl_studentType", "stycid"));
            p.setString(2, stm.getStname_l1());
            p.setString(3, stm.getStname_l2());           
            if (p.executeUpdate()!=-1){           
                p.close();
                MsgBox.msgInfo();
                return true;
            }           

        } catch (Exception e) {
            MsgBox.msgWarning();
        }
        return false;
    }
    public boolean updateSttype(StudentType stm){
        try {
            String sql ="Update tbl_StudentType set STName_L1 = ?, STName_L2 = ? where stycid= (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, stm.getStname_l1().trim());
            p.setString(2, stm.getStname_l2().trim());
            p.setInt(3, stm.getStycid());            
            if (p.executeUpdate()!=-1){
                p.close();
                MsgBox.msgInfo();
                return true;
            }
        } catch (Exception e) {
            MsgBox.msgWarning();
        }
        return false;
    }
    public void showData(JTable jtable, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(jtable, model);
            String sql = "Select * from tbl_studenttype order by stycid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[] {rs.getString("stycid"), rs.getString("stname_l1"), rs.getString("Stname_l2")});                
            }
            jtable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
