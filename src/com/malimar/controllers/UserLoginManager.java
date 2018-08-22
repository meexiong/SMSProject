/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.UserLogin;
import com.malimar.utils.MsgBox;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class UserLoginManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    public void showDataUser(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Exec st_userLogin";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("Teid"), rs.getBoolean("userlogin"), rs.getString("temail"), rs.getString("t_nbr"), rs.getString("t_name_l1"), rs.getString("t_name_l2"), rs.getBoolean("teacher")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }    
    public boolean upDateUser(UserLogin ul){
        try {
            sql = "Update tbl_teacher set userlogin = ? where teid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getUserlogin());
            p.setInt(2, ul.getTeid());
            p.executeUpdate();
            p.close();
            //MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }    
    public void showSearch(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select teid, userlogin, temail, t_nbr, t_name_l1, t_name_l2, teacher from tbl_Teacher "
                    + "where userlogin like N'"+ x +"%' or t_nbr like N'"+ x +"%' or T_Name_L1 like N'"+ x +"%' or t_name_l2 like N'"+ x +"%'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("Teid"), rs.getBoolean("userLogin"), rs.getString("temail"), rs.getString("t_nbr"), rs.getString("t_name_l1"), rs.getString("t_name_l2"), rs.getBoolean("teacher")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showDataGroupUser(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Exec ST_GroupUser";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("GRUID"), rs.getString("Groupname_l1"), rs.getString("groupname_l2"), rs.getBoolean("USed")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
    public boolean insertGroupUser(UserLogin ul){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_groupUser (Gruid, GroupName_l1, GroupName_l2, Used) values (?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_groupUser", "GRUID"));
            p.setString(2, ul.getGroupName_L1());
            p.setString(3, ul.getGroupName_L2());
            p.setBoolean(4, ul.getUsed());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }
    public boolean updateGroupUser(UserLogin ul){
        try {
            sql = "Update tbl_GroupUser set GroupName_L1 = ?, GroupName_L2 = ? where GRUID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, ul.getGroupName_L1().trim());
            p.setString(2, ul.getGroupName_L2().trim());
            p.setInt(3, ul.getGRUID());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateUsedGroupUser(UserLogin ul){
        try {
            sql = "Update tbl_groupUser set Used = ? where GrUID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getUsed());
            p.setInt(2, ul.getGRUID());
            p.executeUpdate();
            p.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showDataGroupUserPermission(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select slangid, checked, form_name_"+ LabelManager.LangType +" AS formname, Lang_"+ LabelManager.LangType+" AS LangName from vw_SysFormLang order by SLangid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("slangid"), rs.getBoolean("checked"), rs.getString("formname"), rs.getString("langname")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, Object[]>mapGroup(){
        try {
            HashMap<String, Object[]>mapG= new HashMap();
            sql = "Select gruid, groupName_"+LabelManager.LangType+" AS names from tbl_GroupUser where Used = 1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapG.put(rs.getString("names"), new Object[]{rs.getString("gruid"), rs.getString("names")});
            }
            return mapG;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void showCheckGroupUserLang(UserLogin ul){
        try {
            sql = "Select GRUID, SLangid from tbl_GroupUserLang where GRUID = "+ul.getGRUID()+" and Slangid = "+ul.getSLANGID()+"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                
            }else{
                insertGroupUserLang(ul);
            }
            
        } catch (Exception e) {
        }
    }
    public boolean insertGroupUserLang(UserLogin ul){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_GroupUserLang (GULID, GRUID, SLANGID, reads, write, denys, createDate) values(?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_GroupUserLang", "GULID"));
            p.setInt(2, ul.getGRUID());
            p.setInt(3, ul.getSLANGID());
            p.setBoolean(4, ul.getReads());
            p.setBoolean(5, ul.getWrite());
            p.setBoolean(6, ul.getDenys());
            p.setDate(7, (Date) ul.getCreateDate());
            p.executeUpdate();
            p.close();            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showClickcbbUserLogin(String cb, JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            //sql = "Select slangid, checked, form_name_"+ LabelManager.LangType +" AS formname, Lang_"+ LabelManager.LangType+" AS LangName from vw_SysFormLang order by SLangid";
            sql = "Select vw.Slangid, (Select iif(GRUID>0, 'true', 'false') as gruid from tbl_GroupUserLang where SLANGID = vw.SLANGID and GRUID = g.GRUID)AS checked, form_name_"+ LabelManager.LangType +" AS formname, Lang_"+ LabelManager.LangType+" AS LangName \n" +
                    "from vw_SysFormLang vw \n" +
                    "left join tbl_GroupUserLang gl on gl.SLANGID = vw.SLANGID "
                    + "left join tbl_GroupUser g on g.GRUID = gl.GRUID "
                    + "where g.GroupName_"+LabelManager.LangType+" = N'"+ cb +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("slangid"), rs.getBoolean("checked"), rs.getString("formname"), rs.getString("langname")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
