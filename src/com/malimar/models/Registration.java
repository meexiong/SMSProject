
package com.malimar.models;

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
    public Registration(){
        
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
    
}
