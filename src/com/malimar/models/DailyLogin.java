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
public class DailyLogin {
    String UserLogin;
    String MainBord;
    String ComIP;
    Date DateLogin;

    public String getUserLogin() {
        return UserLogin;
    }

    public String getMainBord() {
        return MainBord;
    }

    public String getComIP() {
        return ComIP;
    }

    public Date getDateLogin() {
        return DateLogin;
    }

    public void setUserLogin(String UserLogin) {
        this.UserLogin = UserLogin;
    }

    public void setMainBord(String MainBord) {
        this.MainBord = MainBord;
    }

    public void setComIP(String ComIP) {
        this.ComIP = ComIP;
    }

    public void setDateLogin(Date DateLogin) {
        this.DateLogin = DateLogin;
    }
    
    
    
    
}
