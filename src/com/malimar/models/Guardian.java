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
public class Guardian {
    int id;
    String GuardianL1;
    String GuardianL2;
    int Genid;
    String Email;
    String Phone1;
    String Phone2;
    String Address;
    String Moreinfo;
    String Gud_Work;
    String genderName;

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getGenderName() {
        return genderName;
    }
    

    public String getGud_Work() {
        return Gud_Work;
    }

    public void setGud_Work(String Gud_Work) {
        this.Gud_Work = Gud_Work;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGuardianL1(String GuardianL1) {
        this.GuardianL1 = GuardianL1;
    }

    public void setGuardianL2(String GuardianL2) {
        this.GuardianL2 = GuardianL2;
    }

    public void setGenid(int Genid) {
        this.Genid = Genid;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone1(String Phone1) {
        this.Phone1 = Phone1;
    }

    public void setPhone2(String Phone2) {
        this.Phone2 = Phone2;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setMoreinfo(String Moreinfo) {
        this.Moreinfo = Moreinfo;
    }

    public int getId() {
        return id;
    }

    public String getGuardianL1() {
        return GuardianL1;
    }

    public String getGuardianL2() {
        return GuardianL2;
    }

    public int getGenid() {
        return Genid;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone1() {
        return Phone1;
    }

    public String getPhone2() {
        return Phone2;
    }

    public String getAddress() {
        return Address;
    }

    public String getMoreinfo() {
        return Moreinfo;
    }
    
    
}
