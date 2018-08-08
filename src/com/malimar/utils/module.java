/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import com.malimar.controllers.DatabaseManagerSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;



/**
 *
 * @author Malimar
 */
public class module {
    
    public static String field;
    public static String tbl;
    public static int sumcounts;
    public static int x =0;
    
    public static HashMap<String, String[]> hmapLang = new HashMap<String, String[]>();   
    
    public static String countmax(String count, String tbls){
        try {
            Connection c = DatabaseManagerSQL.getConnection();
            count = field;
            tbls = tbl;
            String sql = "Select isnull(count("+ count +") AS counts from "+ tbls +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                sumcounts = rs.getInt("counts");
            }
            
            
        } catch (Exception e) {
        }
        return null;
    }
    public static String getLabels(){
        try {
            String sql;
            Connection c = DatabaseManagerSQL.getConnection();            
            //sql = "Select Upper(Sys_LL_FieldName) AS sys_ll_fieldname, Sys_"+ LangType +" AS langs from Tbl_Sys_Lang_Label where frm = N'"+ frm +"'";
            sql = "Select Upper(Sys_Name+frm) AS sys_ll_fieldname, Lang_L1, Lang_L2, frm from tbl_sysLang";
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
