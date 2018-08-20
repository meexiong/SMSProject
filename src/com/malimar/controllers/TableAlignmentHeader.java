
package com.malimar.controllers;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class TableAlignmentHeader implements TableCellRenderer {
  private int horizontalAlignment = SwingConstants.LEFT;
  public TableAlignmentHeader(int horizontalAlignment) {
    this.horizontalAlignment = horizontalAlignment;
  }
  @Override public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    TableCellRenderer r = table.getTableHeader().getDefaultRenderer();
    JLabel l = (JLabel) r.getTableCellRendererComponent(
        table, value, isSelected, hasFocus, row, column);
    l.setHorizontalAlignment(horizontalAlignment);
    return l;
  }
}
