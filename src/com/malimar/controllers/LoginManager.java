/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import java.sql.SQLException;

/**
 *
 * @author Malimar
 */
public class LoginManager {
    private String userName;
    private String password;
    DatabaseManagerSQL dm =new DatabaseManagerSQL();
    public LoginManager(){
        
    }
    public boolean verifyUser(){
        String dbPass = null;
        try {
         dbPass = dm.getUserPassword(userName);   
        } catch (SQLException e) {
        } 
        return this.password.equals(dbPass);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
