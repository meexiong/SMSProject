/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.ClassL;
import com.malimar.utils.MsgBox;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Malimar
 */
public class ClassManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public boolean insertClass(ClassL cl){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_class (clsid, clrname_l1, clrname_L2, clid) values (?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_Class", "clsid"));
            p.setString(2, cl.getClnameL1());
            p.setString(3, cl.getClnameL2());
            p.setInt(4, cl.getClid());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
