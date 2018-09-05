/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Malimar
 */
public class SetText {
    public static void disableLabel(JLabel lbl){
        lbl.setEnabled(false);
    }
    public static void enableLabel(JLabel lbl){
        lbl.setEnabled(true);
    }
    public static void enableText(JTextField txt){
        txt.setEnabled(true);
        txt.setOpaque(true);
        txt.setDisabledTextColor(Color.BLACK);
    }
    public static void disableText(JTextField txt){
//        txt.setEnabled(false);
//        txt.setOpaque(false);
//        txt.setDisabledTextColor(Color.BLACK);
        txt.setDisabledTextColor(Color.BLACK);
    }
    public static void setVisibleFalse(JLabel lbl){
        lbl.setVisible(false);
    }
    public static void setVisibleTrue(JLabel lbl){
        lbl.setVisible(true);
    }
    public static void cmbTextColor(JComboBox cmb){
        ((JTextField)cmb.getEditor().getEditorComponent()).setDisabledTextColor(Color.BLACK);
    }
    public static void dateTextColor(JDateChooser date){
        ((JTextFieldDateEditor)date.getDateEditor()).setDisabledTextColor(Color.BLACK);
    }
}
