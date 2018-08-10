/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Malimar
 */
public class LabelManager {
    public static int LN;
    public static String LangType;
    public static HashMap<String , String[]> hmapLang = new HashMap();
    public static String getLabelLang(){
        try {
            String sql;
            Connection c = DatabaseManagerSQL.getConnection();
            sql="EXEC pd_ChangeLabel";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
              hmapLang.put(rs.getString(1), new String[]{rs.getString(2),rs.getString(3)});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }  
    public static String WindowChangeLabel(String s,String frm,java.awt.event.MouseEvent evt){
        try {  
          if (evt.getModifiers()== 6){
//                    FrmChangeLabel ch = new FrmChangeLabel(null, true);
//                    DatabaseManager.Lable_change = s;
//                    DatabaseManager.Lable_Frm = frm;
//                    ch.setVisible(true);   
          }           
        } catch (Exception e) {
        }
        return null;
    }
}
