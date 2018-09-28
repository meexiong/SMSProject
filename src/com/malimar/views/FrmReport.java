/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.views;

/**
 *
 * @author Malimar
 */
import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.LabelManager;
import com.malimar.utils.FrameMove;
import com.malimar.utils.PathReport;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class FrmReport extends javax.swing.JFrame {

    /**
     * Creates new form FrmReport
     */
    Connection c = DatabaseManagerSQL.getConnection();
    String frm, sql;
    
    public FrmReport() {
        initComponents();
        frm = this.getClass().getSimpleName();
        
        lblSystemInfo.setText(LabelManager.hmapForm.get(frm.toUpperCase())[LabelManager.LN]);
        btnReportTeacher.setText(LabelManager.hmapLang.get("btnReportTeacher".concat(frm).toUpperCase())[LabelManager.LN]);
        btnReportEmployee.setText(LabelManager.hmapLang.get("btnReportEmployee".concat(frm).toUpperCase())[LabelManager.LN]);
        btnReportStudentAll.setText(LabelManager.hmapLang.get("btnReportStudentAll".concat(frm).toUpperCase())[LabelManager.LN]);
        btnReportStudentRegistration.setText(LabelManager.hmapLang.get("btnReportStudentRegistration".concat(frm).toUpperCase())[LabelManager.LN]);
        btnReportStudentPayment.setText(LabelManager.hmapLang.get("btnReportStudentPayment".concat(frm).toUpperCase())[LabelManager.LN]);
        btnReportAmountReveivedByDate.setText(LabelManager.hmapLang.get("btnReportAmountReveivedByDate".concat(frm).toUpperCase())[LabelManager.LN]);
        btnReportAmountReveivedByDate.setText(LabelManager.hmapLang.get("btnReportAmountReveivedByDate".concat(frm).toUpperCase())[LabelManager.LN]);
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSystemInfo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnReportTeacher = new com.xzq.osc.JocHyperlink();
        btnReportEmployee = new com.xzq.osc.JocHyperlink();
        btnReportStudentAll = new com.xzq.osc.JocHyperlink();
        btnReportStudentRegistration = new com.xzq.osc.JocHyperlink();
        btnReportStudentPayment = new com.xzq.osc.JocHyperlink();
        btnReportAmountReveivedByDate = new com.xzq.osc.JocHyperlink();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

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
        lblSystemInfo.setText("Report");
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnReportTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/R_Teacher.png"))); // NOI18N
        btnReportTeacher.setText("Report Teacher");
        btnReportTeacher.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnReportTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportTeacherMouseClicked(evt);
            }
        });

        btnReportEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/ReportEmployee.png"))); // NOI18N
        btnReportEmployee.setText("Report Employee");
        btnReportEmployee.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnReportEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportEmployeeMouseClicked(evt);
            }
        });

        btnReportStudentAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/RP_Students.png"))); // NOI18N
        btnReportStudentAll.setText("Report Student All");
        btnReportStudentAll.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnReportStudentAll.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportStudentAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportStudentAllMouseClicked(evt);
            }
        });

        btnReportStudentRegistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/RP_Students.png"))); // NOI18N
        btnReportStudentRegistration.setText("Report Student Registration");
        btnReportStudentRegistration.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnReportStudentRegistration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportStudentRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportStudentRegistrationMouseClicked(evt);
            }
        });

        btnReportStudentPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Payment History_24px.png"))); // NOI18N
        btnReportStudentPayment.setText("Student Payment Report");
        btnReportStudentPayment.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnReportStudentPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportStudentPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportStudentPaymentMouseClicked(evt);
            }
        });
        btnReportStudentPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportStudentPaymentActionPerformed(evt);
            }
        });

        btnReportAmountReveivedByDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Payment History_24px.png"))); // NOI18N
        btnReportAmountReveivedByDate.setText("Amount Received Report By date");
        btnReportAmountReveivedByDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnReportAmountReveivedByDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportAmountReveivedByDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportAmountReveivedByDateMouseClicked(evt);
            }
        });
        btnReportAmountReveivedByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportAmountReveivedByDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReportTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(btnReportEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(btnReportStudentAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(btnReportStudentRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(btnReportStudentPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(btnReportAmountReveivedByDate, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReportTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportStudentAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportStudentRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportStudentPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportAmountReveivedByDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmReport.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnReportTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportTeacherMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("btnReportTeacher", frm);
            }else{
                FrmOpenReport f = new FrmOpenReport();
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int w = (int)d.getWidth();
                int h = (int)d.getHeight();       
                if ("L1".equals(LabelManager.LangType)){                    
                    //JasperPrint p = JasperFillManager.fillReport("src/com/malimar/reports/Report_Teacher_L1.jasper", null, c); 
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path+"Report_Teacher_L1.jasper", null, c);  
                    f.setBounds(0,0,w,h);
                    f.setTitle("ລາຍງານ ອາຈານທັງໝົດ");   
                    f.setContentPane(new JRViewer(p));                    
                    f.setVisible(true);
                }else{
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path+"Report_Teacher_L2.jasper", null, c);                                 
                    f.setBounds(0,0,w,h);
                    f.setTitle("Report Teacher Details");   
                    f.setContentPane(new JRViewer(p));                    
                    f.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnReportTeacherMouseClicked

    private void btnReportEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportEmployeeMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("btnReportEmployee", frm);
            }else{
                FrmOpenReport f = new FrmOpenReport();
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int w = (int)d.getWidth();
                int h = (int)d.getHeight();       
                if ("L1".equals(LabelManager.LangType)){                    
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path+"Report_Employee_L1.jasper", null, c);                                 
                    f.setBounds(0,0,w,h);
                    f.setTitle("ລາຍງານ ພະນັກງານ");   
                    f.setContentPane(new JRViewer(p));                    
                    f.setVisible(true);
                }else{
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path+"Report_Employee_L2.jasper", null, c);                                 
                    f.setBounds(0,0,w,h);
                    f.setTitle("Report Employee Details");   
                    f.setContentPane(new JRViewer(p));                    
                    f.setVisible(true);
                }                
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnReportEmployeeMouseClicked

    private void btnReportStudentAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportStudentAllMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("btnReportStudentAll", frm);
            }else{
                FrmOpenReport f = new FrmOpenReport();
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int w = (int)d.getWidth();
                int h = (int)d.getHeight();       
                if ("L1".equals(LabelManager.LangType)){                    
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path+"Report_Student_L1.jasper", null, c);                                 
                    f.setBounds(0,0,w,h);
                    f.setTitle("ລາຍງານ ພະນັກງານ");   
                    f.setContentPane(new JRViewer(p));                    
                    f.setVisible(true);
                }else{
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path+"Report_Student_L2.jasper", null, c);                                 
                    f.setBounds(0,0,w,h);
                    f.setTitle("Report Employee Details");   
                    f.setContentPane(new JRViewer(p));                    
                    f.setVisible(true);
                }            
                
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnReportStudentAllMouseClicked

    private void btnReportStudentRegistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportStudentRegistrationMouseClicked
        try {
            if (evt.getModifiers() == 6) {
                LabelManager.WindowChangeLabel("btnReportStudentRegistration", frm);
            } else {
                FrmReportStdRegistration frmrt = new FrmReportStdRegistration();
                frmrt.setVisible(true);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnReportStudentRegistrationMouseClicked

    private void btnReportStudentPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportStudentPaymentMouseClicked
       try {
            if (evt.getModifiers() == 6) {
                LabelManager.WindowChangeLabel("btnReportStudentPayment", frm);
            } else {
                FrmReportStdPayment frmrptPayment = new FrmReportStdPayment();
                frmrptPayment.setVisible(true);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnReportStudentPaymentMouseClicked

    private void btnReportStudentPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportStudentPaymentActionPerformed

    }//GEN-LAST:event_btnReportStudentPaymentActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void btnReportAmountReveivedByDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportAmountReveivedByDateMouseClicked
        try {
            if (evt.getModifiers() == 6) {
                LabelManager.WindowChangeLabel("btnReportAmountReveivedByDate", frm);
            } else {
               FrmReportReceivedByDate framR = new FrmReportReceivedByDate();
               framR.setVisible(true);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnReportAmountReveivedByDateMouseClicked

    private void btnReportAmountReveivedByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportAmountReveivedByDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportAmountReveivedByDateActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private com.xzq.osc.JocHyperlink btnReportAmountReveivedByDate;
    private com.xzq.osc.JocHyperlink btnReportEmployee;
    private com.xzq.osc.JocHyperlink btnReportStudentAll;
    private com.xzq.osc.JocHyperlink btnReportStudentPayment;
    private com.xzq.osc.JocHyperlink btnReportStudentRegistration;
    private com.xzq.osc.JocHyperlink btnReportTeacher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblSystemInfo;
    // End of variables declaration//GEN-END:variables
}
