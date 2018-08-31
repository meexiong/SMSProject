/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Malimar
 */
public class TableHeader {
    
    public static void tableHeader(JTable table, JTableHeader head){
        try {
            DefaultTableCellRenderer rend = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
            rend.setHorizontalAlignment(JLabel.CENTER);
            head.setDefaultRenderer(rend);
        } catch (Exception e) {
        }
        //return null;
    }
    public static void tableHeaderColor(JTable table, JScrollPane sco, JTableHeader head){
        try {
            sco.getViewport().setBackground(Color.WHITE);
            table.setShowGrid(true);
            table.getTableHeader().setBackground(Color.decode("#4169E1"));
            table.getTableHeader().setForeground(Color.WHITE);
            table.getTableHeader().setOpaque(false);            
        } catch (Exception e) {
        }
    }
    
}
