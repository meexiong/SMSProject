/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.UserLogin;
import com.malimar.utils.MsgBox;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static net.ucanaccess.converters.Functions.date;

/**
 *
 * @author Malimar
 */
public class UserLoginManager {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql;
    public void showDataUser(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Exec st_userLogin";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("Teid"), rs.getBoolean("userlogin"), rs.getString("temail"), rs.getString("t_nbr"), rs.getString("t_name_l1"), rs.getString("t_name_l2"), rs.getBoolean("teacher")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    } 
    public boolean deleteTbl_user(UserLogin ul){
        try {
            Statement st = null;
            st = c.createStatement();
            sql = "Delete tbl_User where EMP_ID = "+ ul.getTeid() +"";
            st.executeUpdate(sql);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean insertTbl_User(UserLogin ul){
        try {
            deleteTbl_user(ul);
            
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_User (Userid, Emp_ID, UserLogin, User_Pwd, CreateDate, UserLogin_Status) values (?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("Tbl_user", "Userid"));
            p.setInt(2, ul.getTeid());
            p.setString(3, ul.getEmail());
            p.setString(4, "ChangeMe");
            p.setTimestamp(5, date);
            p.setBoolean(6, true);
            p.executeUpdate();
            p.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateTbl_User(UserLogin ul){
        try {
            sql = "Update tbl_user set user_pwd = ?, UserLogin_Status = ? where UserLogin = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, "");
            p.setBoolean(2, false);
            p.setString(3, ul.getEmail());
            p.executeUpdate();
            p.close();
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean upDateUser(UserLogin ul){
        try {       
            if (ul.getUserlogin()==true){
                sql = "Update tbl_teacher set userlogin = ? where teid = (?)"; 
                ul.setUserlogin(true);
            }else{
                sql = "Update tbl_Teacher set userlogin = ? where teid = (?)";
                ul.setUserlogin(false);
            }            
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getUserlogin());
            p.setInt(2, ul.getTeid());
            p.executeUpdate();
            p.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }    
    public void showSearch(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select teid, userlogin, temail, t_nbr, t_name_l1, t_name_l2, teacher from tbl_Teacher "
                    + "where userlogin like N'"+ x +"%' or t_nbr like N'"+ x +"%' or T_Name_L1 like N'"+ x +"%' or t_name_l2 like N'"+ x +"%'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("Teid"), rs.getBoolean("userLogin"), rs.getString("temail"), rs.getString("t_nbr"), rs.getString("t_name_l1"), rs.getString("t_name_l2"), rs.getBoolean("teacher")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showDataGroupUser(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Exec ST_GroupUser";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("GRUID"), rs.getString("Groupname_l1"), rs.getString("groupname_l2"), rs.getBoolean("USed")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
    public boolean insertGroupUser(UserLogin ul){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_groupUser (Gruid, GroupName_l1, GroupName_l2, Used) values (?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_groupUser", "GRUID"));
            p.setString(2, ul.getGroupName_L1());
            p.setString(3, ul.getGroupName_L2());
            p.setBoolean(4, ul.getUsed());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }
    public boolean updateGroupUser(UserLogin ul){
        try {
            sql = "Update tbl_GroupUser set GroupName_L1 = ?, GroupName_L2 = ? where GRUID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, ul.getGroupName_L1().trim());
            p.setString(2, ul.getGroupName_L2().trim());
            p.setInt(3, ul.getGRUID());
            p.executeUpdate();
            p.close();
            MsgBox.msgInfo();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateUsedGroupUser(UserLogin ul){
        try {
            sql = "Update tbl_groupUser set Used = ? where GrUID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getUsed());
            p.setInt(2, ul.getGRUID());
            p.executeUpdate();
            p.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showDataGroupUserPermission(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select slangid, checked, form_name_"+ LabelManager.LangType +" AS formname, Lang_"+ LabelManager.LangType+" AS LangName from vw_SysFormLang order by SLangid";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("slangid"), rs.getBoolean("checked"), rs.getString("formname"), rs.getString("langname")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, Object[]>mapGroup(){
        try {
            HashMap<String, Object[]>mapG= new HashMap();
            sql = "Select gruid, groupName_"+LabelManager.LangType+" AS names from tbl_GroupUser where Used = 1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapG.put(rs.getString("names"), new Object[]{rs.getString("gruid"), rs.getString("names")});
            }
            return mapG;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>mapForm(String x){
        try {
            HashMap<String, Object[]>mapF = new HashMap();
//            sql = "Select formid, Form_name_"+ LangType +" AS formname from tbl_SysForm\n" +
//                    "order by FormID";
            sql = "Select f.formid, f.form_name_"+ LangType +" As formname from tbl_GroupUserLang GL\n" +
                    "left join tbl_SysLang sl on sl.SLANGID = gl.SLANGID\n" +
                    "left join tbl_GroupUser gu on gu.GRUID = gl.GRUID\n" +
                    "left join tbl_SysForm f on f.FormID = sl.FormID\n" +
                    "where gu.GroupName_"+ LangType +" = N'"+ x +"' and not f.FormID is null "
                    + "Group by f.formid, f.form_name_"+ LangType +", gu.groupname_"+ LangType +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapF.put(rs.getString("formname"), new Object[]{rs.getString("formid"), rs.getString("formname")});
            }
            return mapF;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void showCheckGroupUserLang(UserLogin ul){
        try {
            sql = "Select GRUID, SLangid from tbl_GroupUserLang where GRUID = "+ul.getGRUID()+" and Slangid = "+ul.getSLANGID()+"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                
            }else{
                insertGroupUserLang(ul);
            }
            
        } catch (Exception e) {
        }
    }
    public boolean insertGroupUserLang(UserLogin ul){
        try {
            GetMaxID gm = new GetMaxID();
            sql = "Insert into tbl_GroupUserLang (GULID, GRUID, SLANGID, reads, write, denys, createDate) values(?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, gm.getIntID("tbl_GroupUserLang", "GULID"));
            p.setInt(2, ul.getGRUID());
            p.setInt(3, ul.getSLANGID());
            p.setBoolean(4, ul.getReads());
            p.setBoolean(5, ul.getWrite());
            p.setBoolean(6, ul.getDenys());
            p.setDate(7, (Date) ul.getCreateDate());
            p.executeUpdate();
            p.close();            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showClickcbbUserLogin(String cb, JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            //sql = "Select slangid, checked, form_name_"+ LabelManager.LangType +" AS formname, Lang_"+ LabelManager.LangType+" AS LangName from vw_SysFormLang order by SLangid";
//            sql = "Select vw.checked, "
//                    + "vw.form_name_"+ LabelManager.LangType +" AS formname \n" +
//                    "from vw_SysFormLang vw \n" +
//                    "left join tbl_GroupUserLang gl on gl.SLANGID = vw.SLANGID "
//                    + "left join tbl_GroupUser g on g.GRUID = gl.GRUID "
//                    + "where g.GroupName_"+LabelManager.LangType+" = N'"+ cb +"' "
//                    + "group by vw.checked, vw.form_name_"+LabelManager.LangType+", g.groupName_"+LabelManager.LangType+"";
            sql = "Select (Select iif(gl.gulid>0,'true', 'false') from tbl_GroupUserLang gl\n" +
                    "left join tbl_SysLang sl on sl.SLANGID = gl.SLANGID\n" +
                    "left join tbl_SysForm f on f.FormID = sl.FormID\n" +
                    "left join tbl_GroupUser gu on gu.GRUID = gl.GRUID\n" +
                    "where sl.SLANGID = vw.slangid and gu.GRUID = g.GRUID "
                    + "group by gl.gulid "
                    + "having count(gl.gulid) = 1) as checked, "
                    + "vw.form_name_"+ LabelManager.LangType +" AS formname \n" +
                    "from vw_SysFormLang vw \n" +
                    "left join tbl_GroupUserLang gl on gl.SLANGID = vw.SLANGID "
                    + "left join tbl_GroupUser g on g.GRUID = gl.GRUID "
                    + "where g.GroupName_"+LabelManager.LangType+" = N'"+ cb +"'";
            
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                //model.addRow(new Object[]{rs.getString("slangid"), rs.getBoolean("checked"), rs.getString("formname"), rs.getString("langname")});
                model.addRow(new Object[]{rs.getBoolean("checked"), rs.getString("formname")});
                
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSLangID(UserLogin ul, String x){
        try {
            sql = "Select gl.SLangid from tbl_GroupUserLang gl "
                + "left join tbl_GroupUser gr on gr.gruid = gl.gruid "
                    + "left join tbl_SysLang sl on sl.SLANGID = gl.SLANGID\n" +
                    "left join tbl_SysForm fm on fm.FormID = sl.FormID "
                    + "where fm.Form_Name_"+ LabelManager.LangType +"  = N'"+ x +"' and sl.Lables = 1"
                    + " group by gl.SLANGID, fm.Form_Name_"+ LabelManager.LangType +", sl.Lables";
                ResultSet rsc = c.createStatement().executeQuery(sql);
                if (rsc.next()){
                   ul.setSLANGID(rsc.getInt("SLangid"));
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showClickForm(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
//            sql = "Select 'false' AS checked, \n" +
//                    "form_name_"+ LabelManager.LangType+" AS formname\n" +
//                    "from vw_SysFormLang vw \n" +
//                    "left join tbl_GroupUserLang gl on gl.SLANGID = vw.SLANGID\n" +
//                    "left join tbl_GroupUser g on g.GRUID = gl.GRUID \n" +
//                    "group by form_name_"+ LabelManager.LangType+", g.GroupName_"+ LabelManager.LangType+"";
            
               sql = "Select 'false' AS checked, \n" +
                    "form_name_"+ LabelManager.LangType+" AS formname\n" +
                    "from vw_SysFormLang vw \n" +
                    "left join tbl_GroupUserLang gl on gl.SLANGID = vw.SLANGID\n" +
                    "left join tbl_GroupUser g on g.GRUID = gl.GRUID \n" +
                    "group by form_name_"+ LabelManager.LangType+"";
            
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
               model.addRow(new Object[]{rs.getBoolean("checked"), rs.getString("formname")});                
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean updateGroupUsersClickTable(UserLogin ul){
        try {
            sql ="update tbl_groupUserLang set reads = ?, write = ?, denys = ? where Gruid = (?) and Slangid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getReads());
            p.setBoolean(2, ul.getWrite());
            p.setBoolean(3, ul.getDenys());
            p.setInt(4, ul.getGRUID());
            p.setInt(5, ul.getSLANGID());
            p.executeUpdate();
            p.close();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showClickComboGroup(String x, JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select gl.GULID, vw.form_Name_"+ LangType +" As formname, vw.Lang_"+ LangType +" As LangName, gl.reads, gl.write, gl.denys\n" +
                        "from vw_SysFormLang vw \n" +
                        "left join tbl_GroupUserLang gl on gl.SLANGID = vw.SLANGID\n" +
                        "left join tbl_GroupUser g on g.GRUID = gl.GRUID\n" +
                        "where g.GroupName_"+ LangType +" = N'"+ x +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("GULID"), rs.getString("formname"), rs.getString("LangName"), rs.getBoolean("Reads"), rs.getBoolean("write"), rs.getBoolean("denys")});
            }
            table.setModel(model);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showClickComboForm(String groupname, String form, JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select gl.GULID, vw.form_Name_"+ LangType +" As formname, vw.Lang_"+ LangType +" As LangName, gl.reads, gl.write, gl.denys\n" +
                "from vw_SysFormLang vw \n" +
                "left join tbl_GroupUserLang gl on gl.SLANGID = vw.SLANGID\n" +
                "left join tbl_GroupUser g on g.GRUID = gl.GRUID\n" +
                "where g.GroupName_"+ LangType +" = N'"+ groupname +"' and vw.form_name_"+ LangType +" = N'"+ form +"'";            
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("GULID"), rs.getString("formname"), rs.getString("LangName"), rs.getBoolean("Reads"), rs.getBoolean("write"), rs.getBoolean("denys")});
            }
            table.setModel(model);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public boolean checkReads(UserLogin ul){
        try {
            sql = "Update tbl_GroupUserLang set Reads = ? where GULID = (?)";                              
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getReads());
            p.setInt(2, ul.getGULID());
            p.executeUpdate();
            p.close();
            //MsgBox.msgInfo();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkWrite(UserLogin ul){
        try {
            sql = "Update tbl_GroupUserLang set write = ? where GULID = (?)";
               
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getWrite());
            p.setInt(2, ul.getGULID());
            p.executeUpdate();
            p.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkDeny(UserLogin ul){
        try {
            sql = "Update tbl_GroupUserLang set denys = ? where GULID = (?)";
               
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getDenys());
            p.setInt(2, ul.getGULID());
            p.executeUpdate();
            p.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }    
    public void showTeacherUser(JTable table, DefaultTableModel model){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select teid, 'false' AS checked, TEmail, T_Name_"+ LangType+" AS names, Teacher from tbl_teacher where Userlogin = 1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("teid"), rs.getBoolean("checked"), rs.getString("tEmail"), rs.getString("names"), rs.getBoolean("teacher")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean insertGroupAddUser(UserLogin ul, String xComboBox){
        try {
            sql = "Select gul.gulid, reads, write, denys from tbl_GroupUserLang gul\n" +
                "left join tbl_GroupUser gu on gu.GRUID = gul.GRUID\n" +
                "where gu.GroupName_"+LangType+" = N'"+ xComboBox +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                int gulid = rs.getInt("GULID");
                ul.setReads(rs.getBoolean("reads"));
                ul.setWrite(rs.getBoolean("write"));
                ul.setDenys(rs.getBoolean("denys"));
                GetMaxID gm = new GetMaxID();
                sql = "Select TEID, GULID from tbl_GroupUserLangLogin where TEID = "+ ul.getTeid() +" and GULID = "+ gulid +"";
                ResultSet rsc = c.createStatement().executeQuery(sql);
                if (rsc.next()){
                    //JOptionPane.showMessageDialog(null, "Data Have System.");
                }else{
                    
                    
                    sql = "Insert into tbl_GroupUserLangLogin(GULLID, TEID, GULID, CreateDate, reads, write, denys) values (?,?,?,?,?,?,?)";
                    PreparedStatement p = c.prepareStatement(sql);
                    p.setInt(1, gm.getIntID("tbl_GroupUserLangLogin", "GULLID"));
                    p.setInt(2, ul.getTeid());
                    p.setInt(3, gulid);
                    p.setDate(4, (Date) ul.getCreateDate());       
                    p.setBoolean(5, ul.getReads());
                    p.setBoolean(6, ul.getWrite());
                    p.setBoolean(7, ul.getDenys());
                    p.executeUpdate();
                    p.close();  
                }
            }            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public HashMap<String, Object[]>mapUserPermissions(String x){
            try {
                HashMap<String, Object[]>mapUP = new HashMap();
                sql = "Select te.teid, te.T_Name_"+ LangType +" As names from tbl_GroupUserLangLogin gul\n" +
                "left join tbl_GroupUserLang gl on gl.GULID = gul.GULID\n" +
                "left join tbl_GroupUser gu on gu.GRUID = gl.GRUID\n" +
                "left join tbl_Teacher te on te.TEID = gul.TeID\n" +
                "left join tbl_SysLang sl on sl.SLANGID = gl.SLANGID\n" +
                "left join tbl_SysForm f on f.FormID = sl.FormID\n" +
                "where gu.GroupName_"+ LangType +" = N'"+ x +"'\n" +
                "group by te.teid, te.T_Name_"+ LangType +" order by te.t_name_"+ LangType +"";
                ResultSet rs = c.createStatement().executeQuery(sql);
                while (rs.next()){
                    mapUP.put(rs.getString("names"), new Object[]{rs.getInt("teid"), rs.getString("names")});
                }
                return mapUP;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }
    public void showUserPermissionAdd(JTable table, DefaultTableModel model, String teacher, String x){
        try {
            RemoveTableIndex.removeTable(table, model);
            sql = "Select gul.GULLID, f.Form_Name_"+ LangType +" AS form, sl.Lang_"+ LangType +" As langname, gul.reads, gul.write, gul.denys from tbl_GroupUserLangLogin gul\n" +
                    "left join tbl_GroupUserLang gl on gl.GULID = gul.GULID\n" +
                    "left join tbl_GroupUser gu on gu.GRUID = gl.GRUID\n" +
                    "left join tbl_Teacher te on te.TEID = gul.TeID\n" +
                    "left join tbl_SysLang sl on sl.SLANGID = gl.SLANGID\n" +
                    "left join tbl_SysForm f on f.FormID = sl.FormID\n" +
                    "where te.T_Name_"+ LangType +" = N'"+ teacher +"' and gu.GroupName_"+LangType+" = N'"+ x +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("GULLID"), rs.getString("form"), rs.getString("langname"), rs.getBoolean("reads"), rs.getBoolean("write"), rs.getBoolean("denys")});
            }
            table.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public boolean check_Reads_GroupUserLangLogin(UserLogin ul){
        try {            
            sql = "Update tbl_GroupUserLangLogin set reads = ? where GULLID=(?)";      
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getReads());
            p.setInt(2, ul.getGULLID());
            p.executeUpdate();
            p.close();
            return true;  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   public boolean check_Write_GroupUserLangLogin(UserLogin ul){
        try {            
            sql = "Update tbl_GroupUserLangLogin set write = ? where GULLID=(?)";      
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getWrite());
            p.setInt(2, ul.getGULLID());
            p.executeUpdate();
            p.close();
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
   }    
   public boolean check_Denys_GroupUserLangLogin(UserLogin ul){
       try {            
            sql = "Update tbl_GroupUserLangLogin set Denys = ? where GULLID=(?)";      
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, ul.getDenys());
            p.setInt(2, ul.getGULLID());
            p.executeUpdate();
            p.close();
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
   }
}
