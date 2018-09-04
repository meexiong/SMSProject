/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Relationship;
import com.malimar.utils.MsgBox;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class RelationshipManager {    
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;   
    
    public void showData(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select * from tbl_Relationship order by RLTID";
            ResultSet rs= c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("RLTID"), rs.getString("Relation_L1"), rs.getString("Relation_L2")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean insertRelationship(Relationship rsp){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_Relationship (RLTID, Relation_L1, Relation_L2) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_Relationship", "RLTID"));
            p.setString(2, rsp.getRelationship_L1());
            p.setString(3, rsp.getRelationship_L2());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateRelationship(Relationship rsp){
        try {
            sql = "Update tbl_relationship set Relation_L1 = ?, Relation_L2 = ? where RLTID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, rsp.getRelationship_L1());
            p.setString(2, rsp.getRelationship_L2());
            p.setInt(3, rsp.getId());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public HashMap<String, Object>mapStudent(){
        try {
            HashMap<String, Object>mapSt = new HashMap();
            sql = "Select st.stdid, st.StdNbr+' '+st.StdName_"+ LabelManager.LangType +"+' ('+ g.Gen_"+ LabelManager.LangType +"+')' AS names, st.StdName_L1, st.StdName_L2 from tbl_Student st\n" +
                "left join tbl_Gender g on g.Genid = st.Genid\n" +
                "where st.StdEndDate is null and st.StdStudying = 'true'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapSt.put(rs.getString("names"), new Object[]{rs.getString("stdid"), rs.getString("stdname_L1"), rs.getString("stdname_L2")});
            }
            rs.close();
            return mapSt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void showGuardian(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select gu.Gudid, 'false' as checked, gu.gud_email, gu.Gud_name_"+ LabelManager.LangType+" AS gudname, g.gen_"+ LabelManager.LangType+" AS gender, "
                    + "gu.gud_phone1, gu.gud_phone2, gu.GUD_Work, gu.GUD_Address_L1, gu.GUD_Address_L2\n" +
                "from tbl_Guardian gu\n" +
                "left join tbl_Gender g on g.Genid = gu.Genid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("gudid"), rs.getBoolean("checked"), rs.getString("gud_email"), rs.getString("gudname"), rs.getString("gender"), rs.getString("gud_phone1"), 
                rs.getString("gud_phone2"), rs.getString("gud_work"), rs.getString("GUD_Address_L1"), rs.getString("GUD_Address_L2")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
