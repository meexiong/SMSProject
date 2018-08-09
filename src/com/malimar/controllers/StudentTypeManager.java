/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.StudentType;
import com.malimar.utils.MsgBox;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
            String sql ="Update tbl_StudentType set = STName_L1 = ?, STName_L2 = ? where stycid= (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, stm.getStname_l1());
            p.setString(2, stm.getStname_l2());
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
    
}
