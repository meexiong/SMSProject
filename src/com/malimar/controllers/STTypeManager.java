/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import com.malimar.models.STType;
import java.sql.Connection;

/**
 *
 * @author Malimar
 */
public class STTypeManager {
    Connection c = DatabaseManagerSQL.getConnection();
    public boolean insertSttype(STType stm){
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
