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
public class AccessDatasource {
    String serverName;
    String DatabaseName;
    String UserLogin;
    String password;
    String port;
    public AccessDatasource(){
        
    }
     public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setDatabaseName(String DatabaseName) {
        this.DatabaseName = DatabaseName;
    }

    public void setUserLogin(String UserLogin) {
        this.UserLogin = UserLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(String port) {
        this.port = port;
    }
    public String getServerName() {
        return serverName;
    }

    public String getDatabaseName() {
        return DatabaseName;
    }

    public String getUserLogin() {
        return UserLogin;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }
}
