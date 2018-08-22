/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import javax.naming.spi.DirStateFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class UserLogin {
    int Teid;
    Boolean userlogin;    
    int GRUID;
    String GroupName_L1;
    String GroupName_L2;
    Boolean Used;
    int SLANGID;
    Date createDate;

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setReads(Boolean reads) {
        this.reads = reads;
    }

    public void setWrite(Boolean write) {
        this.write = write;
    }

    public void setDenys(Boolean denys) {
        this.denys = denys;
    }

    public Boolean getReads() {
        return reads;
    }

    public Boolean getWrite() {
        return write;
    }

    public Boolean getDenys() {
        return denys;
    }
    Boolean reads;
    Boolean write;
    Boolean denys;

    public int getSLANGID() {
        return SLANGID;
    }

    public void setSLANGID(int SLANGID) {
        this.SLANGID = SLANGID;
    }
    

    public void setGRUID(int GRUID) {
        this.GRUID = GRUID;
    }

    public void setGroupName_L1(String GroupName_L1) {
        this.GroupName_L1 = GroupName_L1;
    }

    public void setGroupName_L2(String GroupName_L2) {
        this.GroupName_L2 = GroupName_L2;
    }

    public void setUsed(Boolean Used) {
        this.Used = Used;
    }

    public int getGRUID() {
        return GRUID;
    }

    public String getGroupName_L1() {
        return GroupName_L1;
    }

    public String getGroupName_L2() {
        return GroupName_L2;
    }

    public Boolean getUsed() {
        return Used;
    }
    
    
    

    public void setUserlogin(Boolean userlogin) {
        this.userlogin = userlogin;
    }

    public Boolean getUserlogin() {
        return userlogin;
    }

    public void setTeid(int Teid) {
        this.Teid = Teid;
    }

    public int getTeid() {
        return Teid;
    }
    
    
}
