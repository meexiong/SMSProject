
package com.malimar.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ChangeRate {
    int id;
    String currency;
    float rateLAK;
    float rateTHB;
    float rateUSD;
    Connection c = DatabaseManagerSQL.getConnection();
    public ChangeRate(){
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setRateLAK(float rateLAK) {
        this.rateLAK = rateLAK;
    }

    public void setRateTHB(float rateTHB) {
        this.rateTHB = rateTHB;
    }

    public void setRateUSD(float rateUSD) {
        this.rateUSD = rateUSD;
    }

    public int getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public float getRateLAK() {
        return rateLAK;
    }

    public float getRateTHB() {
        return rateTHB;
    }

    public float getRateUSD() {
        return rateUSD;
    }
    public void load(DefaultTableModel model){
        try {
            String query = "Select * from tbl_RecType where RecType='CUR'";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int no = rs.getInt("RecTypeID");
                String cur = rs.getString("RecType_"+LabelManager.LangType+"");
                float kip = rs.getFloat("RecTypeLAK");
                float baht = rs.getFloat("RecTypeTHB");
                float usd = rs.getFloat("RecTypeUSD");
                Object[] obj = new Object[]{no, cur, kip, baht, usd};
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean update(){
        try {
            String update = "Update tbl_RecType set RecTypeLAK=?, RecTypeTHB=?, RecTypeUSD=? where RecTypeID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setFloat(1, getRateLAK());
            p.setFloat(2, getRateTHB());
            p.setFloat(3, getRateUSD());
            p.setInt(4, getId());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
