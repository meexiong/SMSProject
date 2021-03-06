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
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.Logo;
import com.malimar.controllers.ReportScheduleTeacherManager;
import com.malimar.controllers.UserPermission;
import com.malimar.models.ReportScheduleTeacher;
import com.malimar.models.UserPermissions;
import com.malimar.utils.Border;
import com.malimar.utils.FrameMove;
import com.malimar.utils.PathReport;
import static com.malimar.utils.PathReport.path;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrmReportScheduleTeacher extends javax.swing.JFrame {

    /**
     * Creates new form FrmReportScheduleTeacher
     */
    Connection c = DatabaseManagerSQL.getConnection();
    String sql, frm;
    DefaultTableModel model= new DefaultTableModel();
            
    ReportScheduleTeacherManager rstm = new ReportScheduleTeacherManager();
    ReportScheduleTeacher rst = new ReportScheduleTeacher();
    
    HashMap<String, Object[]> mapC = null;
    
    UserPermissions up = new UserPermissions();    
    
    public FrmReportScheduleTeacher() {
        initComponents();
        frm = this.getClass().getSimpleName();
        
        Logo lg = new Logo();
        lg.getLogo(this);
        
        Border.blueColor(btnOK);
        Border.blueColor(btnOpen);
        btnOK.setVisible(false);
        btnOpen.setVisible(false);
        
        UserPermission.getPermission_UserAllForm(FrmMain.userNbr, frm, up, "btnOK");
        if (up.getW()==1){
            btnOK.setVisible(true);
        }else if (up.getDenys()==1){
            btnOK.setVisible(false);
        }
        
        UserPermission.getPermission_UserAllForm(FrmMain.userNbr, frm, up, "btnOpen");
        if (up.getW()==1){
            btnOpen.setVisible(true);
        }else if (up.getDenys()==1){
            btnOpen.setVisible(false);
        }
        
        
        
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setBackground(Color.decode("#4169E1"));
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setOpaque(false);
        
        
        
        model = (DefaultTableModel)jTable1.getModel();        
        jTable1.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));
        
        lblSystemInfo.setText(LabelManager.hmapForm.get("FrmReportScheduleTeacher".toUpperCase())[LabelManager.LN]);
        lblYear.setText(LabelManager.hmapLang.get("lblYear".concat(frm).toUpperCase())[LabelManager.LN]);
        lblCourse.setText(LabelManager.hmapLang.get("lblCourse".concat(frm).toUpperCase())[LabelManager.LN]);
        btnOpen.setText(LabelManager.hmapLang.get("btnOpen".concat(frm).toUpperCase())[LabelManager.LN]);
        btnOK.setText(LabelManager.hmapLang.get("btnOK".concat(frm).toUpperCase())[LabelManager.LN]);
              
        
        JTableHeader th = jTable1.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            jTable1.getColumnCount();
            for(int i=0; i < jTable1.getColumnCount(); i++){
                TableColumn tc = tcm.getColumn(i);            
            tc.setHeaderValue(hmapLang.get(jTable1.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        jTable1.setAutoCreateRowSorter(true);
        th.repaint();
        
    }
    public void showCourse(){
        try {
            rst.setYear(txtYear.getText());
            mapC = rstm.getmapCourse(rst.getYear());
            
            Map<String, Object[]> smap = new TreeMap<>(mapC);
            cbbCourse.removeAllItems();
            smap.keySet().forEach((s)->{
            cbbCourse.addItem(s);
        });
            cbbCourse.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbCourse);            
            
        } catch (Exception e) {
            e.printStackTrace();
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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblSystemInfo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblCourse = new javax.swing.JLabel();
        btnOK = new javax.swing.JLabel();
        cbbCourse = new javax.swing.JComboBox<>();
        lblYear = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnOpen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

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

        jPanel6.setLayout(new java.awt.BorderLayout());

        lblSystemInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblSystemInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSystemInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblSystemInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSystemInfo.setText("Report Schedule Teacher");
        lblSystemInfo.setOpaque(true);
        lblSystemInfo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblSystemInfoMouseDragged(evt);
            }
        });
        lblSystemInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSystemInfoMousePressed(evt);
            }
        });
        jPanel6.add(lblSystemInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "stDate", "endDate", "courseName", "semesterName", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(80);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(1).setMinWidth(80);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(220);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(220);
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(140);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(140);
        }

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblCourse.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCourse.setText("Course");
        lblCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCourseMouseClicked(evt);
            }
        });

        btnOK.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnOK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOK.setText("Open");
        btnOK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOK.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOKMouseMoved(evt);
            }
        });
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOKMouseExited(evt);
            }
        });

        cbbCourse.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbCourseMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbCourseMousePressed(evt);
            }
        });
        cbbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCourseActionPerformed(evt);
            }
        });
        cbbCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbCourseKeyPressed(evt);
            }
        });

        lblYear.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblYear.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblYear.setText("Year");
        lblYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYearMouseClicked(evt);
            }
        });

        txtYear.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtYear.setBorder(null);
        txtYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtYearKeyReleased(evt);
            }
        });

        btnOpen.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnOpen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOpen.setText("Preview");
        btnOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOpenMouseMoved(evt);
            }
        });
        btnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpenMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOpenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(txtYear))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(lblCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCourse)
                        .addComponent(cbbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblYear)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmRelationship.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            if (evt.getClickCount()==2){
                int indx = jTable1.getSelectedRow();
                String course = jTable1.getValueAt(indx, 2).toString();
                Map param = new HashMap();
                param.put("CourseName", course);
                FrmOpenReport fp = new FrmOpenReport();
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int h = (int)d.getHeight();
                int w = (int)d.getWidth();
                fp.setBounds(0,0,w,h);
                
                if (LabelManager.LangType.equals("L1")){
                    fp.setTitle("ລາຍງານຫຼັກສູດການຮຽນ");
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path +"Report_Schedule_CourseName_L1.Jasper", param,c);
                    fp.getContentPane().add(new JRViewer(p));
                    fp.setVisible(true);                    
                }else{
                    fp.setTitle("Report Course Study");
                    JasperPrint p = JasperFillManager.fillReport(PathReport.path +"Report_Schedule_CourseName_L2.Jasper", param,c);
                    fp.getContentPane().add(new JRViewer(p));
                    fp.setVisible(true);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

    private void lblCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCourseMouseClicked
        try {
            LabelManager.WindowChangeLabel("lblCourse", frm);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblCourseMouseClicked

    private void btnOKMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseMoved

    }//GEN-LAST:event_btnOKMouseMoved

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
         try {           
             if (evt.getModifiers()==6){
                 LabelManager.WindowChangeLabel("btnOK", frm);
             }else{
                rst.setYear(txtYear.getText());
                String coursename = cbbCourse.getSelectedItem().toString();
                rstm.showSearchCourse(jTable1, model, rst.getYear(), coursename);         
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnOKMouseClicked

    private void btnOKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseExited

    }//GEN-LAST:event_btnOKMouseExited

    private void lblYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblYearMouseClicked
        try {
             LabelManager.WindowChangeLabel("lblYear", frm);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblYearMouseClicked

    private void txtYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyReleased
        try {
            rst.setYear(txtYear.getText());
            rstm.showScheduleTeacher(jTable1, model, rst.getYear());
            showCourse();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtYearKeyReleased

    private void cbbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCourseActionPerformed
        
    }//GEN-LAST:event_cbbCourseActionPerformed

    private void cbbCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCourseMouseClicked
       
    }//GEN-LAST:event_cbbCourseMouseClicked

    private void cbbCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCourseMouseEntered
         
    }//GEN-LAST:event_cbbCourseMouseEntered

    private void cbbCourseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbCourseKeyPressed
        
    }//GEN-LAST:event_cbbCourseKeyPressed

    private void cbbCourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCourseMousePressed
       
    }//GEN-LAST:event_cbbCourseMousePressed

    private void btnOpenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpenMouseMoved

    private void btnOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("btnOpen", frm);
            }else{                
                FrmOpenReport fm = new FrmOpenReport();
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int h = (int)d.getHeight();
                int w = (int)d.getWidth();
                fm.setBounds(0,0,w,h);
                
                Map param = new HashMap();
                param.put("year", txtYear.getText());
                
                if (LabelManager.LangType.equals("L1")){
                   fm.setTitle("ລາຍງານ ຕາຕາລາງການສອນ");                   
                   JasperPrint pr = JasperFillManager.fillReport(PathReport.path+"ScheduleTeacher_L1_Up.jasper", param, c);                   
                   fm.setContentPane(new JRViewer(pr));
                   fm.setVisible(true);                   
                }else{
                   fm.setTitle("Report Schedule Teacher");
                   JasperPrint pr = JasperFillManager.fillReport(PathReport.path+"ScheduleTeacher_L2.jasper", param, c);
                   fm.setContentPane(new JRViewer(pr));
                   fm.setVisible(true);
                }   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnOpenMouseClicked

    private void btnOpenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpenMouseExited

    private void lblSystemInfoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSystemInfoMouseDragged
          FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_lblSystemInfoMouseDragged

    private void lblSystemInfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSystemInfoMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_lblSystemInfoMousePressed

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
            java.util.logging.Logger.getLogger(FrmReportScheduleTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReportScheduleTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReportScheduleTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReportScheduleTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReportScheduleTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnOK;
    private javax.swing.JLabel btnOpen;
    private javax.swing.JComboBox<String> cbbCourse;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblSystemInfo;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
