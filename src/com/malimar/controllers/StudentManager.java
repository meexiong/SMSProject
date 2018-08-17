/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import static com.malimar.controllers.LabelManager.LangType;
import com.malimar.models.Student;
import com.malimar.utils.ClearTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class StudentManager {
    Connection c = DatabaseManagerSQL.getConnection();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public String getPreFix(){
        try {
            String query = "Select SystemValue from tbl_SystemSetting where SSID=1";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                return rs.getString("SystemValue");
            }
        } catch (SQLException e) {
        }
        return null;
    }
    public String getStudenNumber(){
        try {
            String query = "Select isnull(Max(SubString(StdNbr,3,9)),0)+1 as MaxID from tbl_Student";
            ResultSet rs = c.createStatement().executeQuery(query);
            if(rs.next()){
                String strMaxID = String.valueOf(rs.getInt("MaxID"));
                return getPreFix()+("0000000"+strMaxID).substring(strMaxID.length());
            }
        } catch (SQLException e) {
        }
        return null;
    }
    public boolean insertStudent(Student sd){
        try {
            GetMaxID gm = new GetMaxID();
            String insert = "Insert into tbl_Student(StdID,StdNbr,STypeID,StdName_L1,StdName_L2,Genid,StdPhone1,StdPhone2,StdEmail,StdDOB,StdStartDate,StdEndDate,NTID,ETID,REID,StdStudying,StdBlood,StdWeight,"
                    + "StdHeight,Congenital_diseases,Congenital_diseases_Info,SchoolName,School_Levels,School_Mobile,stdNote,PSID,Stdimg) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID("tbl_Student", "StdID"));
            p.setString(2, getStudenNumber());
            p.setInt(3, sd.getStdType());
            p.setString(4, sd.getStdName_L1());
            p.setString(5, sd.getStdName_L2());
            p.setInt(6, sd.getGendID());
            p.setString(7, sd.getStdPhone1());
            p.setString(8, sd.getStdPhone2());
            p.setString(9, sd.getStdEmail());
            p.setString(10, df.format(sd.getStdDOB()));
            p.setString(11, df.format(sd.getStdStartDate()));
            if(sd.getStdEndDate()==null){
                p.setNull(12, java.sql.Types.DATE);
            }else{
                p.setString(12, df.format(sd.getStdEndDate()));
            }
            p.setInt(13, sd.getStdNationlity());
            p.setInt(14, sd.getStdEthnic());
            p.setInt(15, sd.getStdReligion());
            p.setBoolean(16, sd.isStdStudying());
            p.setString(17, sd.getBlood());
            p.setFloat(18, sd.getStdWeight());
            p.setFloat(19, sd.getStdHeight());
            p.setBoolean(20, sd.isStdCongenialDisease());
            p.setString(21, sd.getStdCongenialDiseaseInfo());
            p.setString(22, sd.getStdSchoolName());
            p.setString(23, sd.getStdSchoolLevel());
            p.setString(24, sd.getStdSchoolMobile());
            p.setString(25, sd.getStdNote());
            p.setInt(26, sd.getStdPark());
            if(sd.getPath() != null){
                    File ff = new File(sd.getPath());
                    FileInputStream fis = new FileInputStream(ff);
                    int len = (int)ff.length();
                    p.setBinaryStream(27, fis, len);
                }else{
                    p.setNull(27, java.sql.Types.BLOB);
                }
            return p.executeUpdate()==1;
        } catch (FileNotFoundException | SQLException e) {
        }
        return false;
    }
    public boolean updateStudent(Student sd){
        try {
            String update = "Update tbl_Student set STypeID=?,StdName_L1=?,StdName_L2=?,Genid=?,StdPhone1=?,StdPhone2=?,StdEmail=?,StdDOB=?,StdStartDate=?,StdEndDate=?,"
                    + "NTID=?,ETID=?,REID=?,StdStudying=?,StdBlood=?,StdWeight=?,StdHeight=?,Congenital_diseases=?,Congenital_diseases_Info=?,SchoolName=?,School_Levels=?,"
                    + "School_Mobile=?,stdNote=?,PSID=? where StdNbr=?";
            PreparedStatement p = c.prepareStatement(update);
            p.setInt(1, sd.getStdType());
            p.setString(2, sd.getStdName_L1());
            p.setString(3, sd.getStdName_L2());
            p.setInt(4, sd.getGendID());
            p.setString(5, sd.getStdPhone1());
            p.setString(6, sd.getStdPhone2());
            p.setString(7, sd.getStdEmail());
            p.setString(8, df.format(sd.getStdDOB()));
            p.setString(9, df.format(sd.getStdStartDate()));
            if(sd.getStdEndDate()==null){
                p.setNull(10, java.sql.Types.DATE);
            }else{
                 p.setString(10, df.format(sd.getStdEndDate()));
            }
            p.setInt(11, sd.getStdNationlity());
            p.setInt(12, sd.getStdEthnic());
            p.setInt(13, sd.getStdReligion());
            p.setBoolean(14, sd.isStdStudying());
            p.setString(15, sd.getBlood());
            p.setFloat(16, sd.getStdWeight());
            p.setFloat(17, sd.getStdHeight());
            p.setBoolean(18, sd.isStdCongenialDisease());
            p.setString(19, sd.getStdCongenialDiseaseInfo());
            p.setString(20, sd.getStdSchoolName());
            p.setString(21, sd.getStdSchoolLevel());
            p.setString(22, sd.getStdSchoolMobile());
            p.setString(23, sd.getStdNote());
            p.setInt(24, sd.getStdPark());
            p.setString(25, sd.getStdNbr());
            return p.executeUpdate()==1;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean updateStudentPicture(Student sd){
        try {
            String update = "Update tbl_Student set Stdimg=? where StdNbr=?";
            PreparedStatement p = c.prepareStatement(update);
            File ff = new File(sd.getPath());
            FileInputStream fis = new FileInputStream(ff);
            int len = (int) ff.length();
            p.setBinaryStream(1, fis, len);
            p.setString(2, sd.getStdNbr());
            return p.executeUpdate()==1;
        } catch (FileNotFoundException | SQLException e) {
        }
        return false;
    }
    public HashMap<String,Object[]>GenderComboBox(){
        HashMap<String,Object[]> map = new HashMap<>();
        Statement st;
        ResultSet rs;
        String sql;
        try {
            sql="Select Genid, Gen_L1,Gen_L2 from tbl_Gender";
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                map.put(rs.getString("Gen_"+LangType+""), new Object[]{rs.getInt("Genid"), rs.getString("Gen_L1"), rs.getString("Gen_L2")});
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return map;
    }
    public HashMap<String,Object[]>StudentTypeComboBox(){
        HashMap<String,Object[]> map = new HashMap<>();
        Statement st;
        ResultSet rs;
        String sql;
        try {
            sql="Select STYCID, STName_L1,STName_L2 from tbl_StudentType";
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                map.put(rs.getString("STName_"+LangType+""), new Object[]{rs.getInt("STYCID"), rs.getString("STName_L1"), rs.getString("STName_L2")});
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return map;
    }
    public HashMap<String,Object[]>NationalityComboBox(){
        HashMap<String,Object[]> map = new HashMap<>();
        Statement st;
        ResultSet rs;
        String sql;
        try {
            sql="Select NTID, NT_Name_L1,NT_Name_L2 from tbl_Nationality";
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                map.put(rs.getString("NT_Name_"+LangType+""), new Object[]{rs.getInt("NTID"), rs.getString("NT_Name_L1"), rs.getString("NT_Name_L2")});
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return map;
    }
    public HashMap<String,Object[]>EthnicComboBox(){
        HashMap<String,Object[]> map = new HashMap<>();
        Statement st;
        ResultSet rs;
        String sql;
        try {
            sql="Select ETID, ET_Name_L1,ET_Name_L2 from tbl_Ethnic";
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                map.put(rs.getString("ET_Name_"+LangType+""), new Object[]{rs.getInt("ETID"), rs.getString("ET_Name_L1"), rs.getString("ET_Name_L2")});
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return map;
    }
    public HashMap<String,Object[]>ReligionComboBox(){
        HashMap<String,Object[]> map = new HashMap<>();
        Statement st;
        ResultSet rs;
        String sql;
        try {
            sql="Select REID, RE_Name_L1,RE_Name_L2 from tbl_Religion";
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                map.put(rs.getString("RE_Name_"+LangType+""), new Object[]{rs.getInt("REID"), rs.getString("RE_Name_L1"), rs.getString("RE_Name_L2")});
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return map;
    }
    public HashMap<String,Object[]>StudentParkComboBox(){
        HashMap<String,Object[]> map = new HashMap<>();
        Statement st;
        ResultSet rs;
        String sql;
        try {
            sql="Select PSID, PSName_L1,PSName_L2 from tbl_ParkStudy";
            st=c.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                map.put(rs.getString("PSName_"+LangType+""), new Object[]{rs.getInt("PSID"), rs.getString("PSName_L1"), rs.getString("PSName_L2")});
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return map;
    }
    public void Load(DefaultTableModel model){
        try {
            String query = "Exec pd_StudentInfo";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("StdID");
                String nbr = rs.getString("StdNbr");
                String name = rs.getString("StdName_"+LangType+"");
                String sex = rs.getString("Gen_"+LangType+"");
                String dob = rs.getString("DOB");
                String start = rs.getString("StartDate");
                String end = rs.getString("EndDate");
                String phone = rs.getString("StdPhone1");
                String email =  rs.getString("StdEmail");
                String religion = rs.getString("RE_Name_"+LangType+"");
                String ethnic = rs.getString("ET_Name_"+LangType+"");
                String national = rs.getString("NT_Name_"+LangType+"");
                Object[] obj = new Object[]{id,nbr,name,sex,dob,start,end,phone,email,religion,ethnic,national};
                model.addRow(obj);
            }
        } catch (SQLException e) {
        }
    }
    public void LoadEdit(Student sd){
        try {
            String query = "Exec pd_StudentInfoByNbr '"+sd.getStdNbr()+"'";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                sd.setStdName_L1(rs.getString("StdName_L1"));
                sd.setStdName_L2(rs.getString("StdName_L2"));
                sd.setGenderName(rs.getString("Gen_"+LangType+""));
                sd.setStdTypeName(rs.getString("STName_"+LangType+""));
                sd.setStdPhone1(rs.getString("StdPhone1"));
                sd.setStdPhone2(rs.getString("StdPhone2"));
                sd.setStdEmail(rs.getString("StdEmail"));
                sd.setStdDOB(rs.getDate("StdDOB"));
                sd.setStdStartDate(rs.getDate("StdStartDate"));
                sd.setStdEndDate(rs.getDate("StdEndDate"));
                sd.setStdNationalName(rs.getString("NT_Name_"+LangType+""));
                sd.setStdEthnicName(rs.getString("ET_Name_"+LangType+""));
                sd.setStdReligionName(rs.getString("RE_Name_"+LangType+""));
                sd.setStdStudying(rs.getBoolean("StdStudying"));
                sd.setBlood(rs.getString("StdBlood"));
                sd.setStdParkName(rs.getString("PSName_"+LangType+""));
                sd.setStdWeight(rs.getFloat("StdWeight"));
                sd.setStdHeight(rs.getFloat("StdHeight"));
                sd.setStdCongenialDisease(rs.getBoolean("Congenital_diseases"));
                sd.setStdCongenialDiseaseInfo(rs.getString("Congenital_diseases_Info"));
                sd.setStdSchoolName(rs.getString("SchoolName"));
                sd.setStdSchoolLevel(rs.getString("School_Levels"));
                sd.setStdSchoolMobile(rs.getString("School_Mobile"));
                sd.setStdNote(rs.getString("stdNote"));
                sd.setPicture(rs.getBytes("Stdimg"));
            }
        } catch (SQLException e) {
        }
    }
    public void Search(DefaultTableModel model, String txt){
        try {
            String query = "Exec pd_StudentInfoByConditionals N'"+txt+"'";
            ResultSet rs = c.createStatement().executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("StdID");
                String nbr = rs.getString("StdNbr");
                String name = rs.getString("StdName_"+LangType+"");
                String sex = rs.getString("Gen_"+LangType+"");
                String dob = rs.getString("DOB");
                String start = rs.getString("StartDate");
                String end = rs.getString("EndDate");
                String phone = rs.getString("StdPhone1");
                String email =  rs.getString("StdEmail");
                String religion = rs.getString("RE_Name_"+LangType+"");
                String ethnic = rs.getString("ET_Name_"+LangType+"");
                String national = rs.getString("NT_Name_"+LangType+"");
                Object[] obj = new Object[]{id,nbr,name,sex,dob,start,end,phone,email,religion,ethnic,national};
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
