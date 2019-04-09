package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Sale;
import com.malimar.utils.ClearTable;
import com.malimar.views.FrmMain;
import static com.malimar.views.FrmMain.userNbr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

public class SaleManager {

    Connection c = DatabaseManagerSQL.getConnection();

    public HashMap<String, Object[]> mapEmp() {
        try {
            HashMap<String, Object[]> smap = new HashMap();
            String sql = "Select TEID, T_Nbr, T_Name_L1, T_Name_L2 from tbl_Teacher";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                smap.put(rs.getString("T_Name_" + LangType + ""), new Object[]{rs.getInt("TEID"), rs.getString("T_Nbr"), rs.getString("T_Name_L1"), rs.getString("T_Name_L2")});
            }
            rs.close();
            return smap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, Object[]> mapCurrency() {
        try {
            HashMap<String, Object[]> smap = new HashMap();
            String sql = "Select * from tbl_RecType where RecType='CUR'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                smap.put(rs.getString("RecType_" + LangType + ""), new Object[]{rs.getInt("RecTypeID"), rs.getString("RecType_" + LangType + ""), rs.getString("RecType_L1"), rs.getString("RecType_L2"), rs.getFloat("RecTypeLAK"), rs.getFloat("RecTypeTHB"), rs.getFloat("RecTypeUSD"), rs.getInt("RecTypeDefault")});
            }
            rs.close();
            return smap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, Object[]> mapPaymentType() {
        try {
            HashMap<String, Object[]> smap = new HashMap();
            String sql = "exec pd_RecTypeInfor 'PMT'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                smap.put(rs.getString("RecType_" + LangType + ""), new Object[]{rs.getInt("RecTypeID"), rs.getString("RecType_L1"), rs.getString("RecType_L2"), rs.getString("RecType_" + LangType + ""), rs.getInt("RecTypeDefault")});
            }
            rs.close();
            return smap;
        } catch (SQLException e) {
        }
        return null;
    }

    public void search(DefaultTableModel model) {
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String query = "Select ProdID, ProductName_" + LangType + " as productName, PriceA from tbl_Product where Inactive=1";
            ResultSet rs = c.createStatement().executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ProdID");
                String name = rs.getString("productName");
                double price = rs.getDouble("PriceA");
                Object[] obj = new Object[]{id, name, df.format(price)};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByName(DefaultTableModel model, String txt) {
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String query = "Select ProdID, ProductName_" + LangType + " as productName, PriceA from tbl_Product where (Inactive=1) and (ProductName_L1 like N'%" + txt + "%' or ProductName_L2 like N'%" + txt + "%')";
            ResultSet rs = c.createStatement().executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ProdID");
                String name = rs.getString("productName");
                double price = rs.getDouble("PriceA");
                Object[] obj = new Object[]{id, name, df.format(price)};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectItem(Sale sale, int id) {
        try {
            String query = "Select ProdID, ProductName_" + LangType + " as productName, PriceA, UnitName_" + LangType + " as unitName from tbl_Product where (Inactive=1) and (ProdID=" + id + ")";
            ResultSet rs = c.createStatement().executeQuery(query);
            if (rs.next()) {
                sale.setProductName(rs.getString("productName"));
                sale.setPrice(rs.getDouble("PriceA"));
                sale.setUnitName(rs.getString("unitName"));
            }
        } catch (SQLException e) {
        }
    }

    public float getVat() {
        try {
            String query = "Select RecTypeLAK from tbl_RecType where RecTypeDefault=1 and RecType='VAT'";
            ResultSet rs = c.createStatement().executeQuery(query);
            if (rs.next()) {
                return rs.getFloat("RecTypeLAK");
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public boolean insert(Sale sale) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            String cdate = df.format(now);
            GetMaxID gm = new GetMaxID();
            sale.setSaleid(gm.getIntID2("tbl_Sale", "SaleID"));
            String insert = "Insert into tbl_Sale(SaleID, CreateDate, CreateBy, SaleDate, SalePerson, Currency_L1, Currency_L2, PaymentType_L1, PaymentType_L2, SubTotal, DisPercentage, DisAmount, VatPercentage, VatAmount, GrandTotal, PaidTotal, Void)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, sale.getSaleid());
            p.setString(2, cdate);
            p.setString(3, FrmMain.userNbr);
            p.setString(4, df.format(sale.getSaleDate()));
            p.setString(5, sale.getSalePerson());
            p.setString(6, sale.getCurrency_L1());
            p.setString(7, sale.getCurrency_L2());
            p.setString(8, sale.getPaymentType_L1());
            p.setString(9, sale.getPaymentType_L2());
            p.setDouble(10, sale.getSubTotal());
            p.setFloat(11, sale.getDiscountPercentage());
            p.setDouble(12, sale.getDiscountAmount());
            p.setFloat(13, sale.getVatPercentage());
            p.setDouble(14, sale.getVatAmount());
            p.setDouble(15, sale.getGrandTotal());
            p.setDouble(16, sale.getPaidTotal());
            p.setInt(17, 0);
            return p.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertDetails(Sale sale) {
        try {
            GetMaxID gm = new GetMaxID();
            String insert = "Insert into tbl_SaleDetail(SaleDID, SaleID, ProductID, SalePrice, SaleQty, SaleTotal)values(?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID("tbl_SaleDetail", "SaleDID"));
            p.setInt(2, sale.getSaleid());
            p.setInt(3, sale.getProductID());
            p.setDouble(4, sale.getPrice());
            p.setFloat(5, sale.getQty());
            p.setDouble(6, sale.getTotal());
            return p.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void printBill(Sale sale) {
        try {
            Map param = new HashMap();
            param.put("saleID", sale.getSaleid());
            JasperPrint pri;
            if ("L1".equals(LangType)) {
                pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintSale_L1.jasper", param, c);
            } else {
                pri = JasperFillManager.fillReport("src/com/malimar/reports/PrintSale_L1.jasper", param, c);
            }
            JasperPrintManager.printReport(pri, false);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public boolean voidBill(int id) {
        try {
            Date now = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String vDate = df.format(now);
            String update = "update tbl_Sale set Void=?, VoidDate=?, VoidBy=? where SaleID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setInt(1, 1);
            p.setString(2, vDate);
            p.setString(3, FrmMain.userNbr);
            p.setInt(4, id);
            return p.executeUpdate() == 1;
        } catch (Exception e) {
        }
        return false;
    }

    public void load(JTable table, DefaultTableModel model, Sale s) {
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            ClearTable.clearFirstLoad(table, model);
            String query = "SELECT dbo.tbl_SaleDetail.SaleDID, dbo.tbl_SaleDetail.ProductID, \n"
                    + "dbo.tbl_Product.ProductName_" + LangType + " as proname, dbo.tbl_Product.UnitName_" + LangType + " as units, \n"
                    + "dbo.tbl_SaleDetail.SalePrice, dbo.tbl_SaleDetail.SaleQty, dbo.tbl_SaleDetail.SaleTotal\n"
                    + "FROM dbo.tbl_SaleDetail INNER JOIN\n"
                    + "dbo.tbl_Product ON dbo.tbl_SaleDetail.ProductID = dbo.tbl_Product.ProdID\n"
                    + "where dbo.tbl_SaleDetail.SaleID=" + s.getSaleid() + "";
            ResultSet rs = c.createStatement().executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("SaleDID");
                int proid = rs.getInt("ProductID");
                String proname = rs.getString("proname");
                String unit = rs.getString("units");
                double price = rs.getDouble("SalePrice");
                int qty = rs.getInt("SaleQty");
                double total = rs.getDouble("SaleTotal");
                Object[] obj = new Object[]{id, proid, proname, unit, df.format(price), qty, df.format(total)};
                model.addRow(obj);
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(Sale s) {
        try {
            String query = "SELECT  SaleID, SaleDate, Currency_" + LangType + " as cur, PaymentType_" + LangType + " as pt, SubTotal,\n"
                    + "DisPercentage, DisAmount, VatPercentage, VatAmount, GrandTotal\n"
                    + "FROM dbo.tbl_Sale where SaleID=" + s.getSaleid() + "";
            ResultSet rs = c.createStatement().executeQuery(query);
            if (rs.next()) {
                s.setSaleid(rs.getInt("SaleID"));
                s.setSaleDate(rs.getDate("SaleDate"));
                s.setCurrency(rs.getString("cur"));
                s.setPaymentType(rs.getString("pt"));
                s.setSubTotal(rs.getDouble("SubTotal"));
                s.setDiscountPercentage(rs.getFloat("DisPercentage"));
                s.setDiscountAmount(rs.getDouble("DisAmount"));
                s.setVatPercentage(rs.getFloat("VatPercentage"));
                s.setVatAmount(rs.getDouble("VatAmount"));
                s.setGrandTotal(rs.getDouble("GrandTotal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getLoginUser() {
        try {
            String query = "Select T_Name_"+LangType+" as loginName from tbl_Teacher where T_Nbr=N'"+userNbr+"'";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getString("loginName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void cancelBill(Sale s){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String query = "Update tbl_Sale set Void=?, VoidDate=?, VoidBy=? where SaleID=?";
            PreparedStatement p = c.prepareStatement(query);
            p.setBoolean(1, true);
            p.setString(2, df.format(s.getVoidDate()));
            p.setString(3, s.getLoginBy());
            p.setInt(4, s.getSaleid());
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
