
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.GetMaxID;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.RoomManager;
import com.malimar.models.Room;
import com.malimar.utils.Border;
import com.malimar.utils.ClearTable;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FrmRoom extends javax.swing.JFrame {
    Connection c = DatabaseManagerSQL.getConnection();
    DefaultTableModel model = new DefaultTableModel();
    String frm;
    RoomManager rmm =  new RoomManager();
    Room rm = new Room();
    public FrmRoom() {
        initComponents();
        table.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));
        frm = this.getClass().getSimpleName();
        model = (DefaultTableModel) table.getModel();
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.getTableHeader().setBackground(Color.decode("#4169E1"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
        ClearTable.clearFirstLoad(table, model);
        rmm.load(model);
        lblRoomInfo.setText(hmapLang.get("lblRoomInfo".concat(frm).toUpperCase())[LN]);
        lblRoomID.setText(hmapLang.get("lblRoomID".concat(frm).toUpperCase())[LN]);
        lblRoomNbr.setText(hmapLang.get("lblRoomNbr".concat(frm).toUpperCase())[LN]);
        lblMax.setText(hmapLang.get("lblMax".concat(frm).toUpperCase())[LN]);
        btnSave.setText(hmapLang.get("btnSave".concat(frm).toUpperCase())[LN]);
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        table.getColumnCount();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        table.setAutoCreateRowSorter(true);
        th.repaint();
    }
    private void clearText(){
        txtID.setText("New");
        txtRoomNbr.setText("");
        txtRoomMax.setText("0");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMinimize1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblRoomInfo = new javax.swing.JLabel();
        lblRoomID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblRoomNbr = new javax.swing.JLabel();
        txtRoomNbr = new javax.swing.JTextField();
        lblMax = new javax.swing.JLabel();
        txtRoomMax = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnMinimize1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Minimize Window_30px.png"))); // NOI18N
        btnMinimize1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimize1MouseClicked(evt);
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

        jPanel5.setLayout(new java.awt.BorderLayout());

        lblRoomInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblRoomInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblRoomInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblRoomInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRoomInfo.setText("Room Information");
        lblRoomInfo.setOpaque(true);
        lblRoomInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoomInfoMouseClicked(evt);
            }
        });
        jPanel5.add(lblRoomInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimize1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        lblRoomID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblRoomID.setText("RoomID");
        lblRoomID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoomIDMouseClicked(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtID.setText("New");
        txtID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtID.setEnabled(false);
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

        lblRoomNbr.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblRoomNbr.setText("Room#");
        lblRoomNbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoomNbrMouseClicked(evt);
            }
        });

        txtRoomNbr.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtRoomNbr.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblMax.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblMax.setText("Max");
        lblMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMaxMouseClicked(evt);
            }
        });

        txtRoomMax.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtRoomMax.setText("0");
        txtRoomMax.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "lblRoomID", "lblRoomNbr", "lblMax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(70);
            table.getColumnModel().getColumn(0).setMaxWidth(70);
            table.getColumnModel().getColumn(1).setMinWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(200);
            table.getColumnModel().getColumn(2).setMinWidth(70);
            table.getColumnModel().getColumn(2).setMaxWidth(70);
        }

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRoomNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRoomNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMax, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRoomMax)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomNbr)
                    .addComponent(txtRoomNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMax)
                    .addComponent(txtRoomMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblRoomID, txtID});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimize1MouseClicked
        this.setState(FrmNationality.ICONIFIED);
    }//GEN-LAST:event_btnMinimize1MouseClicked

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
            GetMaxID gm = new GetMaxID();
            rm.setRoomNbr(txtRoomNbr.getText().trim());
            rm.setRoomMax(Integer.parseInt(txtRoomMax.getText()));
            if(txtID.getText().equals("New")){
                rm.setRoomID(gm.getIntID("Tbl_Room", "RoomID"));
                if(rmm.insert(rm)){
                    MsgBox.msgInfo();
                    clearText();
                }
            }else{
                rm.setRoomID(Integer.parseInt(txtID.getText()));
                if(rmm.update(rm)){
                    MsgBox.msgInfo();
                    clearText();
                }
            }
            ClearTable.clearFirstLoad(table, model);
            rmm.load(model);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void lblRoomIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomIDMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblRoomID", frm);
        }
    }//GEN-LAST:event_lblRoomIDMouseClicked

    private void lblRoomNbrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomNbrMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblRoomNbr", frm);
        }
    }//GEN-LAST:event_lblRoomNbrMouseClicked

    private void lblMaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaxMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblMax", frm);
        }
    }//GEN-LAST:event_lblMaxMouseClicked

    private void lblRoomInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomInfoMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblRoomInfo", frm);
        }
    }//GEN-LAST:event_lblRoomInfoMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            int index = table.getSelectedRow();
            txtID.setText(table.getValueAt(index, 0).toString());
            txtRoomNbr.setText(table.getValueAt(index, 1).toString());
            txtRoomMax.setText(table.getValueAt(index, 2).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        
    }//GEN-LAST:event_tableKeyPressed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_DELETE){
            rm.setRoomID(Integer.parseInt(txtID.getText()));
            rmm.delete(rm);
            ClearTable.clearFirstLoad(table, model);
            rmm.load(model);
        }
    }//GEN-LAST:event_tableKeyReleased

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked
        if (evt.getClickCount() == 2) {
            txtID.setText("New");
            txtRoomNbr.setText("");
            txtRoomMax.setText("0");
        }
    }//GEN-LAST:event_txtIDMouseClicked

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
            java.util.logging.Logger.getLogger(FrmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize1;
    private javax.swing.JLabel btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblRoomID;
    private javax.swing.JLabel lblRoomInfo;
    private javax.swing.JLabel lblRoomNbr;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtRoomMax;
    private javax.swing.JTextField txtRoomNbr;
    // End of variables declaration//GEN-END:variables
}
