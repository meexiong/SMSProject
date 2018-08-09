/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class RemoveTableIndex {
    public static void removeTable(JTable table, DefaultTableModel model){
        try {
            int rowIndex = table.getRowCount()-1;
            while(rowIndex>-1){
                model.removeRow(rowIndex--);
            }
        } catch (Exception e) {
        }
    }
}
