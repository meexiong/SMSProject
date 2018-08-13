/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.utils.MsgBox;
import com.malimar.views.FrmChangeLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author Malimar
 */
public class LabelManager {
    public static int LN;
    public static String LangType;
    public static String frameName;
    public static String fieldName;
    public static HashMap<String , String[]> hmapLang = new HashMap();
    public static HashMap<String , String[]> hmapForm = new HashMap();
    public static String getLabelLang(){
        try {
            String sql;
            Connection c = DatabaseManagerSQL.getConnection();
            sql="EXEC pd_ChangeLabel";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
              hmapLang.put(rs.getString(1), new String[]{rs.getString(2),rs.getString(3)});
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void WindowChangeLabel(String s, String frm, java.awt.event.MouseEvent evt) {
        try {
            if (evt.getModifiers() == 6) {
                FrmChangeLabel ch = new FrmChangeLabel();
                fieldName = s;
                frameName = frm;
                ch.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return null;
    }
    
    public void saveLabel(String l1, String l2, String field, String frame, JFrame f) {
        try {
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "update tbl_SysLang set Lang_L1 = ?, Lang_L2 = ? where Sys_Name = (?) and FormID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, l1);
            p.setString(2, l2);
            p.setString(3, field);
            p.setString(4, frame);
            p.executeUpdate();
            p.close();
            c.close();
            f.dispose();
        } catch (SQLException e) {
            MsgBox.msgWarning();
        }
    }
    
    public static String getLabelForm(){
        try {
            String sql;
            Connection c = DatabaseManagerSQL.getConnection();
            sql="Exec pd_LabelForm";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
              hmapForm.put(rs.getString(1), new String[]{rs.getString(2), rs.getString(3)});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
