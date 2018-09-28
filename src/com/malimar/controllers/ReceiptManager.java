
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Receipt;
import com.malimar.views.FrmOpenReport;
import java.awt.event.MouseEvent;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

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
        }
    }
    public void loadByRegistrationID(DefaultTableModel model, Receipt rct){
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String query = "Exec pd_PaymentListByRgtID "+rct.getRegisterID()+"";
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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
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
                Blob attach1 = rs.getBlob("AttachFile1");
                Blob attach2 = rs.getBlob("AttachFile2");
                Object[] obj;
                if(attach1==null && attach2==null){
                    obj = new Object[]{id, date, payment, df.format(amountLAK), df.format(amountTHB), df.format(amountUSD), df.format(amountTotal),null,null};
                }else if(attach1 !=null && attach2==null){
                    obj = new Object[]{id, date, payment, df.format(amountLAK), df.format(amountTHB), df.format(amountUSD), df.format(amountTotal),"File 1",null};
                }else if(attach1 ==null && attach2 !=null){
                    obj = new Object[]{id, date, payment, df.format(amountLAK), df.format(amountTHB), df.format(amountUSD), df.format(amountTotal),null,"File 2"};
                }else{
                    obj = new Object[]{id, date, payment, df.format(amountLAK), df.format(amountTHB), df.format(amountUSD), df.format(amountTotal),"File 1","File 2"};
                }
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
    public void attached(JTable table, DefaultTableModel model, MouseEvent evt, JPopupMenu ppm, JDialog fm){
        try {
            model = (DefaultTableModel) table.getModel();
            Connection c = DatabaseManagerSQL.getConnection();
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            int rcpid = Integer.parseInt(table.getValueAt(row, 0).toString());
            String sql;
            if (col == 0) {
                table.setComponentPopupMenu(ppm);
            } else {
                table.setComponentPopupMenu(null);
            }
            if (evt.getClickCount() == 2) {
                switch (col) {
                    case 7:
                        if (evt.getModifiers() == MouseEvent.BUTTON3_MASK) {
                            sql = "Update tbl_Receipt set AttachFile1=? where ReceiptID=?";
                            AttachFile.saveAttachFile(sql, rcpid);
                            model.setValueAt("File 1", row, 7);
                        } else {
                            sql = "Select AttachFile1 from tbl_Receipt where ReceiptID=" + rcpid + "";
                            AttachFile.openFile(sql, "AttachFile1");
                        }
                        break;
                    case 8:
                        if (evt.getModifiers() == MouseEvent.BUTTON3_MASK) {
                            sql = "Update tbl_Receipt set AttachFile2=? where ReceiptID=?";
                            AttachFile.saveAttachFile(sql, rcpid);
                            model.setValueAt("File 2", row, 8);
                        } else {
                            sql = "Select AttachFile2 from tbl_Receipt where ReceiptID=" + rcpid + "";
                            AttachFile.openFile(sql, "AttachFile2");
                        }
                        break;
                    default:
                        Map param = new HashMap();
                        param.put("receiptID", rcpid);
                        JasperPrint pri;
                        if ("L1".equals(LangType)) {
                            pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintReceipt_L1.jasper", param, c);
                        } else {
                            pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintReceipt_L2.jasper", param, c);
                        }
                        FrmOpenReport f = new FrmOpenReport();
                        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        f.setTitle("Print Receipt");
                        f.getContentPane().add(new JRViewer(pri));
                        fm.dispose();
                        f.setVisible(true);
                        break;
                }
            }
        } catch (NumberFormatException | JRException e) {
        }
    }
    public boolean delete(Receipt rct){
        try {
            String delete = "Delete tbl_Receipt where ReceiptID=?";
            PreparedStatement p = c.prepareStatement(delete);
            p.setInt(1, rct.getReceiptID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }

    public void printInstallment(Receipt rct, JDialog fm) {
        try {
            Map param = new HashMap();
            param.put("registerID", rct.getRegisterID());
            JasperPrint pri;
            if ("L1".equals(LangType)) {
                pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintReceiptInstallment_L1.jasper", param, c);
            } else {
                pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintReceiptInstallment_L2.jasper", param, c);
            }
            FrmOpenReport f = new FrmOpenReport();
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setTitle("Print Installment");
            f.getContentPane().add(new JRViewer(pri));
            fm.dispose();
            f.setVisible(true);
        } catch (JRException e) {
        }
    }
}
