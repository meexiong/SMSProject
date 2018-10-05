
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class ProductManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public HashMap<String, Object[]>mapUnit(){
        try {
            HashMap<String, Object[]>smap = new HashMap();
            String sql = "exec pd_RecTypeInfor 'UNT'";
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
    public boolean insert(Product pd){
        try {
            GetMaxID gm = new GetMaxID();
            String insert = "Insert into tbl_Product(ProdID, ProductName_L1, ProductName_L2, Description, Bar1, Cost, PriceA, Quantity, Inactive, Images, UnitName_L1, UnitName_L2)values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID2("tbl_Product", "ProdID"));
            p.setString(2, pd.getProductName_L1());
            p.setString(3, pd.getProductName_L2());
            p.setString(4, pd.getDescription());
            p.setString(5, pd.getBarcode());
            p.setDouble(6, pd.getCost());
            p.setDouble(7, pd.getPrice());
            p.setInt(8, pd.getQuantity());
            p.setBoolean(9, pd.isChInActive());
            if (pd.getPath() != null) {
                File ff = new File(pd.getPath());
                FileInputStream fis = new FileInputStream(ff);
                int len = (int) ff.length();
                p.setBinaryStream(10, fis, len);
            } else {
                p.setNull(10, java.sql.Types.BLOB);
            }
            p.setString(11, pd.getUnitName_L1());
            p.setString(12, pd.getUnitName_L2());
            return p.executeUpdate()==1;
        } catch (FileNotFoundException | SQLException e) {
        }
        return false;
    }
    public boolean update(Product pd){
        try {
            String update = "Update tbl_Product set ProductName_L1=?, ProductName_L2=?, Description=?, Bar1=?, Cost=?, PriceA=?, Quantity=?, Inactive=?, UnitName_L1=?, UnitName_L2=? where ProdID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setString(1, pd.getProductName_L1());
            p.setString(2, pd.getProductName_L2());
            p.setString(3, pd.getDescription());
            p.setString(4, pd.getBarcode());
            p.setDouble(5, pd.getCost());
            p.setDouble(6, pd.getPrice());
            p.setInt(7, pd.getQuantity());
            p.setBoolean(8, pd.isChInActive());
            p.setString(9, pd.getUnitName_L1());
            p.setString(10, pd.getUnitName_L2());
            p.setInt(11, pd.getProductID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateImage(Product pd) {
        try {
            String update = "Update tbl_Product set Images=? where ProdID=?";
            PreparedStatement p = c.prepareStatement(update);
            File ff = new File(pd.getPath());
            FileInputStream fis = new FileInputStream(ff);
            int len = (int) ff.length();
            p.setBinaryStream(1, fis, len);
            p.setInt(2, pd.getProductID());
            return p.executeUpdate() == 1;
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void load(DefaultTableModel model){
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String query = "Select * from tbl_Product where Inactive=1";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("ProdID");
                String name1 = rs.getString("ProductName_L1");
                String name2 = rs.getString("ProductName_L2");
                String desc = rs.getString("Description");
                double cost = rs.getDouble("Cost");
                double price = rs.getDouble("PriceA");
                int qty = rs.getInt("Quantity");
                Boolean inActive = rs.getBoolean("Inactive");
                Object[] obj = new Object[]{id, name1, name2, desc, df.format(cost), df.format(price), qty, inActive};
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void loadEdit(Product pd){
        try {
            String query = "Select * from tbl_Product where Inactive=1 and ProdID="+pd.getProductID()+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                pd.setProductName_L1(rs.getString("ProductName_L1"));
                pd.setProductName_L2(rs.getString("ProductName_L2"));
                pd.setBarcode(rs.getString("Bar1"));
                pd.setDescription(rs.getString("Description"));
                pd.setCost(rs.getDouble("Cost"));
                pd.setPrice(rs.getDouble("PriceA"));
                pd.setQuantity(rs.getInt("Quantity"));
                pd.setChInActive(rs.getBoolean("Inactive"));
                pd.setPicture(rs.getBytes("Images"));
                pd.setUnitName(rs.getString("UnitName_"+LangType+""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
