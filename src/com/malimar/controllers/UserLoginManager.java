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
    public void showSearch(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select teid, userlogin, temail, t_nbr, t_name_l1, t_name_l2, teacher from tbl_Teacher "
                    + "where userlogin like N'"+ x +"%' or t_nbr like N'"+ x +"%' or T_Name_L1 like N'"+ x +"%' or t_name_l2 like N'"+ x +"%'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("Teid"), rs.getBoolean("userLogin"), rs.getString("temail"), rs.getString("t_nbr"), rs.getString("t_name_l1"), rs.getString("t_name_l2"), rs.getBoolean("teacher")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showDataGroupUser(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Exec ST_GroupUser";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("GRUID"), rs.getString("Groupname_l1"), rs.getString("groupname_l2"), rs.getBoolean("USed")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
    public boolean insertGroupUser(UserLogin ul){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_groupUser (Gruid, GroupName_l1, GroupName_l2, Used) values (?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_groupUser", "GRUID"));
            p.setString(2, ul.getGroupName_L1());
            p.setString(3, ul.getGroupName_L2());
            p.setBoolean(4, ul.getUsed());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
