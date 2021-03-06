
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Registration;
import static com.malimar.views.FrmMain.userNbr;
import com.malimar.views.FrmOpenReport;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class RegistrationManager {
    
    Connection c = DatabaseManagerSQL.getConnection();
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
    public HashMap<String, Object[]>mapStudent(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "exec pd_StudentInfo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                smap.put(rs.getString("StdName_"+LangType+""), new Object[]{rs.getInt("StdID"),rs.getString("StdNbr"), rs.getString("StdName_"+LangType+""), rs.getString("Gen_"+LangType+""), rs.getString("NT_Name_"+LangType+""), rs.getString("ET_Name_"+LangType+""), rs.getString("RE_Name_"+LangType+"")});
            }
            rs.close();
            return smap;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>mapCurrency(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "Select * from tbl_RecType where RecType='CUR'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                smap.put(rs.getString("RecType_"+LangType+""), new Object[]{rs.getInt("RecTypeID"),rs.getString("RecType_"+LangType+""),rs.getString("RecType_L1"),rs.getString("RecType_L2"), rs.getFloat("RecTypeLAK"), rs.getFloat("RecTypeTHB"), rs.getFloat("RecTypeUSD")});
            }
            rs.close();
            return smap;            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void showSemseterDetails(DefaultTableModel model, int smid){
        try {
            DecimalFormat df= new DecimalFormat("#,##0.00");
            String query = "exec pd_ScheduleRegistration "+smid+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("SCDID");
                String course = rs.getString("CourseName_"+LangType+"");
                String teacher = rs.getString("T_Name_"+LangType+"");
                String room = rs.getString("RoomNbr").trim();
                double price = rs.getDouble("Price");
                boolean sun = rs.getBoolean("Sun");
                boolean mon = rs.getBoolean("Mon");
                boolean tue = rs.getBoolean("Tue");
                boolean wed = rs.getBoolean("Wed");
                boolean thur = rs.getBoolean("Thur");
                boolean fri = rs.getBoolean("Fri");
                boolean sat =  rs.getBoolean("Sat");
                Object[] obj = new Object[]{false, id, course, teacher, room, df.format(price), sun, mon, tue, wed, thur, fri, sat};
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createCheck(JTable table, DefaultTableModel model){
        try {
        model.addTableModelListener(new HeaderCheckBoxHandler(table));
        TableCellRenderer r = new HeaderRenderer(table.getTableHeader(), 0);
        table.getColumnModel().getColumn(0).setHeaderRenderer(r);
        TableCellRenderer leftAlign = new LeftAlignHeaderRenderer();
        table.getColumnModel().getColumn(1).setHeaderRenderer(leftAlign);
        table.getColumnModel().getColumn(2).setHeaderRenderer(leftAlign);
        table.getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {
        }
    }
    public void calculate(JTable table, Registration rgt) {
        int rowCount = table.getRowCount() - 1;
        double price = 0;
        for (int i = 0; i <= rowCount; i++) {
            Boolean check = (Boolean) table.getValueAt(i, 0);
            if (check==true) {
                price += Double.parseDouble(table.getValueAt(i, 5).toString().replace(",", ""));
            }
        }
        double dm = (price * rgt.getDisPC()) / 100;
        rgt.setDisAmount(dm);
        double gt =price-dm;
        rgt.setGrandTotal(gt);
        float vat = rgt.getVat();
        double st = (gt * 100) / (100 + vat);
        rgt.setSubTotal(st);    
        rgt.setVatAmount(gt-st);
    }
    public boolean insert(Registration rgt){
        try {
            Date now = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String insert = "Insert into tbl_Registration(RegisterID, CreateDate, CreateBy, StdID, SubTotal, DisPC, DisAmount, VAT, VATAmount, GrandTotal, Currency_L1, Currency_L2, RegisterDate, VoidStatus)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, rgt.getRegistrationID());
            p.setString(2, df.format(now));
            p.setString(3, userNbr);
            p.setInt(4, rgt.getStudentID());
            p.setDouble(5, rgt.getSubTotal());
            p.setFloat(6, rgt.getDisPC());
            p.setDouble(7, rgt.getDisAmount());
            p.setFloat(8, rgt.getVat());
            p.setDouble(9, rgt.getVatAmount());
            p.setDouble(10, rgt.getGrandTotal());
            p.setString(11, rgt.getCurrency_L1());
            p.setString(12, rgt.getCurrency_L2());
            p.setString(13, df.format(rgt.getRgtDate()));
            p.setBoolean(14, false);
            return p.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(Registration rgt){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String update = "Update tbl_registration set StdID=?, SubTotal=?, DisPC=?, DisAmount=?, VAT=?, VATAmount=?, GrandTotal=?, Currency_L1=?, Currency_L2=?, RegisterDate=?  where RegisterID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setInt(1, rgt.getStudentID());
            p.setDouble(2, rgt.getSubTotal());
            p.setFloat(3, rgt.getDisPC());
            p.setDouble(4, rgt.getDisAmount());
            p.setFloat(5, rgt.getVat());
            p.setDouble(6, rgt.getVatAmount());
            p.setDouble(7, rgt.getGrandTotal());
            p.setString(8, rgt.getCurrency_L1());
            p.setString(9, rgt.getCurrency_L2());
            p.setString(10, df.format(rgt.getRgtDate()));
            p.setInt(11, rgt.getRegistrationID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false; 
    }
    public boolean insertDetail(Registration rgt){
        try {
            String insert = "Insert into tbl_RegistrationDetails(RegisterDID, RegisterID, SCDID, Price)values(?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, rgt.getRegtDetailID());
            p.setInt(2, rgt.getRegistrationID());
            p.setInt(3, rgt.getScheduleDetailID());
            p.setDouble(4, rgt.getPrice());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean deleteDetail(Registration rgt){
        try {
            String delete ="Delete tbl_RegistrationDetails where RegisterID=?";
            PreparedStatement p = c.prepareStatement(delete);
            p.setInt(1, rgt.getRegistrationID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public void loadRegistrationInfo(DefaultTableModel model, int semester){
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String query ="Exec pd_RegistrationInfo "+semester+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("RegisterID");
                String stdNbr = rs.getString("StdNbr");
                String stdName = rs.getString("StdName_"+LangType+"");
                String course = rs.getString("CourseName_"+LangType+"");
                double price = rs.getDouble("price");
                String cur = rs.getString("Currency_"+LangType+"");
                Object[] obj = new Object[]{false, id, stdNbr, stdName, course, df.format(price),cur};
                model.addRow(obj);
            }
        } catch (SQLException e) {
        }
    }
    public void printReport(Registration rgt) {
        try {
            Map param = new HashMap();
            param.put("registerID", rgt.getRegistrationID());
            JasperPrint pri;
            if ("L1".equals(LangType)) {
                pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintRegistration_L1.jasper", param, c);
            } else {
                pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintRegistration_L2.jasper", param, c);
            }
            FrmOpenReport f = new FrmOpenReport();
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setTitle("Registration Invoice");
            f.getContentPane().add(new JRViewer(pri));
            f.setVisible(true);
        } catch (JRException e) {
        }
    }
    public void voidRegistration(Registration rgt){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            String update = "Update tbl_Registration set VoidStatus=?, VoidDate=?, VoidBy=? where RegisterID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setBoolean(1, true);
            p.setString(2, df.format(now));
            p.setString(3, userNbr);
            p.setInt(4, rgt.getRegistrationID());
            p.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public float getVatDefault(){
        try {
            String query = "Select RecTypeLAK from tbl_RecType where RecType='VAT' and RecTypeDefault=1";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getFloat("RecTypeLAK");
            }
        } catch (SQLException e) {
        }
        return 0;
    }
}
