/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Malimar
 */
public class TeacherAddManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
        
    public HashMap<String, Object[]>getMapGender(){
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql= "select genid, gen_l1, gen_l2 from tbl_Gender";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("Gen_"+ LangType +""), new Object[]{rs.getString("genid"), rs.getString("gen_l1"), rs.getString("gen_l2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
