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
import java.sql.*;
import java.util.Scanner;

public class DailyLoginManager {
    
    public void showMainBoard(DailyLogin dl){
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"wmic", "bios", "get", "serialnumber"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String propertys = sc.next();
            String serial = sc.next();
            //lblUser.setText(propertys + serial);
            // lblMainBoardNo.setText(Inet4Address.getLocalHost().getHostAddress() +"  "+ propertys +"  "+ serial);
            dl.setMainBord(serial);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
