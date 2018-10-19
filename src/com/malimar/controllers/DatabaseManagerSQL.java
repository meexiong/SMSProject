
package com.malimar.controllers;

import static com.malimar.controllers.AESecrp.decrypt;
import com.malimar.utils.MsgBox;
import com.malimar.views.FrmChangeMe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
            String Ser=serverName+";"+"databaseName="+dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection c = DriverManager.getConnection(Ser, userLogin, pass);
            return c;
            
        } catch (Exception e) {
            MsgBox.msgDBDisconnect();
//            e.printStackTrace();
        }
        return null;
    }  
    public String getUserPassword(String username) throws SQLException{
        String pw = null;
        Connection c = getConnection();
        Statement statement = c.createStatement();
        String query = "select * from Tbl_User where UserLogin ='"+username+"' and Userlogin_Status=1";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
           pw=rs.getString("User_pwd").replaceAll(" ", "");
           String user = rs.getString("Userlogin");
           int id = rs.getInt("userid");
           if(pw.equals("ChangeMe")){
               FrmChangeMe frmChange = new FrmChangeMe(null, true, id, user);
               frmChange.setVisible(true);
           }
        }
        return pw;
    }
    public static String getUserNbr(String username){
        try {
            Connection c = getConnection();
            String query = "Select T_Nbr from tbl_Teacher where TEmail='"+username+"'";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getString("T_Nbr");
            }
        } catch (Exception e) {
        }
         return null;
    }
}
