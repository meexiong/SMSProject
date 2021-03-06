/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.LabelManager;
import com.malimar.controllers.Logo;
import com.malimar.controllers.UserPermission;
import com.malimar.controllers.WorkStatusManager;
import com.malimar.models.UserPermissions;
import com.malimar.models.WorkStatus;
import com.malimar.utils.Border;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import static com.malimar.views.FrmMain.userNbr;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Malimar
 */
public class FrmWorkStatus extends javax.swing.JFrame {

    /**
     * Creates new form FrmWorkStatus
     */
    Connection c = DatabaseManagerSQL.getConnection();
    String sql, frm;
    DefaultTableModel model = new DefaultTableModel();
    
    WorkStatus ws = new WorkStatus();
    WorkStatusManager wsm=new WorkStatusManager();
    
    public FrmWorkStatus() {
        initComponents();
        frm = this.getClass().getSimpleName();
        model = (DefaultTableModel)jTable1.getModel();
        jTable1.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));        
        Logo lg = new Logo();
        lg.getLogo(this);
        txtID.setEnabled(true);
                
        
        lblSystemInfo.setText(LabelManager.hmapForm.get(frm.toUpperCase())[LabelManager.LN]);
        lblWorkL1.setText(LabelManager.hmapLang.get("lblworkL1".concat(frm).toUpperCase())[LabelManager.LN]);
        lblWorkL2.setText(LabelManager.hmapLang.get("lblworkL2".concat(frm).toUpperCase())[LabelManager.LN]);
        lblID.setText(LabelManager.hmapLang.get("lblID".concat(frm).toUpperCase())[LabelManager.LN]);
        btnSave.setText(LabelManager.hmapLang.get("btnSave".concat(frm).toUpperCase())[LabelManager.LN]);
        
         jScrollPane1.getViewport().setBackground(Color.WHITE);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setBackground(Color.decode("#4169E1"));
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setOpaque(false);
        
        JTableHeader th = jTable1.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        jTable1.getColumnCount();
        for(int i=0; i < jTable1.getColumnCount(); i++){
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(LabelManager.hmapLang.get(jTable1.getModel().getColumnName(i).concat(frm).toUpperCase()) [LabelManager.LN]);                
        }
        jTable1.setAutoCreateRowSorter(true);
        th.repaint();
        
         Border.blueColor(btnSave);
         btnSave.setVisible(false);
        UserPermissions up = new UserPermissions();
        UserPermission.getPermission_UserAllForm(userNbr, frm, up, "btnSave");
        if (up.getW()==1){
            btnSave.setVisible(true);
        }else if (up.getDenys()==1){
            btnSave.setVisible(false);
        }
        
        
    }
    public void showClear(){
        try {
            txtID.setText("New");
            txtWorkL1.setText("");
            txtWorkL2.setText("");
            txtWorkL1.requestFocus();
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSystemInfo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblWorkL1 = new javax.swing.JLabel();
        txtWorkL1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblWorkL2 = new javax.swing.JLabel();
        txtWorkL2 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

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

        lblSystemInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblSystemInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSystemInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblSystemInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSystemInfo.setText("Work Status");
        lblSystemInfo.setOpaque(true);
        jPanel4.add(lblSystemInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "lblWorkL1", "lblWorkL1", "lblWorkL2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(27);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(350);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(350);
            jTable1.getColumnModel().getColumn(2).setMinWidth(350);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblID.setText("ID");
        lblID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIDMouseClicked(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setText("New");
        txtID.setBorder(null);
        txtID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtID.setEnabled(false);
        txtID.setOpaque(false);
        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDMouseClicked(evt);
            }
        });
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        lblWorkL1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblWorkL1.setText("WorkL1");
        lblWorkL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWorkL1MouseClicked(evt);
            }
        });

        txtWorkL1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtWorkL1.setBorder(null);

        lblWorkL2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblWorkL2.setText("WorkL2");
        lblWorkL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWorkL2MouseClicked(evt);
            }
        });

        txtWorkL2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtWorkL2.setBorder(null);
        txtWorkL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWorkL2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWorkL1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(txtWorkL1)
                    .addComponent(jSeparator2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWorkL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtWorkL2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lblID)
                            .addGap(1, 1, 1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lblWorkL1)
                            .addGap(1, 1, 1)
                            .addComponent(txtWorkL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblWorkL2)
                                .addGap(1, 1, 1)
                                .addComponent(txtWorkL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmWorkStatus.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int row = jTable1.getSelectedRow();
            txtID.setText(jTable1.getValueAt(row, 0).toString());
            txtWorkL1.setText(jTable1.getValueAt(row, 1).toString());
            txtWorkL2.setText(jTable1.getValueAt(row, 2).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void lblIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIDMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblID", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblIDMouseClicked

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked
        if(evt.getClickCount()==2){
            showClear();
            wsm.showData(jTable1, model);
        }
    }//GEN-LAST:event_txtIDMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void lblWorkL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWorkL1MouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblworkL1", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblWorkL1MouseClicked

    private void lblWorkL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWorkL2MouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblworkL2", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblWorkL2MouseClicked

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("btnSave", frm);
            }else{
                if (txtWorkL1.getText().equals("")||txtWorkL2.getText().equals("")){
                    MsgBox.msgError();
                    return;
                }
                if (txtID.getText().equals("New")){
                    ws.setWork_L1(txtWorkL1.getText());
                    ws.setWork_L2(txtWorkL2.getText());
                    wsm.insertWorkStatus(ws);
                    showClear();
                    wsm.showData(jTable1, model);
                }else{
                    ws.setId(Integer.parseInt(txtID.getText()));
                    ws.setWork_L1(txtWorkL1.getText());
                    ws.setWork_L2(txtWorkL2.getText());
                    wsm.updateWorkStatus(ws);
                    wsm.showData(jTable1, model);
                    showClear();
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void txtWorkL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWorkL2ActionPerformed
        try {
            if (txtWorkL1.getText().equals("")||txtWorkL2.getText().equals("")){
                MsgBox.msgError();
                return;
            }
            if (txtID.getText().equals("New")){
                ws.setWork_L1(txtWorkL1.getText());
                ws.setWork_L2(txtWorkL2.getText());
                wsm.insertWorkStatus(ws);
                showClear();
                wsm.showData(jTable1, model);
            }else{
                ws.setId(Integer.parseInt(txtID.getText()));
                ws.setWork_L1(txtWorkL1.getText());
                ws.setWork_L2(txtWorkL2.getText());
                wsm.updateWorkStatus(ws);
                wsm.showData(jTable1, model);
                showClear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtWorkL2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            wsm.showData(jTable1, model);
            txtWorkL1.requestFocus();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(FrmWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmWorkStatus().setVisible(true);
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblSystemInfo;
    private javax.swing.JLabel lblWorkL1;
    private javax.swing.JLabel lblWorkL2;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtWorkL1;
    private javax.swing.JTextField txtWorkL2;
    // End of variables declaration//GEN-END:variables
}
