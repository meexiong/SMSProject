/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Malimar
 */
public class GetLabel {
    public static int x =0;
    public static HashMap<String, String[]> hmapLang = new HashMap<String, String[]>();   
    public static String getLabels(){
        try {
            String sql;
            Connection c = DatabaseManagerSQL.getConnection();            
            sql = "Select Upper(Sys_Name+FormID) AS sys_ll_fieldname, Lang_L1, Lang_L2, FormID from tbl_SysLang";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){                
                hmapLang.put(rs.getString("sys_ll_fieldname"), new String []{rs.getString("Lang_L1"), rs.getString("Lang_L2")});                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }     
    
}
