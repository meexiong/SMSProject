
package com.malimar.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMaxID {
    Connection c = DatabaseManagerSQL.getConnection();
    public int getIntID(String dbTable, String colID){
        try {
            String query = "Select isnull(Max("+colID+"),0)+1 as maxID from "+dbTable+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getInt("maxID");
            }
        } catch (SQLException e) {
        }
        return 0;
    }
}
