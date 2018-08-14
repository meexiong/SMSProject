/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.WorkStatus;
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
public class WorkStatusManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    public boolean insertWorkStatus(WorkStatus ws){
        try {
            GetMaxID gm = new GetMaxID();
            sql= "Insert into tbl_workstatus (Workid, work_name_L1, work_name_L2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_workStatus", "workid"));
            p.setString(2, ws.getWork_L1());
            p.setString(3, ws.getWork_L2());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateWorkStatus(WorkStatus ws){
        try {
            sql = "Update tbl_workstatus Set work_name_L1 = ?, work_name_L2 = ? where workid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, ws.getWork_L1().trim());
            p.setString(2, ws.getWork_L2().trim());
            p.setInt(3, ws.getId());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showData(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select * from tbl_WorkStatus\n" +
                    "order by WorkID";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("workid"), rs.getString("work_name_L1"), rs.getString("work_name_L2")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
