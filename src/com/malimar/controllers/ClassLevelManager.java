/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.ClassLevel;
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
public class ClassLevelManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public boolean insertClassLevel(ClassLevel cl){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_classLevel(clid, clname_l1, clname_l2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_ClassLevel", "CLID"));
            p.setString(2, cl.getClassName_L1());
            p.setString(3, cl.getClassName_L2());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateClassLevel(ClassLevel cl){
        try {
            sql = "Update tbl_ClassLevel set clname_L1=?, clname_L2=? where clid = (?)";
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1, cl.getClassName_L1().trim());
            p.setString(2, cl.getClassName_L2().trim());
            p.setInt(3, cl.getId());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showData(JTable jtable, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(jtable, model);
            sql = "Select * from tbl_classLevel order by clid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[] {rs.getString("clid"), rs.getString("clname_L1"), rs.getString("clname_l2")});
            }
            jtable.setModel(model);
        } catch (Exception e) {
        }
    }
    
}
