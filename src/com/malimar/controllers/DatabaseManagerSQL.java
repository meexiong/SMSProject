
package com.malimar.controllers;

import static com.malimar.controllers.AESecrp.decrypt;
import com.malimar.utils.MsgBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManagerSQL {
     public static String serverName;
     public static String dbName;
     public static String userLogin;
     public static String pass;
     public static String port;
    public static Connection getConnection(){
        try {
            String sql;  
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Conn/SMS.accdb");
            sql="SELECT * FROM Tb_Datasoure where DID=1001";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                serverName="jdbc:sqlserver://"+decrypt(rs.getString("Servername"));
                dbName=decrypt(rs.getString("DBname"));
                userLogin=decrypt(rs.getString("users"));
                pass=decrypt(rs.getString("passwords"));
                port=decrypt(rs.getString("ports"));
            }
            String Ser=serverName+";"+"DatabaseName="+dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection c = DriverManager.getConnection(Ser, userLogin, pass);
            return c;
            
        } catch (Exception e) {
            MsgBox.msgError();
        }
        return null;
    }  
    public String getUserPassword(String username) throws SQLException{
        String pw = null;
        Connection c = getConnection();
        Statement statement = c.createStatement();
        String query = "select * from Tbl_User where UserLogin ='"+username+"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
           pw=rs.getString("User_pwd").replaceAll(" ", "");
        }
        return pw;
    }
}
