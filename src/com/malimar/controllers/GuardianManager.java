/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Guardian;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class GuardianManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public void showDataGuardian(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select gudid, gud_name_"+ LabelManager.LangType+" AS names, gen_"+ LabelManager.LangType +" AS gender, gud_phone1, gud_phone2, gud_email, gud_Work, "
                    + "gud_address from vw_GuardianDetails "
                    + "order by gudid, gud_name_"+ LabelManager.LangType+"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("gudid"), rs.getString("names"), rs.getString("gender"), rs.getString("gud_phone1"), rs.getString("gud_phone2"), rs.getString("gud_email"), rs.getString("gud_work"), 
                rs.getString("gud_address")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public HashMap<String, Object[]>mapGender(){
        try {
            HashMap<String, Object[]>mapG = new HashMap();
            sql= "Select Genid, Gen_L1, Gen_L2 from tbl_Gender order by Genid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while(rs.next()){
                mapG.put(rs.getString("Gen_"+ LabelManager.LangType +""), new Object[]{rs.getString("Gen_L1"), rs.getString("Gen_L2")});
            }
            rs.close();
            return mapG;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean insertGuardian(Guardian gd){
        try {
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
