
package com.malimar.controllers;

import static com.malimar.controllers.AESecrp.decrypt;
import static com.malimar.controllers.AESecrp.encrypt;
import com.malimar.models.AccessDatasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccessDBManager {
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
        } catch (Exception e) {
        }
    }
    public boolean testDatasource(AccessDatasource ad){
        try {
            String Ser="jdbc:sqlserver://"+ad.getServerName()+";"+"DatabaseName="+ad.getDatabaseName();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection c = DriverManager.getConnection(Ser, ad.getUserLogin(), ad.getPassword());
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
}
