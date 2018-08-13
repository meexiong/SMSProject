/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Ethnic;
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
public class EthnicManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public boolean insertethnic(Ethnic et){
        try {
            GetMaxID gi = new GetMaxID();
            sql = "Insert into tbl_Ethnic (Etid, et_name_L1, et_name_L2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gi.getIntID("tbl_Ethnic", "EtID"));
            p.setString(2, et.getEthnic_L1());
            p.setString(3, et.getEthnic_L2());
            p.executeUpdate();
            p.close();            
            MsgBox.msgInfo();   
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateethnic(Ethnic et){
        try {
            sql = "Update tbl_Ethnic set Et_Name_L1 = ?, Et_Name_L2 = ? where ETID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, et.getEthnic_L1().trim());
            p.setString(2, et.getEthnic_L2().trim());
            p.setInt(3, et.getID());
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
            sql = "Select * from tbl_Ethnic order by etid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow((new Object[]{rs.getString("etid"), rs.getString("et_name_L1"), rs.getString("et_name_l2")}));
            }
            jtable.setModel(model);
        } catch (Exception e) {
        }
    }
    
}
