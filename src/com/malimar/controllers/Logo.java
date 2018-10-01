/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 *
 * @author Malimar
 */
public class Logo {
    public void getLogo(JFrame frm){
        frm.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/malimar/logos/Logo.png")));    
    }
}
