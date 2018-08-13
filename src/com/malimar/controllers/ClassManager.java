/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.ClassL;
import com.malimar.utils.MsgBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

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
    public HashMap<String,Object[]>getClassLevel(){
        HashMap<String,Object[]> map = new HashMap<>();
        Connection c = DatabaseManagerSQL.getConnection();
        Statement st;
        ResultSet rs;
        String sql;
        try {
            sql="Select CLID,CLName_L1,CLName_L2 from tbl_ClassLevel";
            st=c.createStatement();
            rs=st.executeQuery(sql);
//            map.clear();
            while(rs.next()){
                map.put(rs.getString("CLName_"+LangType+""), new Object[]{rs.getInt("CLID"), rs.getString("CLName_L1"), rs.getString("CLName_L2")});
            }
            rs.close();
            st.close();
            c.close();
        } catch (SQLException e) {
        }
        return map;
    }
}
