
package com.malimar.models;

import java.util.Date;

public class Student {
    int stdID;
    String stdNbr;
    int stdType;
    String stdTypeName;
    String stdName_L1;
    String stdName_L2;
    int gendID;
    String genderName;
    String stdPhone1;
    String stdPhone2;
    String stdEmail;
    Date stdDOB;
    Date stdStartDate;
    Date stdEndDate;
    int stdNationlity;
    String stdNationalName;
    int stdEthnic;
    String stdEthnicName;
    int stdReligion;
    String stdReligionName;
    boolean stdStudying;
    String Blood;
    float stdWeight;
    float stdHeight;
    boolean stdCongenialDisease;
    String stdCongenialDiseaseInfo;
    String stdSchoolName;
    String stdSchoolLevel;
    String stdSchoolMobile;
    String stdNote;
    int stdPark;
    String stdParkName;
    String path;
    byte[] picture;    
       
    public Student(){
        
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    public void setStdID(int stdID) {
        this.stdID = stdID;
    }

    public void setStdNbr(String stdNbr) {
        this.stdNbr = stdNbr;
    }

    public void setStdType(int stdType) {
        this.stdType = stdType;
    }

    public void setStdTypeName(String stdTypeName) {
        this.stdTypeName = stdTypeName;
    }

    public void setStdName_L1(String stdName_L1) {
        this.stdName_L1 = stdName_L1;
    }

    public void setStdName_L2(String stdName_L2) {
        this.stdName_L2 = stdName_L2;
    }

    public void setGendID(int gendID) {
        this.gendID = gendID;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public void setStdPhone1(String stdPhone1) {
        this.stdPhone1 = stdPhone1;
    }

    public void setStdPhone2(String stdPhone2) {
        this.stdPhone2 = stdPhone2;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    public void setStdDOB(Date stdDOB) {
        this.stdDOB = stdDOB;
    }

    public void setStdStartDate(Date stdStartDate) {
        this.stdStartDate = stdStartDate;
    }

    public void setStdEndDate(Date stdEndDate) {
        this.stdEndDate = stdEndDate;
    }

    public void setStdNationlity(int stdNationlity) {
        this.stdNationlity = stdNationlity;
    }

    public void setStdEthnic(int stdEthnic) {
        this.stdEthnic = stdEthnic;
    }

    public void setStdReligion(int stdReligion) {
        this.stdReligion = stdReligion;
    }

    public void setStdStudying(boolean stdStudying) {
        this.stdStudying = stdStudying;
    }

    public void setBlood(String Blood) {
        this.Blood = Blood;
    }

    public void setStdWeight(float stdWeight) {
        this.stdWeight = stdWeight;
    }

    public void setStdHeight(float stdHeight) {
        this.stdHeight = stdHeight;
    }

    public void setStdCongenialDisease(boolean stdCongenialDisease) {
        this.stdCongenialDisease = stdCongenialDisease;
    }

    public void setStdCongenialDiseaseInfo(String stdCongenialDiseaseInfo) {
        this.stdCongenialDiseaseInfo = stdCongenialDiseaseInfo;
    }

    public void setStdSchoolName(String stdSchoolName) {
        this.stdSchoolName = stdSchoolName;
    }

    public void setStdSchoolLevel(String stdSchoolLevel) {
        this.stdSchoolLevel = stdSchoolLevel;
    }

    public void setStdSchoolMobile(String stdSchoolMobile) {
        this.stdSchoolMobile = stdSchoolMobile;
    }

    public void setStdNote(String stdNote) {
        this.stdNote = stdNote;
    }

    public void setStdPark(int stdPark) {
        this.stdPark = stdPark;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setStdNationalName(String stdNationalName) {
        this.stdNationalName = stdNationalName;
    }

    public void setStdEthnicName(String stdEthnicName) {
        this.stdEthnicName = stdEthnicName;
    }

    public void setStdReligionName(String stdReligionName) {
        this.stdReligionName = stdReligionName;
    }

    public void setStdParkName(String stdParkName) {
        this.stdParkName = stdParkName;
    }

    public int getStdID() {
        return stdID;
    }

    public String getStdNbr() {
        return stdNbr;
    }

    public int getStdType() {
        return stdType;
    }

    public String getStdTypeName() {
        return stdTypeName;
    }

    public String getStdName_L1() {
        return stdName_L1;
    }

    public String getStdName_L2() {
        return stdName_L2;
    }

    public int getGendID() {
        return gendID;
    }

    public String getGenderName() {
        return genderName;
    }

    public String getStdPhone1() {
        return stdPhone1;
    }

    public String getStdPhone2() {
        return stdPhone2;
    }

    public String getStdEmail() {
        return stdEmail;
    }

    public Date getStdDOB() {
        return stdDOB;
    }

    public Date getStdStartDate() {
        return stdStartDate;
    }

    public Date getStdEndDate() {
        return stdEndDate;
    }

    public int getStdNationlity() {
        return stdNationlity;
    }

    public int getStdEthnic() {
        return stdEthnic;
    }

    public int getStdReligion() {
        return stdReligion;
    }

    public boolean isStdStudying() {
        return stdStudying;
    }

    public String getBlood() {
        return Blood;
    }

    public float getStdWeight() {
        return stdWeight;
    }

    public float getStdHeight() {
        return stdHeight;
    }

    public boolean isStdCongenialDisease() {
        return stdCongenialDisease;
    }

    public String getStdCongenialDiseaseInfo() {
        return stdCongenialDiseaseInfo;
    }

    public String getStdSchoolName() {
        return stdSchoolName;
    }

    public String getStdSchoolLevel() {
        return stdSchoolLevel;
    }

    public String getStdSchoolMobile() {
        return stdSchoolMobile;
    }

    public String getStdNote() {
        return stdNote;
    }

    public int getStdPark() {
        return stdPark;
    }

    public String getPath() {
        return path;
    }

    public String getStdNationalName() {
        return stdNationalName;
    }

    public String getStdEthnicName() {
        return stdEthnicName;
    }

    public String getStdReligionName() {
        return stdReligionName;
    }

    public String getStdParkName() {
        return stdParkName;
    }

    public byte[] getPicture() {
        return picture;
    }
    
}
