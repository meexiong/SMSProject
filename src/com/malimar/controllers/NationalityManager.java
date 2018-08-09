
package com.malimar.controllers;

import com.malimar.models.Nationality;
import com.malimar.utils.MsgBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Malimar
 */
public class NationalityManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public boolean insertNationality(Nationality nt){
        try {
            GetMaxID gm = new GetMaxID();
            String insert ="Insert into tbl_Nationality(NTID,NT_Name_L1,NT_Name_L2)values(?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID("tbl_Nationality", "NTID"));
            p.setString(2, nt.getNationalName_L1());
            p.setString(3, nt.getNationalName_L2());
            p.executeUpdate();
            p.close();
            return true;
        } catch (SQLException e) {
            MsgBox.msgWarning();
        }
        return false;
    }
    public boolean updateNationality(Nationality nt){
        try {
            String update ="update tbl_Nationality set NT_Name_L1=?,NT_Name_L2=? where NTID=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setString(1, nt.getNationalName_L1());
            p.setString(2, nt.getNationalName_L2());
            p.setInt(3, nt.getNationalID());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
