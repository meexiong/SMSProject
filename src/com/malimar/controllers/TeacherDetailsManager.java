/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class TeacherDetailsManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public void showData(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "select teid, t_nbr, t_name_"+ LangType +" AS tname, dob, gen_"+ LangType +" AS gender, tphone1, tphone2, temail, clname_"+ LangType +" AS classlevel, nt_name_"+ LangType +" AS nationality, "
                    + "re_name_"+ LangType +" AS religion, et_name_"+ LangType +" AS ethnic, startdate, enddate, t_moreinfo\n" +
                    "from vw_TeacherDetails\n" +
                    "order by T_Nbr";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("teid"), rs.getString("tname"), rs.getString("gender"), rs.getString("tphone1"), rs.getString("tPhone2"), rs.getString("temail"), rs.getString("classlevel"), rs.getString("nationality"), 
                rs.getString("religion"), rs.getString("ethnic"), rs.getString("startDate"), rs.getString("enddate"), rs.getString("t_moreinfo")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
