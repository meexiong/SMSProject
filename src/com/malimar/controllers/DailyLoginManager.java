/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

/**
 *
 * @author Malimar
 */
import com.malimar.models.DailyLogin;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Date;

public class DailyLoginManager {
    String sql;
    Connection c = DatabaseManagerSQL.getConnection();
    public void showMainBoard(DailyLogin dl){
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"wmic", "bios", "get", "serialnumber"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String serial = sc.next();
            String property = sc.next();
            
            dl.setMainBord(property +": "+ serial);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showIPCom(DailyLogin dl){
        try {
            InetAddress IP = InetAddress.getLocalHost();
            dl.setComIP(IP.toString());            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public boolean insertTbl_DailyLogin(DailyLogin dl){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt = new Date();    
            String xx = df.format(dt);
            
            sql = "Insert into tbl_DailyLogin (UserLogin, MainBoard, ComIP, DateLogin) values (?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, dl.getUserLogin());
            p.setString(2, dl.getMainBord());
            p.setString(3, dl.getComIP());
            p.setString(4, xx);
            p.executeUpdate();
            p.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    
}
