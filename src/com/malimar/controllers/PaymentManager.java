
package com.malimar.controllers;

import com.malimar.models.Payment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public void loadRate(Payment pm){
        try {
            String query = "Select * from tbl_RecType where RecType='CUR' and RecType_L2='LAK'";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                pm.setRateLAK(rs.getFloat("RecTypeLAK"));
                pm.setRateTHB(rs.getFloat("RecTypeTHB"));
                pm.setRateUSD(rs.getFloat("RecTypeUSD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
