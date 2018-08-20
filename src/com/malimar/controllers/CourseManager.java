
package com.malimar.controllers;

import com.malimar.models.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class CourseManager {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection c = DatabaseManagerSQL.getConnection();
    public boolean insert(Course cs){
        try {            
            GetMaxID gm = new GetMaxID();
            String insert = "Insert into tbl_Course(CourseID, CourseName_L1, CourseName_L2, CoursePrice)values(?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID("tbl_Course", "CourseID"));
            p.setString(2, cs.getCourseName_L1());
            p.setString(3, cs.getCourseName_L2());
            p.setDouble(4, cs.getCoursePrice());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    } 
    public boolean update(Course cs){
        try {
            String update = "Update tbl_Course set CourseName_L1=?, CourseName_L2=?, CoursePrice=? where CourseID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setString(1, cs.getCourseName_L1());
            p.setString(2, cs.getCourseName_L2());
            p.setDouble(3, cs.getCoursePrice());
            p.setInt(4, cs.getCourseID());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public void load(DefaultTableModel model) {
        try {
            String query = "Select CourseID, CourseName_L1, CourseName_L2, CoursePrice from tbl_Course";
            ResultSet rs = c.createStatement().executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("CourseID");
                String course_L1 = rs.getString("CourseName_L1");
                String course_L2 = rs.getString("CourseName_L2");
                double price = rs.getDouble("CoursePrice");
                Object[] obj = new Object[]{id, course_L1, course_L2, price};
                model.addRow(obj);
            }
        } catch (SQLException e) {
        }
    }
}
