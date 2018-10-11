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
public class Payment {
    float rateLAK;
    float rateTHB;
    float rateUSD;
    public Payment(){
    
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

    public float getRateLAK() {
        return rateLAK;
    }

    public float getRateTHB() {
        return rateTHB;
    }

    public float getRateUSD() {
        return rateUSD;
    }
    
}
