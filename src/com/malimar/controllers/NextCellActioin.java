/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTable;

/**
 *
 * @author Khammao
 */
    public class NextCellActioin extends AbstractAction {
        private final JTable table;
        public NextCellActioin(JTable table) {
            this.table = table;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            int colCount = table.getColumnCount();
            int rowCount = table.getRowCount();
            col++;
            if (col >= colCount) {
                col = 0;
                row++; 
            }
            if (row >= rowCount) {
                row = 0;
            }else{
                table.getSelectionModel().setSelectionInterval(row, row);
                table.getColumnModel().getSelectionModel().setSelectionInterval(col, col);
            }  
        }
}
