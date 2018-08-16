/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.TeacherAdd;
import com.malimar.utils.ConvertDateSQL;
import com.malimar.utils.MsgBox;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Malimar
 */
public class TeacherAddManager {

    Connection c = DatabaseManagerSQL.getConnection();
    String sql;

    public HashMap<String, Object[]> getMapGender() {
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "select genid, gen_l1, gen_l2 from tbl_Gender";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("Gen_" + LangType + ""), new Object[]{rs.getString("genid"), rs.getString("gen_l1"), rs.getString("gen_l2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, Object[]> getMapWorkStatus() {
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "Select workid, work_name_l1, work_name_l2 from tbl_WorkStatus";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("Work_Name_" + LangType + ""), new Object[]{rs.getString("workid"), rs.getString("work_name_l1"), rs.getString("work_name_L2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }

    public HashMap<String, Object[]> getMapClassRoom() {
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "select clsid, clrname_l1, clrname_l2 from tbl_class order by clrname_" + LangType + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("clrname_" + LangType + ""), new Object[]{rs.getString("clsid"), rs.getString("clrname_L1"), rs.getString("clrname_l2")});
            }
            rs.close();
            return map;

        } catch (Exception e) {
        }
        return null;
    }

    public HashMap<String, Object[]> getMapNationality() {
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "select ntid, nt_name_l1, nt_name_l2 from tbl_Nationality\n"
                    + "order by ntid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("nt_name_" + LangType + ""), new Object[]{rs.getString("ntid"), rs.getString("nt_name_l1"), rs.getString("nt_name_l2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }

    public HashMap<String, Object[]> getParkSchool() {
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "select psid, psname_l1, psname_l2 from tbl_ParkStudy\n"
                    + "order by psid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("psname_" + LangType + ""), new Object[]{rs.getString("psid"), rs.getString("psname_L1"), rs.getString("Psname_L2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }

    public HashMap<String, Object[]> getMapEthnic() {
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "select etid, et_name_l1, et_name_l2 from tbl_Ethnic\n"
                    + "order by ETID";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("et_name_" + LangType + ""), new Object[]{rs.getString("etid"), rs.getString("et_name_l1"), rs.getString("et_name_l2")});
            }
            rs.close();
            return map;
        } catch (Exception e) {
        }
        return null;
    }

    public HashMap<String, Object[]> getMapRegion() {
        try {
            HashMap<String, Object[]> map = new HashMap();
            sql = "select reid, re_name_l1, re_name_l2 from tbl_Religion\n"
                    + "order by REID";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("Re_name_" + LangType + ""), new Object[]{rs.getString("reid"), rs.getString("re_name_l1"), rs.getString("Re_name_L2")});
            }
            rs.close();
            return map;

        } catch (Exception e) {
        }
        return null;
    }

    public String getPreFix() {
        try {
            String query = "Select SystemValue from tbl_SystemSetting where SSID=2";
            ResultSet rs = c.createStatement().executeQuery(query);
            if (rs.next()) {
                return rs.getString("SystemValue");
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public String getTeacherNumber() {
        try {
            String query = "Select isnull(Max(SubString(T_Nbr,3,9)),0)+1 as MaxID from tbl_Teacher";
            ResultSet rs = c.createStatement().executeQuery(query);
            if (rs.next()) {
                String strMaxID = String.valueOf(rs.getInt("MaxID"));
                return getPreFix() + ("0000000" + strMaxID).substring(strMaxID.length());
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean insertTeacher(TeacherAdd ta) {
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_teacher (Teid, t_nbr, T_name_L1, T_Name_L2, T_dob, Genid, workid, tphone1, tphone2, temail, clsid, "
                    + "ntid, etid, reid, psid, t_address, T_working, t_dailyteach, t_Startdate, T_moreinfo, t_enddate, T_img) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_teacher", "teid"));
            p.setString(2, getTeacherNumber());
            p.setString(3, ta.getTname_l1());
            p.setString(4, ta.getTname_l2());
            p.setDate(5, (Date) ta.getDob());
            p.setInt(6, ta.getGenid());
            p.setInt(7, ta.getWorkid());
            p.setString(8, ta.gettPhone1());
            p.setString(9, ta.gettPhone2());
            p.setString(10, ta.gettEmail());
            p.setInt(11, ta.getCLSID());
            p.setInt(12, ta.getNtid());
            p.setInt(13, ta.getEtid());
            p.setInt(14, ta.getReid());
            p.setInt(15, ta.getPSID());
            p.setString(16, ta.getT_address());
            p.setBoolean(17, ta.gettWorking());
            p.setBoolean(18, ta.gettDailyTeach());
            p.setDate(19, (Date) ta.getT_Startdate());
            p.setDate(20, (Date) ta.getT_EndDate());
            p.setString(21, ta.getT_moreinfo());
            
            if (ta.getPath() != null) {
                File ff = new File(ta.getPath());
                FileInputStream fis = new FileInputStream(ff);
                int len = (int) ff.length();
                p.setBinaryStream(22, fis, len);
            } else {
                p.setNull(22, java.sql.Types.BLOB);
            }
            
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
