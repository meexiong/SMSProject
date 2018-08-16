/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

import java.awt.Image;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Malimar
 */
public class TeacherAdd {
    int teid;
    String tname_l1;
    String tname_l2;
    Date dob;
    int genid;
    int workid;
    String tPhone1;
    String tPhone2;
    String tEmail;
    int CLSID;       
    int ntid;
    int etid;
    int reid;
    int PSID;
    String t_address;
    Boolean tWorking;
    Boolean tDailyTeach;
    Date t_Startdate;
    Date t_EndDate;
    String t_moreinfo;
    String path;
    String t_nbr;
    Image img;
    public byte[] imageB;

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public String getT_nbr() {
        return t_nbr;
    }

    public void setT_nbr(String t_nbr) {
        this.t_nbr = t_nbr;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setTeid(int teid) {
        this.teid = teid;
    }

    public void setTname_l1(String tname_l1) {
        this.tname_l1 = tname_l1;
    }

    public void setTname_l2(String tname_l2) {
        this.tname_l2 = tname_l2;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setGenid(int genid) {
        this.genid = genid;
    }

    public void setWorkid(int workid) {
        this.workid = workid;
    }

    public void settPhone1(String tPhone1) {
        this.tPhone1 = tPhone1;
    }

    public void settPhone2(String tPhone2) {
        this.tPhone2 = tPhone2;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    public void setCLSID(int CLSID) {
        this.CLSID = CLSID;
    }

    public void setNtid(int ntid) {
        this.ntid = ntid;
    }

    public void setEtid(int etid) {
        this.etid = etid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public void setPSID(int PSID) {
        this.PSID = PSID;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public void settWorking(Boolean tWorking) {
        this.tWorking = tWorking;
    }

    public void settDailyTeach(Boolean tDailyTeach) {
        this.tDailyTeach = tDailyTeach;
    }

    public void setT_Startdate(Date t_Startdate) {
        this.t_Startdate = t_Startdate;
    }

    public void setT_EndDate(Date t_EndDate) {
        this.t_EndDate = t_EndDate;
    }

    public void setT_moreinfo(String t_moreinfo) {
        this.t_moreinfo = t_moreinfo;
    }

    public int getTeid() {
        return teid;
    }

    public String getTname_l1() {
        return tname_l1;
    }

    public String getTname_l2() {
        return tname_l2;
    }

    public Date getDob() {
        return dob;
    }

    public int getGenid() {
        return genid;
    }

    public int getWorkid() {
        return workid;
    }

    public String gettPhone1() {
        return tPhone1;
    }

    public String gettPhone2() {
        return tPhone2;
    }

    public String gettEmail() {
        return tEmail;
    }

    public int getCLSID() {
        return CLSID;
    }


    public int getNtid() {
        return ntid;
    }

    public int getEtid() {
        return etid;
    }

    public int getReid() {
        return reid;
    }

    public int getPSID() {
        return PSID;
    }

    public String getT_address() {
        return t_address;
    }

    public Boolean gettWorking() {
        return tWorking;
    }

    public Boolean gettDailyTeach() {
        return tDailyTeach;
    }

    public Date getT_Startdate() {
        return t_Startdate;
    }

    public Date getT_EndDate() {
        return t_EndDate;
    }

    public String getT_moreinfo() {
        return t_moreinfo;
    }
    
}
