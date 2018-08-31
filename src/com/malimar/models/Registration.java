
package com.malimar.models;

import java.util.Date;

public class Registration {
    double subTotal;
    double grandTotal;
    float disPC;
    double disAmount;
    float vat;
    double vatAmount;
    int registrationID;
    int studentID;
    int regtDetailID;
    int scheduleDetailID;
    double price;
    String currency_L1;
    String currency_L2;
    Date rgtDate;
    public Registration(){
        
    }

    public void setRgtDate(Date rgtDate) {
        this.rgtDate = rgtDate;
    }

    public void setCurrency_L1(String currency_L1) {
        this.currency_L1 = currency_L1;
    }

    public void setCurrency_L2(String currency_L2) {
        this.currency_L2 = currency_L2;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setScheduleDetailID(int scheduleDetailID) {
        this.scheduleDetailID = scheduleDetailID;
    }

    public void setRegtDetailID(int regtDetailID) {
        this.regtDetailID = regtDetailID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setDisPC(float disPC) {
        this.disPC = disPC;
    }

    public void setDisAmount(double disAmount) {
        this.disAmount = disAmount;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public float getDisPC() {
        return disPC;
    }

    public double getDisAmount() {
        return disAmount;
    }

    public float getVat() {
        return vat;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getRegtDetailID() {
        return regtDetailID;
    }

    public int getScheduleDetailID() {
        return scheduleDetailID;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency_L1() {
        return currency_L1;
    }

    public String getCurrency_L2() {
        return currency_L2;
    }

    public Date getRgtDate() {
        return rgtDate;
    }
    
}
