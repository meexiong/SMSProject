
package com.malimar.views;

import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.SemesterManager;
import com.malimar.models.Semester;
import com.malimar.utils.Border;
import com.malimar.utils.ClearTable;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FrmSemester extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    String frm;
    SemesterManager sm = new SemesterManager();
    Semester st = new Semester();

    public FrmSemester() {
        initComponents();
        model = (DefaultTableModel) table.getModel();
        startFrame();
        ClearTable.clearFirstLoad(table, model);
        sm.load(model);
    }
    private void startFrame(){
        frm = this.getClass().getSimpleName();
        table.getTableHeader().setFont(new Font("Saysettha OT",Font.BOLD,12));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.getTableHeader().setBackground(Color.decode("#4169E1"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
        lblSemesterID.setText(hmapLang.get("lblSemesterID".concat(frm).toUpperCase())[LN]);
        lbSemesterInfo.setText(hmapLang.get("lbSemesterInfo".concat(frm).toUpperCase())[LN]);
        lblSemesterName.setText(hmapLang.get("lblSemesterName".concat(frm).toUpperCase())[LN]);
        lblStartDate.setText(hmapLang.get("lblStartDate".concat(frm).toUpperCase())[LN]);
        lblEndDate.setText(hmapLang.get("lblEndDate".concat(frm).toUpperCase())[LN]);
        btnSave.setText(hmapLang.get("btnSave".concat(frm).toUpperCase())[LN]);
        JTableHeader th = table.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            table.getColumnCount();
            for(int i=0; i < table.getColumnCount(); i++){
                TableColumn tc = tcm.getColumn(i);            
            tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        table.setAutoCreateRowSorter(true);
        th.repaint();
    }

    private void clearText() {
        txtSemesterID.setText("New");
        txtSemesterName.setText("");
        txtStartDate.setDate(null);
        txtEndDate.setDate(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblSemesterID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbSemesterInfo = new javax.swing.JLabel();
        txtSemesterID = new javax.swing.JTextField();
        lblSemesterName = new javax.swing.JLabel();
        txtSemesterName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblStartDate = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        lblEndDate = new javax.swing.JLabel();
        txtEndDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel3.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "lblSemesterID", "lblSemesterName", "lblStartDate", "lblEndDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(25);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMinWidth(300);
            table.getColumnModel().getColumn(1).setMaxWidth(300);
            table.getColumnModel().getColumn(2).setMinWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblSemesterID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSemesterID.setText("ID");
        lblSemesterID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSemesterIDMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Minimize Window_30px.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        lbSemesterInfo.setBackground(new java.awt.Color(255, 255, 255));
        lbSemesterInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lbSemesterInfo.setForeground(new java.awt.Color(0, 15, 255));
        lbSemesterInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSemesterInfo.setText("Semester Information");
        lbSemesterInfo.setOpaque(true);
        jPanel4.add(lbSemesterInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        txtSemesterID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSemesterID.setText("New");
        txtSemesterID.setBorder(null);
        txtSemesterID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSemesterID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSemesterID.setEnabled(false);
        txtSemesterID.setOpaque(false);
        txtSemesterID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSemesterIDMouseClicked(evt);
            }
        });

        lblSemesterName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSemesterName.setText("Semester Name");
        lblSemesterName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSemesterNameMouseClicked(evt);
            }
        });

        txtSemesterName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSemesterName.setBorder(null);

        lblStartDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStartDate.setText("Start Date");
        lblStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStartDateMouseClicked(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveMouseMoved(evt);
            }
        });
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });

        txtStartDate.setDateFormatString("dd-MM-yyyy");
        txtStartDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        lblEndDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblEndDate.setText("End Date");
        lblEndDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEndDateMouseClicked(evt);
            }
        });

        txtEndDate.setDateFormatString("dd-MM-yyyy");
        txtEndDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSemesterID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSemesterID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSemesterName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSemesterName, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(78, 78, 78)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSeparator3, txtSemesterID});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemesterID)
                    .addComponent(txtSemesterID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemesterName)
                    .addComponent(txtSemesterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStartDate))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndDate)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblEndDate, lblSemesterID, lblSemesterName, lblStartDate, txtEndDate, txtSemesterID, txtSemesterName, txtStartDate});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmSemester.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("btnSave", frm);
        }else{
            st.setSemesterName(txtSemesterName.getText());
            st.setStartDate(txtStartDate.getDate());
            st.setEndDate(txtEndDate.getDate());
            if(txtSemesterID.getText().equals("New")){
                if(sm.insert(st)){
                    clearText();
                    ClearTable.clearFirstLoad(table, model);
                    sm.load(model);
                }else{
                    MsgBox.msgError();
                }
            }else{
                st.setSemesterID(Integer.parseInt(txtSemesterID.getText()));
                if(sm.update(st)){
                    clearText();
                    ClearTable.clearFirstLoad(table, model);
                    sm.load(model);
                }else{
                    MsgBox.msgError();
                }
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            int rowIndex = table.getSelectedRow();
            txtSemesterID.setText(table.getValueAt(rowIndex, 0).toString());
            txtSemesterName.setText(table.getValueAt(rowIndex, 1).toString());
            java.util.Date stdate = new SimpleDateFormat("dd-MM-yyyy").parse(table.getValueAt(rowIndex, 2).toString());
            txtStartDate.setDate(stdate);
            java.util.Date eDate = new SimpleDateFormat("dd-MM-yyyy").parse(table.getValueAt(rowIndex, 3).toString());
            txtEndDate.setDate(eDate);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tableMouseClicked

    private void txtSemesterIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSemesterIDMouseClicked
        if(evt.getClickCount()==2){
            clearText();
        }
    }//GEN-LAST:event_txtSemesterIDMouseClicked

    private void lblSemesterIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSemesterIDMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblSemesterID", frm);
        }
    }//GEN-LAST:event_lblSemesterIDMouseClicked

    private void lblSemesterNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSemesterNameMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblSemesterName", frm);
        }
    }//GEN-LAST:event_lblSemesterNameMouseClicked

    private void lblStartDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStartDateMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStartDate", frm);
        }
    }//GEN-LAST:event_lblStartDateMouseClicked

    private void lblEndDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEndDateMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblEndDate", frm);
        }
    }//GEN-LAST:event_lblEndDateMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_formMouseDragged

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
            java.util.logging.Logger.getLogger(FrmSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSemester().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbSemesterInfo;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblSemesterID;
    private javax.swing.JLabel lblSemesterName;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtSemesterID;
    private javax.swing.JTextField txtSemesterName;
    private com.toedter.calendar.JDateChooser txtStartDate;
    // End of variables declaration//GEN-END:variables
}
