
package com.malimar.models;

public class Product {
    int productID;
    String productName_L1;
    String productName_L2;
    String description;
    String barcode;
    double cost;
    double price;
    int quantity;
    boolean chInActive;
    String path;
    byte[] picture;    
    String unitName_L1;
    String unitName_L2;
    String unitName;
    public Product(){
        
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setUnitName_L1(String unitName_L1) {
        this.unitName_L1 = unitName_L1;
    }

    public void setUnitName_L2(String unitName_L2) {
        this.unitName_L2 = unitName_L2;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName_L1(String productName_L1) {
        this.productName_L1 = productName_L1;
    }

    public void setProductName_L2(String productName_L2) {
        this.productName_L2 = productName_L2;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setChInActive(boolean chInActive) {
        this.chInActive = chInActive;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName_L1() {
        return productName_L1;
    }

    public String getProductName_L2() {
        return productName_L2;
    }

    public String getDescription() {
        return description;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isChInActive() {
        return chInActive;
    }

    public String getPath() {
        return path;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getUnitName_L1() {
        return unitName_L1;
    }

    public String getUnitName_L2() {
        return unitName_L2;
    }

    public String getUnitName() {
        return unitName;
    }

    
}
