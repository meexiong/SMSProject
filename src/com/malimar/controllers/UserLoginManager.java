/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.UserLogin;
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
public class UserLoginManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    public void showDataUser(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Exec st_userLogin";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("Teid"), rs.getBoolean("userlogin"), rs.getString("temail"), rs.getString("t_nbr"), rs.getString("t_name_l1"), rs.getString("t_name_l2"), rs.getBoolean("teacher")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
    
    public boolean upDateUser(UserLogin ul){
        try {
            sql = "Update tbl_teacher set userlogin = ? where teid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getUserlogin());
            p.setInt(2, ul.getTeid());
            p.executeUpdate();
            p.close();
            //MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
}
