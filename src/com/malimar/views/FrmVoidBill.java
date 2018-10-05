
package com.malimar.views;

import com.malimar.controllers.LabelManager;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.SaleManager;
import com.malimar.utils.Border;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;

public class FrmVoidBill extends javax.swing.JDialog {
    String frm;
    
    public FrmVoidBill(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        lblVoidBillTitle.setText(hmapLang.get("lblVoidBillTitle".concat(frm).toUpperCase()) [LN]);
        lblBillID.setText(hmapLang.get("lblBillID".concat(frm).toUpperCase()) [LN]);
        btnVoid.setText(hmapLang.get("btnVoid".concat(frm).toUpperCase()) [LN]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblVoidBillTitle = new javax.swing.JLabel();
        lblBillID = new javax.swing.JLabel();
        txtSaleID = new javax.swing.JTextField();
        btnVoid = new javax.swing.JLabel();

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

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        lblVoidBillTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblVoidBillTitle.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblVoidBillTitle.setForeground(new java.awt.Color(0, 15, 255));
        lblVoidBillTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVoidBillTitle.setText("Void Bill");
        lblVoidBillTitle.setOpaque(true);
        lblVoidBillTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVoidBillTitleMouseClicked(evt);
            }
        });
        jPanel4.add(lblVoidBillTitle, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        lblBillID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblBillID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBillID.setText("Enter Bill Number");
        lblBillID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBillIDMouseClicked(evt);
            }
        });

        txtSaleID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSaleID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaleID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));

        btnVoid.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnVoid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVoid.setText("Void");
        btnVoid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoid.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnVoidMouseMoved(evt);
            }
        });
        btnVoid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoidMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoidMouseExited(evt);
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
                    .addComponent(lblBillID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSaleID)
                    .addComponent(btnVoid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBillID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSaleID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnVoidMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoidMouseMoved
        Border.blueColor(btnVoid);
    }//GEN-LAST:event_btnVoidMouseMoved

    private void btnVoidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoidMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("btnVoid", frm);
        } else {
            SaleManager sm = new SaleManager();
            sm.voidBill(Integer.parseInt(txtSaleID.getText()));
            MsgBox.msgInfo();
            txtSaleID.setText("");
        }
    }//GEN-LAST:event_btnVoidMouseClicked

    private void btnVoidMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoidMouseExited
        Border.WhiteColor(btnVoid);
    }//GEN-LAST:event_btnVoidMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void lblVoidBillTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVoidBillTitleMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblVoidBillTitle", frm);
        }
    }//GEN-LAST:event_lblVoidBillTitleMouseClicked

    private void lblBillIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBillIDMouseClicked
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("lblBillID", frm);
        }
    }//GEN-LAST:event_lblBillIDMouseClicked

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
            java.util.logging.Logger.getLogger(FrmVoidBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVoidBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVoidBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVoidBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmVoidBill dialog = new FrmVoidBill(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnVoid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblBillID;
    private javax.swing.JLabel lblVoidBillTitle;
    private javax.swing.JTextField txtSaleID;
    // End of variables declaration//GEN-END:variables
}
