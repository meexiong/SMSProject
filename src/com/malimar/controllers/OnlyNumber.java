/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import javax.swing.JTextField;

/**
 *
 * @author Malimar
 */
public class OnlyNumber {
    public static void onlyInteger(java.awt.event.KeyEvent evt, JTextField txt){
        char ch = evt.getKeyChar();
        if(!(Character.isDigit(ch))){
            evt.consume();
        }
    }
}
