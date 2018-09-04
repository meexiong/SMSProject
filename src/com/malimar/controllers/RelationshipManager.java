/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Relationship;
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
public class RelationshipManager {    
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;   
    
    public void showData(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select * from tbl_Relationship order by RLTID";
            ResultSet rs= c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("RLTID"), rs.getString("Relation_L1"), rs.getString("Relation_L2")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean insertRelationship(Relationship rsp){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_Relationship (RLTID, Relation_L1, Relation_L2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_Relationship", "RLTID"));
            p.setString(2, rsp.getRelationship_L1());
            p.setString(3, rsp.getRelationship_L2());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateRelationship(Relationship rsp){
        try {
            sql = "Update tbl_relationship set Relation_L1 = ?, Relation_L2 = ? where RLTID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, rsp.getRelationship_L1());
            p.setString(2, rsp.getRelationship_L2());
            p.setInt(3, rsp.getId());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
