
package com.malimar.controllers;

import static com.malimar.controllers.AESecrp.decrypt;
import static com.malimar.controllers.AESecrp.encrypt;
import com.malimar.models.AccessDatasource;
import com.malimar.utils.MsgBox;
import java.net.Inet4Address;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DatabaseManagerAccess {
    String sql;
    public void readDatasource(AccessDatasource ad){
        try {
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Conn/SMS.accdb");
            sql="SELECT * FROM Tb_Datasoure where DID=1001";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                ad.setServerName(decrypt(rs.getString("Servername")));
                ad.setDatabaseName(decrypt(rs.getString("DBname")));
                ad.setUserLogin(decrypt(rs.getString("users")));
                ad.setPassword(decrypt(rs.getString("passwords")));
                ad.setPort(decrypt(rs.getString("ports")));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertDatasource(AccessDatasource ad){
        try {
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Conn/SMS.accdb");
            sql="Update Tb_Datasoure set Servername=?,DBname=?,users=?,passwords=?,ports=? where DID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, encrypt(ad.getServerName()));
            ps.setString(2, encrypt(ad.getDatabaseName()));
            ps.setString(3, encrypt(ad.getUserLogin()));
            ps.setString(4, encrypt(ad.getPassword()));
            ps.setString(5, encrypt(ad.getPort()));
            ps.setInt(6, 1001);
            ps.executeUpdate() ; 
           MsgBox.msgInfo();
        } catch (Exception e) {
            MsgBox.msgWarning();
        }
    }
    public boolean testDatasource(AccessDatasource ad){
        try {
            String Ser="jdbc:sqlserver://"+ad.getServerName()+"; DatabaseName="+ad.getDatabaseName();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String a =ad.getUserLogin();
            String b =ad.getPassword();
            Connection c = DriverManager.getConnection(Ser, ad.getUserLogin(), ad.getPassword());
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public void saveSeasion(String txtuser){
        try {
            String IP;
            Process process = Runtime.getRuntime().exec(new String[] { "wmic", "bios", "get", "serialnumber" });
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String propertys = sc.next();
            String serial = sc.next();
            //lblUser.setText(propertys + serial);
            IP=Inet4Address.getLocalHost().getHostAddress()+" "+propertys +" "+serial;
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
           // Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Conn/SMS.accdb");
            String query="Update Tb_Session set LoginName=?,Computer=?,Datetime=? where LoginID=1";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, txtuser);
            ps.setString(2, IP);
            ps.setString(3, currentTime);
            if (ps.executeUpdate()!=-1){                                              
            }        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getUserLogin(){
        try {
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Conn/SMS.accdb");
             String sql="SELECT LoginName FROM Tb_Session where LoginID=1";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                return rs.getString("LoginName");
            }
        } catch (Exception e) {
        }
        return null;
    }
}
