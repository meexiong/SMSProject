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
import com.malimar.utils.RemoveTableIndex;
import com.malimar.views.FrmTeacherAdd;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class TeacherAddManager {

    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    
    public static int clickteid=0;
    

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
            DecimalFormat df = new DecimalFormat("###");
            
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_teacher (Teid, t_nbr, T_name_L1, T_Name_L2, T_dob, Genid, workid, tphone1, tphone2, temail, clsid, "
                    + "ntid, etid, reid, T_Salary, t_address, T_working, t_dailyteach, t_Startdate, T_moreinfo, t_enddate, Teacher, T_img) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            p.setFloat(15, ta.getSalary());            
            p.setString(16, ta.getT_address());
            p.setBoolean(17, ta.gettWorking());
            p.setBoolean(18, ta.gettDailyTeach());            
            p.setDate(19, (Date) ta.getT_Startdate());
            p.setString(20, ta.getT_moreinfo());            
            p.setDate(21, (Date) ta.getT_EndDate());     
            p.setBoolean(22, ta.getTeacher());
           
            if (ta.getPath() != null) {
                File ff = new File(ta.getPath());
                FileInputStream fis = new FileInputStream(ff);
                int len = (int) ff.length();
                p.setBinaryStream(23, fis, len);
            } else {
                p.setNull(23, java.sql.Types.BLOB);
            }
            
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;

        } catch (Exception e) {
           // e.printStackTrace();
            MsgBox.msgWarning();
        }
        return false;
    }
    public boolean updateTeacherAdd(TeacherAdd ta){
        try {
            DecimalFormat df = new DecimalFormat("###");
            
            sql = "Update tbl_teacher set T_name_L1=?, T_Name_L2=?, T_dob=?, Genid=?, workid=?, tphone1=?, tphone2=?, temail=?, clsid=?, "
                    + "ntid=?, etid=?, reid=?, T_Salary=?, t_address=?, T_working=?, t_dailyteach=?, t_Startdate=?, T_moreinfo=?, t_enddate=?, Teacher = ? where TeID= (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, ta.getTname_l1());
            p.setString(2, ta.getTname_l2());
            p.setDate(3, (Date) ta.getDob());
            p.setInt(4, ta.getGenid());
            p.setInt(5, ta.getWorkid());
            p.setString(6, ta.gettPhone1());
            p.setString(7, ta.gettPhone2());
            p.setString(8, ta.gettEmail());
            p.setInt(9, ta.getCLSID());
            p.setInt(10, ta.getNtid());
            p.setInt(11, ta.getEtid());
            p.setInt(12, ta.getReid());
        
            p.setFloat(13, ta.getSalary());
            
            p.setString(14, ta.getT_address());
            p.setBoolean(15, ta.gettWorking());
            p.setBoolean(16, ta.gettDailyTeach());            
            p.setDate(17, (Date) ta.getT_Startdate());
            p.setString(18, ta.getT_moreinfo());            
            p.setDate(19, (Date) ta.getT_EndDate());                
            p.setBoolean(20, ta.getTeacher());
            p.setInt(21, ta.getTeid());
            
            p.executeUpdate();
            p.close();            
            MsgBox.msgInfo();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            MsgBox.msgWarning();
        }
        return false;
    }
    public boolean updateImageTeacherAdd(TeacherAdd ta){
        try {
            sql = "Update tbl_Teacher set T_img=? where Teid = (?)";
            PreparedStatement p =c.prepareStatement(sql);
            if (ta.getPath() != null) {
                File ff = new File(ta.getPath());
                FileInputStream fis = new FileInputStream(ff);
                int len = (int) ff.length();
                p.setBinaryStream(1, fis, len);
            } else {
                p.setNull(1, java.sql.Types.BLOB);
            }
            p.setInt(2, ta.getTeid());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public void showOpenClickTable(TeacherAdd tas, int x){
        try {
            sql = "select t.teid, t.t_nbr, t.t_name_l1, t.t_name_l2, t.t_dob, g.gen_"+ LangType +" AS gender, t.tphone1, t.tphone2, t.temail, cl.clrname_"+ LangType +" AS classRoom, "
                    + "n.nt_name_"+ LangType +" AS nationality, r.re_name_"+ LangType +" AS religionname,\n" +
                    "e.et_name_"+ LangType +" AS ethnicname, t.t_startDate, t.t_endDate, t.t_moreinfo, t.T_Working, t.T_img, t.genid, t.workid, t.clsid, t.t_address, t.t_dailyteach, "
                    + "t.ntid, t.etid, t.reid, t.psid, w.Work_Name_"+ LangType +" AS workname, isnull(t.T_Salary, 0) as salary, t.teacher \n" +
                    "from tbl_Teacher t \n" +
                    "left join tbl_Gender g on g.Genid = t.genid\n" +
                    "left join tbl_Nationality n on n.NTID = t.Ntid\n" +
                    "left join tbl_Ethnic e on e.ETID = t.etid\n" +
                    "left join tbl_religion r on r.reid = t.reid\n" +
                    "left join tbl_Class cl on cl.CLID = t.CLSID\n" +
                    "left join tbl_ClassLevel cs on cs.CLID = cl.CLID "
                    + "left join tbl_workstatus w on w.workid = t.workid where t.teid = "+ x +" "
                    + "group by t.teid, t.t_nbr, t.t_name_l1, t.t_name_l2, t.t_dob, g.gen_"+ LangType +", t.tphone1, t.tphone2, t.temail, cl.clrname_"+ LangType +", "
                    + "n.nt_name_"+ LangType +", r.re_name_"+ LangType +",\n" +
                    "e.et_name_"+ LangType +", t.t_startDate, t.t_endDate, t.t_moreinfo, t.T_Working, t.T_img, t.genid, t.workid, t.clsid, t.t_address, t.t_dailyteach, "
                    + "t.ntid, t.etid, t.reid, t.psid, w.Work_Name_"+ LangType +", isnull(t.T_Salary, 0), t.teacher";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){                
                tas.setT_nbr(rs.getString("t_nbr"));
                tas.setTname_l1(rs.getString("t_name_l1"));
                tas.setTname_l2(rs.getString("T_name_l2"));
                tas.setDob(rs.getDate("T_DOB"));
                tas.setGenid(rs.getInt("genid"));
                tas.setWorkid(rs.getInt("Workid"));
                tas.settPhone1(rs.getString("tphone1"));
                tas.settPhone2(rs.getString("tPhone2"));
                tas.settEmail(rs.getString("temail"));
                tas.setCLSID(rs.getInt("clsid"));
                tas.setNtid(rs.getInt("ntid"));
                tas.setEtid(rs.getInt("etid"));
                tas.setReid(rs.getInt("reid"));
                tas.setPSID(rs.getInt("PSID"));
                tas.setT_address(rs.getString("t_address"));
                tas.settWorking(rs.getBoolean("t_working"));
                tas.settDailyTeach(rs.getBoolean("t_dailyteach"));
                tas.setT_Startdate(rs.getDate("t_startdate"));
                tas.setT_EndDate(rs.getDate("t_endDate"));
                tas.setT_moreinfo(rs.getString("t_moreinfo")); 
                tas.setImageB(rs.getBytes("T_img"));
                
                tas.setGendername(rs.getString("gender"));
                tas.setClassroom(rs.getString("classRoom"));
                tas.setNationalityname(rs.getString("nationality"));
                tas.setRename(rs.getString("religionname"));
                tas.setEthnicname(rs.getString("ethnicname"));
                tas.setSalary(rs.getFloat("salary"));
                tas.setWorkingname(rs.getString("workname"));
                tas.setTeacher(rs.getBoolean("Teacher"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void showDatas(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "select teid, t_nbr, t_name_"+ LangType +" AS tname, dob, gen_"+ LangType +" AS gender, tphone1, tphone2, temail, clname_"+ LangType +" AS classlevel, nt_name_"+ LangType +" AS nationality, "
                    + "re_name_"+ LangType +" AS religion, et_name_"+ LangType +" AS ethnic, startdate, enddate, t_moreinfo\n" +
                    "from vw_TeacherDetails where T_Working = 1 and enddate is null\n" +
                    "order by T_Nbr";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("teid"), rs.getString("t_nbr"), rs.getString("tname"), rs.getString("dob"), rs.getString("gender"), rs.getString("tphone1"), rs.getString("tPhone2"), rs.getString("temail"), rs.getString("classlevel"), rs.getString("nationality"), 
                rs.getString("religion"), rs.getString("ethnic"), rs.getString("startDate"), rs.getString("enddate"), rs.getString("t_moreinfo")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showSearchData(JTable table, DefaultTableModel model, String txt){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "select teid, t_nbr, t_name_"+ LangType +" AS tname, dob, gen_"+ LangType +" AS gender, tphone1, tphone2, temail, clname_"+ LangType +" AS classlevel, nt_name_"+ LangType +" AS nationality, "
                    + "re_name_"+ LangType +" AS religion, et_name_"+ LangType +" AS ethnic, startdate, enddate, t_moreinfo\n" +
                    "from vw_TeacherDetails where t_nbr like N'"+ txt +"%' or t_name_L1 like N'"+ txt +"%' or t_name_L2 like N'"+ txt +"%' or "
                    + "tphone1 like N'"+ txt +"%' or tphone2 like N'"+ txt +"%' or temail like N'"+ txt +"%' or t_moreinfo like N'"+ txt +"%'\n" +
                    "order by T_Nbr";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("teid"), rs.getString("t_nbr"), rs.getString("tname"), rs.getString("dob"), rs.getString("gender"), rs.getString("tphone1"), rs.getString("tPhone2"), rs.getString("temail"), rs.getString("classlevel"), rs.getString("nationality"), 
                rs.getString("religion"), rs.getString("ethnic"), rs.getString("startDate"), rs.getString("enddate"), rs.getString("t_moreinfo")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showT_Nbr(TeacherAdd ta, String namel1){
        try {
            sql = "Select t_nbr from tbl_Teacher where T_Name_L1 = N'"+ namel1 +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                ta.setT_nbr(rs.getString("t_nbr"));
            }
        } catch (Exception e) {
        }
    }
    
}
