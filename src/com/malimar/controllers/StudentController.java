/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.Student;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class StudentController {
    Connection c = DatabaseManagerSQL.getConnection();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public int getStudenNumber(){
        try {
            
        } catch (Exception e) {
        }
        return 0;
    }
    public boolean insertStudent(Student sd){
        try {
            GetMaxID gm = new GetMaxID();
            String insert = "Insert into tbl_Student(StdID,StdNbr,STypeID,StdName_L1,StdName_L2,Genid,StdPhone1,StdPhone2,StdEmail,StdDOB,StdStartDate,StdEndDate,NTID,ETID,REID,StdStudying,StdBlood,StdWeight,"
                    + "StdHeight,Congenital_diseases,Congenital_diseases_Info,SchoolName,School_Levels,School_Mobile,stdNote,PSID,Stdimg) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(insert);
            p.setInt(1, gm.getIntID("tbl_Student", "StdID"));
            p.setString(2, sd.getStdNbr());
            p.setInt(3, sd.getStdType());
            p.setString(4, sd.getStdName_L1());
            p.setString(5, sd.getStdName_L2());
            p.setInt(6, sd.getGendID());
            p.setString(7, sd.getStdPhone1());
            p.setString(8, sd.getStdPhone2());
            p.setString(9, sd.getStdEmail());
            p.setString(10, df.format(sd.getStdDOB()));
            p.setString(11, df.format(sd.getStdStartDate()));
            p.setString(12, df.format(sd.getStdEndDate()));
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
        } catch (Exception e) {
        }
        return false;
    }
}
