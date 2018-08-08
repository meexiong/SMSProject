/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.controllers.DatabaseManagerSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;



/**
 *
 * @author Malimar
 */
public class ModuleMaxID {
    
    public static String field;
    public static String tbl;
    public static int sumcounts;    
    public static String countmax(String count, String tbls){
        try {
            Connection c = DatabaseManagerSQL.getConnection();
            count = field;
            tbls = tbl;
            String sql = "Select isnull(max("+ count +") AS counts from "+ tbls +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                sumcounts = rs.getInt("counts");
            }
            
            
        } catch (Exception e) {
        }
        return null;
    }
      
}
