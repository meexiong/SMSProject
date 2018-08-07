
package com.malimar.views;

import com.malimar.controllers.AccessDBManager;
import com.malimar.models.AccessDatasource;
import com.malimar.utils.Border;
import com.malimar.utils.MsgBox;

public class FrmDatasource extends javax.swing.JFrame {
    AccessDatasource ad = new AccessDatasource();
    AccessDBManager am = new AccessDBManager();
    public FrmDatasource() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtServerName = new javax.swing.JTextField();
        txtDatabaseName = new javax.swing.JTextField();
        txtUserLogin = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        btnRead = new javax.swing.JLabel();
        btnTest = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSystemInfo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255), 2));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Server_24px.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Database_24px.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Name_24px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Password 1_24px.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/P_24px.png"))); // NOI18N

        txtServerName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtServerName.setBorder(null);

        txtDatabaseName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtDatabaseName.setBorder(null);

        txtUserLogin.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtUserLogin.setBorder(null);

        txtPort.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtPort.setBorder(null);

        btnRead.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnRead.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRead.setText("Read");
        btnRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRead.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReadMouseMoved(evt);
            }
        });
        btnRead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReadMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReadMouseExited(evt);
            }
        });

        btnTest.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTest.setText("Test");
        btnTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTest.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTestMouseMoved(evt);
            }
        });
        btnTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTestMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTestMouseExited(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("Save");
        btnSave.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveMouseMoved(evt);
            }
        });
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
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

        lblSystemInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblSystemInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSystemInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblSystemInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSystemInfo.setText("Datasource Setting");
        lblSystemInfo.setOpaque(true);
        jPanel4.add(lblSystemInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPassword.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPassword))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtServerName))
                                    .addComponent(jSeparator1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRead, btnSave, btnTest});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtServerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, txtDatabaseName, txtPassword, txtPort, txtServerName, txtUserLogin});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmMain.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnReadMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadMouseMoved
        Border.blueColor(btnRead);
    }//GEN-LAST:event_btnReadMouseMoved

    private void btnTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMouseMoved
        Border.blueColor(btnTest);
    }//GEN-LAST:event_btnTestMouseMoved

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnReadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadMouseExited
        Border.WhiteColor(btnRead);
    }//GEN-LAST:event_btnReadMouseExited

    private void btnTestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMouseExited
        Border.WhiteColor(btnTest);
    }//GEN-LAST:event_btnTestMouseExited

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnReadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReadMouseClicked
        am.readDatasource(ad);
        txtServerName.setText(ad.getServerName());
        txtDatabaseName.setText(ad.getDatabaseName());
        txtUserLogin.setText(ad.getUserLogin());
        txtPassword.setText(ad.getPassword());
        txtPort.setText(ad.getPort());
    }//GEN-LAST:event_btnReadMouseClicked

    private void btnTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMouseClicked
        if(am.testDatasource(ad)==true){
            MsgBox.msgInfo();
        }else{
            MsgBox.msgWarning();
        }
    }//GEN-LAST:event_btnTestMouseClicked

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
            java.util.logging.Logger.getLogger(FrmDatasource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDatasource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDatasource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDatasource.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDatasource().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnRead;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblSystemInfo;
    private javax.swing.JTextField txtDatabaseName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServerName;
    private javax.swing.JTextField txtUserLogin;
    // End of variables declaration//GEN-END:variables
}
