/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.SchoolInfo;
import com.malimar.utils.MsgBox;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Malimar
 */
public class SchoolInfoManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public boolean updateSchoolInf(SchoolInfo si){
        try {
            sql = "Update tbl_SchoolInfo set s_name_l1 = ?, s_name_l2 = ?, website = ?, phone1 = ?, phone2 = ?, fax = ?, facebook = ?, s_address = ? where scifo = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, si.getS_name_l1());
            p.setString(2, si.getS_name_l2());
            p.setString(3, si.getWebsite());
            p.setString(4, si.getPhone1());
            p.setString(5, si.getPhone2());
            p.setString(6, si.getFax());
            p.setString(7, si.getFacebook());
            p.setString(8, si.getS_address());
            p.setInt(9, si.getScifo());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;               
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateImage(SchoolInfo si){
        try {
            sql = "Update tbl_SchoolInfo set s_img = ? where scifo = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            
            if (si.getPath() != null) {
                File ff = new File(si.getPath());
                FileInputStream fis = new FileInputStream(ff);
                int len = (int) ff.length();
                p.setBinaryStream(1, fis, len);
            } else {
                p.setNull(1, java.sql.Types.BLOB);
            }
            
            p.setInt(2, si.getScifo());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public void showDataOpen(SchoolInfo si){
        try {
            sql = "Select * from tbl_SchoolInfo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
              si.setScifo(rs.getInt("scifo"));
              si.setS_name_l1(rs.getString("s_name_l1"));
              si.setS_name_l2(rs.getString("s_name_l2"));
              si.setWebsite(rs.getString("website"));
              si.setPhone1(rs.getString("phone1"));
              si.setPhone2(rs.getString("phone2"));
              si.setFax(rs.getString("fax"));
              si.setFacebook(rs.getString("facebook"));
              si.setS_address(rs.getString("s_address"));
              si.setS_img(rs.getBytes("s_img"));              
            }
            rs.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
