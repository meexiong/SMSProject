
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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
    public void showSemseterDetails(DefaultTableModel model, int smid){
        try {
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
                Object[] obj = new Object[]{false, id, course, teacher, room, price, sun, mon, tue, wed, thur, fri, sat};
                model.addRow(obj);
            }
        } catch (Exception e) {
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
}
