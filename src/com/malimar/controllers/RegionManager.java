/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Region;
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
public class RegionManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    public boolean insertRegion(Region rg){
        try {
            GetMaxID g = new GetMaxID();
            sql = "Insert into tbl_Region (REID, re_name_l1, re_name_l2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, g.getIntID("tbl_Region", "REID"));
            p.setString(2, rg.getRE_Name_L1());
            p.setString(3, rg.getRe_Name_L2());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
        }
        return false;
    }
    public boolean updateRegion(Region rg){
        try {
            sql = "Update tbl_Region set Re_name_l1 = ?, Re_name_L2 =? where REID= (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, rg.getRE_Name_L1());
            p.setString(2, rg.getRe_Name_L2());
            p.setInt(3, rg.getREID());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            
            
        } catch (Exception e) {
        }
        return false;
    }
    public void showData(JTable jtable, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(jtable, model);
            sql = "Select * from tbl_region order by REID desc";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("reid"), rs.getString("Re_name_l1"), rs.getString("Re_name_L2")});
            }
            jtable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
