/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

/**
 *
 * @author Malimar
 */
public class SchoolInfo {
    int scifo;
    String s_name_l1;
    String s_name_l2;
    String website;
    String phone1;
    String phone2;
    String fax;
    String facebook;
    String s_address;
    String path;
    byte[] S_img;

    public void setS_img(byte[] S_img) {
        this.S_img = S_img;
    }

    public byte[] getS_img() {
        return S_img;
    }

    public void setScifo(int scifo) {
        this.scifo = scifo;
    }

    public void setS_name_l1(String s_name_l1) {
        this.s_name_l1 = s_name_l1;
    }

    public void setS_name_l2(String s_name_l2) {
        this.s_name_l2 = s_name_l2;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getScifo() {
        return scifo;
    }

    public String getS_name_l1() {
        return s_name_l1;
    }

    public String getS_name_l2() {
        return s_name_l2;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getFax() {
        return fax;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getS_address() {
        return s_address;
    }

    public String getPath() {
        return path;
    }
    
}
