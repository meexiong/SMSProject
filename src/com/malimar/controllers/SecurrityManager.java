
package com.malimar.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecurrityManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public boolean getmyComputerMotherBoard(){
        try {
            String query = "Select scKey, scMacAddress from tbl_Securrity\n" +
            "where scMacAddress='151260890301413'\n" +
            "group by scKey, scMacAddress\n" +
            "having Sum(scCount)=1";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
