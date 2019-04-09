
package com.malimar.models;

import java.util.Date;

public class Sale {
    int saleid;
    Date saleDate;
    String salePerson;
    String currency_L1;
    String currency_L2;
    String paymentType_L1;
    String paymentType_L2;
    double subTotal;
    float discountPercentage;
    double discountAmount;
    float vatPercentage;
    double vatAmount;
    double grandTotal;
    int productID;
    String productName;
    double price;
    float qty;
    double total;
    String unitName;
    double paidTotal;
    String currency;
    String paymentType;
    Date voidDate;
    String loginBy;

    public String getLoginBy() {
        return loginBy;
    }

    public void setLoginBy(String loginBy) {
        this.loginBy = loginBy;
    }
    
    public Date getVoidDate() {
        return voidDate;
    }

    public void setVoidDate(Date voidDate) {
        this.voidDate = voidDate;
    }
    
    
    
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    public void setPaidTotal(double paidTotal) {
        this.paidTotal = paidTotal;
    }
    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    public void setSaleid(int saleid) {
        this.saleid = saleid;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public void setSalePerson(String salePerson) {
        this.salePerson = salePerson;
    }

    public void setCurrency_L1(String currency_L1) {
        this.currency_L1 = currency_L1;
    }

    public void setCurrency_L2(String currency_L2) {
        this.currency_L2 = currency_L2;
    }

    public void setPaymentType_L1(String paymentType_L1) {
        this.paymentType_L1 = paymentType_L1;
    }

    public void setPaymentType_L2(String paymentType_L2) {
        this.paymentType_L2 = paymentType_L2;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setVatPercentage(float vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getSaleid() {
        return saleid;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public String getSalePerson() {
        return salePerson;
    }

    public String getCurrency_L1() {
        return currency_L1;
    }

    public String getCurrency_L2() {
        return currency_L2;
    }

    public String getPaymentType_L1() {
        return paymentType_L1;
    }

    public String getPaymentType_L2() {
        return paymentType_L2;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public float getVatPercentage() {
        return vatPercentage;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public float getQty() {
        return qty;
    }

    public double getTotal() {
        return total;
    }

    public String getUnitName() {
        return unitName;
    }

    public double getPaidTotal() {
        return paidTotal;
    }

}
