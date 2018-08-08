/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.STType;
import com.malimar.utils.MsgBox;
import com.malimar.utils.module;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Malimar
 */
public class Sttype {
    
    public void InsertTbl_STType(STType st){
        try {
            Connection c = DatabaseManagerSQL.getConnection();
            
            if (st.getStname_L1().equals("")||st.getStname_L2().equals("")){
                MsgBox.msgError();
                return;
            }
            if (module.sumcounts==0){
                String sql = "Insert into tbl_Sttype (stcid, stname_l1, stname_l2) values (?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, module.sumcounts);
                p.setString(2, st.getStname_L1());
                p.setString(3, st.getStname_L2());
                if (p.executeUpdate()!=-1){
                    module.sumcounts=0;
                    MsgBox.msgInfo();
                }
            }else{
                String sql = "Update tbl_Sttype set stname_l1=?, stname_l2=? where stcid = (?)";
                PreparedStatement p = c.prepareStatement(sql);                
                p.setString(1, st.getStname_L1());
                p.setString(2, st.getStname_L2());
                p.setInt(3, module.sumcounts);
                if (p.executeUpdate()!=-1){
                    module.sumcounts=0;
                    MsgBox.msgInfo();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
