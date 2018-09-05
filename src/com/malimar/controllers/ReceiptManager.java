
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Receipt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReceiptManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public void load(DefaultTableModel model, Receipt rct){
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String query = "Exec pd_PaymentList "+rct.getSemesterID()+", "+rct.getCourseID()+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("RegisterID");
                String stdID = rs.getString("StdNbr");
                String stdName = rs.getString("StdName_"+LangType+"");
                String sex = rs.getString("Gen_"+LangType+"");
                double total = rs.getDouble("GrandTotal");
                double balance = rs.getDouble("Balance");
                double paid = rs.getDouble("Paid");
                String cur = rs.getString("Currency_"+LangType+"");
                Object[] obj = new Object[]{id, stdID, stdName, sex, df.format(total), df.format(balance), df.format(paid), cur};
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, Object[]>mapRecType(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "exec pd_RecTypeInfor 'PMT'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                smap.put(rs.getString("RecType_"+LangType+""), new Object[]{rs.getInt("RecTypeID"), rs.getString("RecType_L1"), rs.getString("RecType_L2")});
            }
            rs.close();
            return smap;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>mapSemester(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "Select semesterid, semesterName from tbl_Semester where SemStatus=0";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                smap.put(rs.getString("semestername"), new Object[]{rs.getInt("semesterid"), rs.getString("SemesterName"), rs.getString("Semestername")});
            }
            rs.close();
            return smap;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>mapCourse(){
        try {
            HashMap<String, Object[]> cmap = new HashMap<>();
            String query = "Select * from tbl_Course";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                cmap.put(rs.getString("CourseName_"+LangType+""), new Object[]{rs.getInt("CourseID"), rs.getString("CourseName_L1"), rs.getString("CourseName_L2"), rs.getDouble("CoursePrice")});
            }
            rs.close();
            return cmap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public float showRateLAK(String cur){
        try {
            String query = "Select RecTypeLAK from tbl_RecType where RecType_"+LangType+"=N'"+cur+"'";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getFloat("RecTypeLAK");
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public float showRateTHB(String cur){
        try {
            String query = "Select RecTypeTHB from tbl_RecType where RecType_"+LangType+"=N'"+cur+"'";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getFloat("RecTypeTHB");
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public float showRateUSD(String cur){
        try {
            String query = "Select RecTypeUSD from tbl_RecType where RecType_"+LangType+"=N'"+cur+"'";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getFloat("RecTypeUSD");
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public double calculateTotal(Receipt rct) {
        try {
            double amTotal = 0;
            switch (rct.getCurrency()) {
                case "ກີບ":
                case "LAK":
                    amTotal = (rct.getAmountLAK() * rct.getRateLAK()) + (rct.getAmountTHB() * rct.getRateTHB()) + (rct.getAmountUSD() * rct.getRateUSD());
                    break;
                case "ບາດ":
                case "THB":
                    amTotal = (rct.getAmountLAK() / rct.getRateLAK()) + (rct.getAmountTHB() / rct.getRateTHB()) + (rct.getAmountUSD() / rct.getRateUSD());
                    break;
                case "ໂດລາ":
                case "USD":
                    amTotal = (rct.getAmountLAK() / rct.getRateLAK()) + (rct.getAmountTHB() / rct.getRateTHB()) + (rct.getAmountUSD() / rct.getRateUSD());
                    break;
                default:
                    break;
            }
            return amTotal;
        } catch (Exception e) {
        }
        return 0;
    }
    public boolean insert(Receipt rct){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            GetMaxID gm = new GetMaxID();
            String insert = "Insert into tbl_Receipt(ReceiptID, CreateDate, ReceiptDate, Receiptby, RegisterID, Payment_L1, Payment_L2, AmountLAK, AmountTHB, AmountUSD, AmountTotal, RateLAK, RateTHB, RateUSD)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID2("tbl_Receipt", "ReceiptID"));
            p.setString(2, df.format(now));
            p.setString(3, df.format(rct.getReceiptDate()));
            p.setString(4, rct.getReceiptBy());
            p.setInt(5, rct.getRegisterID());
            p.setString(6, rct.getPayment_L1());
            p.setString(7, rct.getPayment_L2());
            p.setDouble(8, rct.getAmountLAK());
            p.setDouble(9, rct.getAmountTHB());
            p.setDouble(10, rct.getAmountUSD());
            p.setDouble(11, calculateTotal(rct));
            p.setFloat(12, rct.getRateLAK());
            p.setFloat(13, rct.getRateTHB());
            p.setFloat(14, rct.getRateUSD());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void loadPayment(DefaultTableModel model, Receipt rct){
        try {
            DecimalFormat  df = new DecimalFormat("#,##0.00");
            String query = "Select * from tbl_Receipt where RegisterID="+rct.getRegisterID()+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("ReceiptID");
                String date = rs.getString("ReceiptDate");
                String payment = rs.getString("Payment_"+LangType+"");
                double amountLAK = rs.getDouble("AmountLAK");
                double amountTHB = rs.getDouble("AmountTHB");
                double amountUSD = rs.getDouble("AmountUSD");
                double amountTotal = rs.getDouble("AmountTotal");
                Object[]  obj = new Object[]{id, date, payment, df.format(amountLAK), df.format(amountTHB), df.format(amountUSD), df.format(amountTotal),null,null};
                model.addRow(obj);
            }
        } catch (SQLException e) {
        }
    }
    public double paid(JTable table){
        try {
            double total=0;
            int rowCount = table.getRowCount();
            for(int i=0; i<rowCount; i++){
                total += Double.parseDouble(table.getValueAt(i, 6).toString().replace(",", ""));
            }
            return total;
        } catch (NumberFormatException e) {
        }
        return 0;
    }
    public double balance(Receipt rct){
        try {
            return rct.getGrandTotal()-rct.getPaid();
        } catch (Exception e) {
        }
        return 0;
    }
}
