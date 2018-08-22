
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SchaduleManager {
    Connection c = DatabaseManagerSQL.getConnection();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
        }
        return null;
    }
    public HashMap<String, Object[]>mapTeacher(){
        try {
            HashMap<String, Object[]> tmap = new HashMap<>();
            String query = "Select TEID, T_Nbr, T_Name_"+LangType+" as teacher from tbl_Teacher";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                tmap.put(rs.getString("teacher"), new Object[]{rs.getInt("TEID"), rs.getString("T_Nbr"), rs.getString("teacher")});
            }
            rs.close();
            return tmap;
        } catch (SQLException e) {
        }
        return null;
    }
    public HashMap<String, Object[]>mapRoom(){
        try {
            HashMap<String, Object[]> rmap = new HashMap<>();
            String query = "Select RoomID, RoomNbr, RoomMax from tbl_Room";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                rmap.put(rs.getString("RoomNbr"), new Object[]{rs.getInt("RoomID"), rs.getString("RoomNbr"), rs.getString("RoomMax")});
            }
            rs.close();
            return rmap;
        } catch (SQLException e) {
        }
        return null;
    }
    public void showSemesterInfo(Schedule sd){
        try {
            String sql = "Select startdate, enddate from tbl_Semester \n" +
                    "where SemesterID = N'"+ sd.getSemesterID() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                sd.setStartDate(rs.getDate("startDate"));
                sd.setEndDate(rs.getDate("enddate"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showCol(JTable table, int col){
        table.getColumnModel().getColumn(col).setMinWidth(90);
        table.getColumnModel().getColumn(col).setMaxWidth(90);
        table.getColumnModel().getColumn(col).setMaxWidth(90);
        table.getColumnModel().getColumn(col).setWidth(90);
        table.getColumnModel().getColumn(col).setPreferredWidth(90);
    }
    public void hideCol(JTable table, int col) {
        table.getColumnModel().getColumn(col).setMinWidth(0);
        table.getColumnModel().getColumn(col).setMaxWidth(0);
    }
    public boolean insert(Schedule sd){
        try {
            String insert = "Insert into tbl_Schedule(ScheduleID,SemesterID,CreateDate,CreatebyUser)values(?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, sd.getScheduleID());
            p.setInt(2, sd.getSemesterID());
            p.setString(3, df.format(sd.getCreatedate()));
            p.setString(4, sd.getCreatebyUser());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(Schedule sd){
        try {
            String insert = "Update tbl_Schedule set SemesterID=? where ScheduleID=?";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, sd.getSemesterID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public int getScheduleTextID(Schedule sd){
        try {
            String query = "Select ScheduleID from tbl_Schedule where SemesterID="+sd.getSemesterID()+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getInt("ScheduleID");
            }
        } catch (SQLException e) {
        }
        return 0;
    }
    public boolean updateSemesterStatus(Schedule sd){
        try {
            String update = "Update tbl_Semester set SemStatus=? where SemesterID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setBoolean(1, sd.isSchStatus());
            p.setInt(2, sd.getSemesterID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean insertDetails(Schedule sd, JTable table){
        try {
            int row = table.getSelectedRow();
            String insert = "Insert into tbl_ScheduleDetails(SCDID, ScheduleID, CourseID, TEID, RoomID, Price, Sun, SunTime, Mon, MonTime, Tue, TueTime, Wed, WedTime, Thur, ThurTime, Fri, FriTime, Sat, SatTime,RowNbr)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, Integer.parseInt(table.getValueAt(row, 19).toString()));
            p.setInt(2, sd.getScheduleID());
            p.setInt(3, sd.getCourseID());
            p.setInt(4, sd.getTecherID());
            p.setInt(5, sd.getRoomID());
            p.setFloat(6, Float.parseFloat(table.getValueAt(row, 4).toString().replace(",", "")));
            p.setBoolean(7, (boolean) table.getValueAt(row, 5));
            p.setString(8, table.getValueAt(row, 6).toString());
            p.setBoolean(9, (boolean) table.getValueAt(row, 7));
            p.setString(10, table.getValueAt(row, 8).toString());
            p.setBoolean(11, (boolean) table.getValueAt(row, 9));
            p.setString(12, table.getValueAt(row, 10).toString());
            p.setBoolean(13, (boolean) table.getValueAt(row, 11));
            p.setString(14, table.getValueAt(row, 12).toString());
            p.setBoolean(15, (boolean) table.getValueAt(row, 13));
            p.setString(16, table.getValueAt(row, 14).toString());
            p.setBoolean(17, (boolean) table.getValueAt(row, 15));
            p.setString(18, table.getValueAt(row, 18).toString());
            p.setBoolean(19, (boolean) table.getValueAt(row, 17));
            p.setString(20, table.getValueAt(row, 18).toString());
            p.setInt(21, Integer.parseInt(table.getValueAt(row, 0).toString()));
            return p.executeUpdate()==1;
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showScheduleDetails(Schedule sd, DefaultTableModel model){
        try {
            DecimalFormat decmal = new DecimalFormat("#,##0.00");
            String query = "pd_ScheduleDetailFilter "+sd.getSemesterID()+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int scheduleDID = rs.getInt("SCDID");
                int rowNbr = rs.getInt("RowNbr");
                String courseID = rs.getString("CourseName_"+LangType+"");
                String teacherID = rs.getString("T_Name_"+LangType+"");
                String roomID = rs.getString("RoomNbr");
                float price = rs.getFloat("Price");
                Boolean sun = rs.getBoolean("Sun");
                String sunTime = rs.getString("SunTime");
                Boolean mon = rs.getBoolean("Mon");
                String monTime = rs.getString("MonTime");
                Boolean tue = rs.getBoolean("Tue");
                String tueTime = rs.getString("TueTime");
                Boolean wed = rs.getBoolean("Wed");
                String wedTime = rs.getString("WedTime");
                Boolean thur = rs.getBoolean("Thur");
                String thurTime = rs.getString("ThurTime");
                Boolean fri = rs.getBoolean("Fri");
                String friTime = rs.getString("FriTime");
                Boolean sat = rs.getBoolean("Sat");
                String satTime = rs.getString("SatTime");
                Object[] obj = new Object[]{rowNbr, courseID, teacherID, roomID, decmal.format(price), sun, sunTime, mon, monTime, tue, tueTime, wed, wedTime, thur, thurTime, fri, friTime, sat, satTime,scheduleDID};
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean deleteDetails(int scdid, int sid){
        try {
            String delete = "Delete tbl_ScheduleDetails where SCDID=? and ScheduleID=?";
            PreparedStatement p = c.prepareStatement(delete);
            p.setInt(1, scdid);
            p.setInt(2, sid);
            return p.executeUpdate()==1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public int checkScheduleDetailID(int sdid){
        try {
            String query = "Select SCDID from tbl_ScheduleDetails where SCDID="+sdid+"";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
