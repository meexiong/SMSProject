/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import javax.swing.JLabel;

/**
 *
 * @author Malimar
 */
public class Border {
    public static void blueColor(JLabel btn){
        btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,15,255)));
    }
    public static void WhiteColor(JLabel btn){
        btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }
}
