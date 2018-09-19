
package com.malimar.controllers;

import com.malimar.models.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class RoomManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public boolean insert(Room rm){
        try {
            String insert = "Insert into tbl_Room(RoomID, RoomNbr, RoomMax)values(?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, rm.getRoomID());
            p.setString(2, rm.getRoomNbr());
            p.setInt(3, rm.getRoomMax());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean update(Room rm){
        try {
            String update = "Update tbl_Room set RoomNbr=?, RoomMax=? where RoomID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setString(1, rm.getRoomNbr());
            p.setInt(2, rm.getRoomMax());
            p.setInt(3, rm.getRoomID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean delete(Room rm){
        try {
            String delete = "Delete tbl_Room where RoomID=?";
            PreparedStatement p = c.prepareStatement(delete);
            p.setInt(1, rm.getRoomID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void load(DefaultTableModel model){
        try {
             String query = "Select * from tbl_Room";
             ResultSet rs = c.createStatement().executeQuery(query);
             while(rs.next()){
                 int id = rs.getInt("RoomID");
                 String nbr = rs.getString("RoomNbr");
                 int max = rs.getInt("RoomMax");
                 Object[] obj = new Object[]{id, nbr, max};
                 model.addRow(obj);
             }
        } catch (SQLException e) {
        }
    }
}
