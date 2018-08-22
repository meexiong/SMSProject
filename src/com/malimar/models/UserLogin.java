/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.models;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.utils.RemoveTableIndex;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class UserLogin {
    int Teid;
    Boolean userlogin;

    public void setUserlogin(Boolean userlogin) {
        this.userlogin = userlogin;
    }

    public Boolean getUserlogin() {
        return userlogin;
    }

    public void setTeid(int Teid) {
        this.Teid = Teid;
    }

    public int getTeid() {
        return Teid;
    }
    
    
}
