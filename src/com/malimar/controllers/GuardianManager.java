/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Guardian;
import com.malimar.utils.MsgBox;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void showSearchGuardian(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select gudid, gud_name_"+ LabelManager.LangType+" AS names, gen_"+ LabelManager.LangType +" AS gender, gud_phone1, gud_phone2, gud_email, gud_Work, "
                    + "gud_address from vw_GuardianDetails where gud_name_"+ LabelManager.LangType+" like N'"+ x +"%' or gen_"+ LabelManager.LangType+" like N'"+ x +"%' or gud_phone1 like N'"+ x +"%' "
                    + "or gud_phone2 like N'"+ x +"%' or gud_email like N'"+ x +"%' or gud_work like N'"+ x +"%' or gud_address like N'"+ x +"%' "
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
                //mapG.put(rs.getString("Gen_"+ LabelManager.LangType +""), new Object[]{rs.getString("Gen_L1"), rs.getString("Gen_L2")});
                mapG.put(rs.getString("Gen_"+ LabelManager.LangType +""), new Object[]{rs.getString("Genid"), rs.getString("Gen_L1"), rs.getString("Gen_L2")});
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
            GetMaxID gds = new GetMaxID();            
            sql = "Insert into tbl_Guardian (GUDID, GUD_name_l1, gud_name_l2, genid, gud_phone1, gud_phone2, gud_email, gud_work, gud_address, gud_info) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gds.getIntID("tbl_Guardian", "GUDID"));
            p.setString(2, gd.getGuardianL1());
            p.setString(3, gd.getGuardianL2());
            p.setInt(4, gd.getGenid());
            p.setString(5, gd.getPhone1());
            p.setString(6, gd.getPhone2());
            p.setString(7, gd.getEmail());
            p.setString(8, gd.getGud_Work());
            p.setString(9, gd.getAddress());
            p.setString(10, gd.getMoreinfo());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateGuardian(Guardian gd){
        try {
            sql = "Update tbl_Guardian set GUD_name_l1=?, gud_name_l2=?, genid=?, gud_phone1=?, gud_phone2=?, gud_email=?, gud_work=?, gud_address=?, gud_info=? where GUDID = (?)";
            PreparedStatement p = c.prepareStatement(sql);            
            p.setString(1, gd.getGuardianL1());
            p.setString(2, gd.getGuardianL2());
            p.setInt(3, gd.getGenid());
            p.setString(4, gd.getPhone1());
            p.setString(5, gd.getPhone2());
            p.setString(6, gd.getEmail());
            p.setString(7, gd.getGud_Work());
            p.setString(8, gd.getAddress());
            p.setString(9, gd.getMoreinfo());
            p.setInt(10, gd.getId());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;         
        } catch (Exception e) {
        }
        return false;
    }
    public void showClickTable(Guardian gd, int ic){
        try {
            sql = "Select g.gudid, g.genid, g.gud_name_l1, g.gud_name_l2, ge.gen_"+ LabelManager.LangType+" As genders, g.gud_phone1, g.gud_phone2, g.gud_email, g.gud_work, g.gud_address, g.gud_info \n" +
                    "from tbl_Guardian g \n" +
                    "left join tbl_Gender ge on ge.Genid = g.Genid\n" +
                    "where g.GUDID = "+ ic +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                gd.setId(rs.getInt("gudid"));
                gd.setGuardianL1(rs.getString("gud_name_l1"));
                gd.setGuardianL2(rs.getString("gud_name_l2"));
                gd.setGenid(rs.getInt("genid"));
                gd.setPhone1(rs.getString("gud_phone1"));
                gd.setPhone2(rs.getString("gud_phone2"));
                gd.setEmail(rs.getString("gud_email"));
                gd.setGud_Work(rs.getString("gud_work"));
                gd.setAddress(rs.getString("gud_address"));
                gd.setMoreinfo(rs.getString("gud_info"));          
                gd.setGenderName(rs.getString("genders"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
