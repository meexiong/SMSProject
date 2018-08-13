/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.ClassL;
import com.malimar.utils.MsgBox;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class ClassManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
HashMap<String, Object[]> mapLevel = null;
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
    public boolean updateClass(ClassL cl){
        try {
            sql = "Update tbl_class set clrname_l1=?, clrname_L2=?, clid=? where clsid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, cl.getClnameL1());
            p.setString(2, cl.getClnameL2());
            p.setInt(3, cl.getClid());
            p.setInt(4, cl.getClsid());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showData(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select ca.clsid, ca.clid, cl.clname_"+ LangType +" AS names, ca.clrname_l1, ca.clrname_l2\n" +
                    "from tbl_Class ca \n" +
                    "left join tbl_ClassLevel cl on ca.CLID = cl.CLID\n" +
                    "order by cl.CLID desc";
            ResultSet rs  = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("clsid"), rs.getString("clid"), rs.getString("names"), rs.getString("clrname_l1"), rs.getString("clrname_L2")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
