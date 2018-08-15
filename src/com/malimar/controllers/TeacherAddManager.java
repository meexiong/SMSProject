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
    public HashMap<String, Object[]>getMapWorkStatus(){
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "Select workid, work_name_l1, work_name_l2 from tbl_WorkStatus";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("Work_Name_"+ LangType +""), new Object[]{rs.getString("workid"), rs.getString("work_name_l1"), rs.getString("work_name_L2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]>getMapClassRoom(){
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "select clsid, clrname_l1, clrname_l2 from tbl_class order by clrname_l1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("clrname_"+ LangType +""), new Object[]{rs.getString("clsid"), rs.getString("clrname_L1"), rs.getString("clrname_l2")});
            }
            rs.close();
            return map;
            
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]>getMapNationality(){
        try {
            HashMap<String, Object[]>map = new HashMap();
            sql = "select ntid, nt_name_l1, nt_name_l2 from tbl_Nationality\n" +
                    "order by ntid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("nt_name_"+ LangType +""), new Object[]{rs.getString("ntid"), rs.getString("nt_name_l1"), rs.getString("nt_name_l2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]> getParkSchool(){
        try {
            HashMap<String, Object[]>map = new HashMap();
            sql = "select psid, psname_l1, psname_l2 from tbl_ParkStudy\n" +
                    "order by psid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("psname_"+ LangType +""), new Object[]{rs.getString("psid"), rs.getString("psname_L1"), rs.getString("Psname_L2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]>getMapEthnic(){
        try {
            HashMap<String, Object[]>map = new HashMap();
            sql = "select etid, et_name_l1, et_name_l2 from tbl_Ethnic\n" +
                "order by ETID";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while(rs.next()){
                map.put(rs.getString("e_name_"+ LangType +""), new Object[]{rs.getString("etid"), rs.getString("et_name_l1"), rs.getString("et_name_l2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }
    
}
