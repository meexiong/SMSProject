/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

import java.util.Date;

/**
 *
 * @author Malimar
 */
public class Receipt {

    int receiptID;
    Date receiptDate;
    String receiptBy;
    int semesterID;
    int courseID;
    double amountLAK;
    double amountTHB;
    double amountUSD;
    float rateLAK;
    float rateTHB;
    float rateUSD;
    String currency;
    String payment_L1;
    String payment_L2;
    int registerID;
    double grandTotal;
    double paid;
    public Receipt() {

    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public void setPayment_L1(String payment_L1) {
        this.payment_L1 = payment_L1;
    }

    public void setPayment_L2(String payment_L2) {
        this.payment_L2 = payment_L2;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setRateLAK(float rateLAK) {
        this.rateLAK = rateLAK;
    }

    public void setRateTHB(float rateTHB) {
        this.rateTHB = rateTHB;
    }

    public void setRateUSD(float rateUSD) {
        this.rateUSD = rateUSD;
    }

    public void setAmountLAK(double amountLAK) {
        this.amountLAK = amountLAK;
    }

    public void setAmountTHB(double amountTHB) {
        this.amountTHB = amountTHB;
    }

    public void setAmountUSD(double amountUSD) {
        this.amountUSD = amountUSD;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public void setReceiptBy(String receiptBy) {
        this.receiptBy = receiptBy;
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public String getReceiptBy() {
        return receiptBy;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public int getCourseID() {
        return courseID;
    }

    public double getAmountLAK() {
        return amountLAK;
    }

    public double getAmountTHB() {
        return amountTHB;
    }

    public double getAmountUSD() {
        return amountUSD;
    }

    public float getRateLAK() {
        return rateLAK;
    }

    public float getRateTHB() {
        return rateTHB;
    }

    public float getRateUSD() {
        return rateUSD;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPayment_L1() {
        return payment_L1;
    }

    public String getPayment_L2() {
        return payment_L2;
    }

    public int getRegisterID() {
        return registerID;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public double getPaid() {
        return paid;
    }

}
