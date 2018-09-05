
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.ReceiptManager;
import com.malimar.controllers.TableAlignmentHeader;
import com.malimar.models.Receipt;
import com.malimar.utils.ClearTable;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrmReceiptList extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Connection c = DatabaseManagerSQL.getConnection();
    String frm;
    ReceiptManager rcm = new ReceiptManager();
    Receipt rct = new Receipt();
    HashMap<String, Object[]>mapSemester = null;
    HashMap<String, Object[]>mapCourse = null;
    public FrmReceiptList() {
        initComponents();
        showReceipt();
        getcmbSemester();
        getcmbCourse();
        cmbCourse.setEnabled(false);
    }
    private void showReceipt() {
        try {
            frm = this.getClass().getSimpleName();
            table.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));
            model = (DefaultTableModel) table.getModel();
            jScrollPane1.getViewport().setBackground(Color.WHITE);
            table.setShowGrid(true);
            table.getTableHeader().setBackground(Color.decode("#4169E1"));
            table.getTableHeader().setForeground(Color.WHITE);
            table.getTableHeader().setOpaque(false);
            lblSemester.setText(hmapLang.get("lblSemester".concat(frm).toUpperCase())[LN]);
            lblReceiptList.setText(hmapLang.get("lblReceiptList".concat(frm).toUpperCase())[LN]);
            lblSemester.setText(hmapLang.get("lblSemester".concat(frm).toUpperCase())[LN]);
            lblCourse.setText(hmapLang.get("lblCourse".concat(frm).toUpperCase())[LN]);
            lblReceiptNo.setText(hmapLang.get("lblReceiptNo".concat(frm).toUpperCase())[LN]);
            JTableHeader th = table.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            table.getColumnCount();
            for (int i = 0; i < table.getColumnCount(); i++) {
                TableColumn tc = tcm.getColumn(i);
                tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
            }
            table.setAutoCreateRowSorter(true);
            th.repaint();
            table.getColumnModel().getColumn(0).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
            table.getColumnModel().getColumn(1).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
            table.getColumnModel().getColumn(2).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
            table.getColumnModel().getColumn(3).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
            table.getColumnModel().getColumn(4).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
            table.getColumnModel().getColumn(5).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
            table.getColumnModel().getColumn(6).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
            table.getColumnModel().getColumn(7).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
            DefaultTableCellRenderer CenterRenderer = new DefaultTableCellRenderer();
            CenterRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            table.getColumnModel().getColumn(7).setCellRenderer(CenterRenderer);
            DefaultTableCellRenderer RightRenderer = new DefaultTableCellRenderer();
            RightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
            table.getColumnModel().getColumn(4).setCellRenderer(RightRenderer);
            table.getColumnModel().getColumn(5).setCellRenderer(RightRenderer);
            table.getColumnModel().getColumn(6).setCellRenderer(RightRenderer);
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    private void getcmbSemester() {
        try {
            mapSemester = rcm.mapSemester();
            Map<String, Object[]> ms = new TreeMap<>(mapSemester);
            cmbSemester.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbSemester.addItem(s);
            });
            cmbSemester.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbSemester);
        } catch (Exception e) {
        }
    }
    private void getcmbCourse() {
        try {
            mapCourse = rcm.mapCourse();
            Map<String, Object[]> ms = new TreeMap<>(mapCourse);
            cmbCourse.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbCourse.addItem(s);
            });
            cmbCourse.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbCourse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnMinimize3 = new javax.swing.JLabel();
        btnExit1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblReceiptList = new javax.swing.JLabel();
        lblReceiptNo = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblSemester = new javax.swing.JLabel();
        cmbSemester = new javax.swing.JComboBox<>();
        lblCourse = new javax.swing.JLabel();
        cmbCourse = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnMinimize3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Minimize Window_30px.png"))); // NOI18N
        btnMinimize3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimize3MouseClicked(evt);
            }
        });

        btnExit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExit1MouseClicked(evt);
            }
        });

        jPanel8.setLayout(new java.awt.BorderLayout());

        lblReceiptList.setBackground(new java.awt.Color(255, 255, 255));
        lblReceiptList.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblReceiptList.setForeground(new java.awt.Color(0, 15, 255));
        lblReceiptList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReceiptList.setText("Receipt list");
        lblReceiptList.setOpaque(true);
        jPanel8.add(lblReceiptList, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimize3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        lblReceiptNo.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblReceiptNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblReceiptNo.setText("Receipt#");

        jTextField1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);

        lblSemester.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSemester.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSemester.setText("Semester");

        cmbSemester.setEditable(true);
        cmbSemester.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemesterActionPerformed(evt);
            }
        });

        lblCourse.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCourse.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCourse.setText("Course");

        cmbCourse.setEditable(true);
        cmbCourse.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCourseActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "lblID", "lblStudentID", "lblStudentName", "lblGender", "lblTotal", "lblBalance", "lblPaid", "lblCurrency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(java.awt.Color.red);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(80);
            table.getColumnModel().getColumn(0).setMaxWidth(80);
            table.getColumnModel().getColumn(1).setMinWidth(120);
            table.getColumnModel().getColumn(1).setMaxWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(300);
            table.getColumnModel().getColumn(2).setMaxWidth(300);
            table.getColumnModel().getColumn(3).setMinWidth(72);
            table.getColumnModel().getColumn(3).setMaxWidth(72);
            table.getColumnModel().getColumn(4).setMinWidth(120);
            table.getColumnModel().getColumn(4).setMaxWidth(120);
            table.getColumnModel().getColumn(5).setMinWidth(120);
            table.getColumnModel().getColumn(5).setMaxWidth(120);
            table.getColumnModel().getColumn(6).setMinWidth(120);
            table.getColumnModel().getColumn(6).setMaxWidth(120);
            table.getColumnModel().getColumn(7).setMinWidth(80);
            table.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lblSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblReceiptNo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblReceiptNo)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCourse))
                    .addComponent(lblSemester))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbCourse, cmbSemester, jTextField1, lblCourse, lblReceiptNo, lblSemester});

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimize3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimize3MouseClicked
        this.setState(FrmReceiptList.ICONIFIED);
    }//GEN-LAST:event_btnMinimize3MouseClicked

    private void btnExit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExit1MouseClicked
        dispose();
    }//GEN-LAST:event_btnExit1MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2) {
            int row = table.getSelectedRow();
            int registerID = Integer.parseInt(table.getValueAt(row, 0).toString());
            String cur = table.getValueAt(row, 7).toString();
            double fee = Double.parseDouble(table.getValueAt(row, 4).toString().replace(",", ""));
//            rct.setGrandTotal(fee);
            FrmReceipt frmrect = new FrmReceipt(null, rootPaneCheckingEnabled, registerID, cur, fee);
            frmrect.setVisible(true);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void cmbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemesterActionPerformed
        if(cmbSemester.getSelectedIndex() !=-1){
            cmbCourse.setEnabled(true);
        }
    }//GEN-LAST:event_cmbSemesterActionPerformed

    private void cmbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCourseActionPerformed
        if(cmbCourse.getSelectedIndex() !=-1 && cmbSemester.getSelectedIndex() !=-1){
            String semester = cmbSemester.getSelectedItem().toString();
            String course = cmbCourse.getSelectedItem().toString();
            rct.setSemesterID((int) mapSemester.get(semester)[0]);
            rct.setCourseID((int) mapCourse.get(course)[0]);
            ClearTable.clearFirstLoad(table, model);
            rcm.load(model, rct);
        }
    }//GEN-LAST:event_cmbCourseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmReceiptList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReceiptList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReceiptList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReceiptList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReceiptList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit1;
    private javax.swing.JLabel btnMinimize3;
    private javax.swing.JComboBox<String> cmbCourse;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblReceiptList;
    private javax.swing.JLabel lblReceiptNo;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
