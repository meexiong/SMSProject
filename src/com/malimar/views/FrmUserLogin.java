/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.LabelManager;
import com.malimar.controllers.UserLoginManager;
import com.malimar.models.UserLogin;
import com.malimar.utils.Border;
import com.malimar.utils.ConvertDateSQL;
import com.malimar.utils.MsgBox;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Malimar
 */
public class FrmUserLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmUserLogin
     */
    Connection c = DatabaseManagerSQL.getConnection();
    String sql, frm;

    UserLoginManager ulm = new UserLoginManager();
    UserLogin ul = new UserLogin();

    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    
    HashMap<String, Object[]>mapGL = null;

    public FrmUserLogin() {
        initComponents();
        frm = this.getClass().getSimpleName();
        model1 = (DefaultTableModel) jTable1.getModel();
        jTable1.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));

        model2 = (DefaultTableModel) jTable2.getModel();
        jTable2.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));

        model3 = (DefaultTableModel) jTable3.getModel();
        jTable3.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));

        txtID.setEnabled(true);

        Border.blueColor(btnShowData);
        Border.blueColor(btnGroupShowData);
        Border.blueColor(btnUpdateGroup);
        Border.blueColor(btnShowDataGroupPermission);
        Border.blueColor(btnUpdateGroupPermission);

        jTabbedPane1.setBackground(Color.WHITE);
        btnShowData.setText(LabelManager.hmapLang.get("btnshowdata".concat(frm).toUpperCase())[LabelManager.LN]);
        lblsearch.setText(LabelManager.hmapLang.get("lblsearch".concat(frm).toUpperCase())[LabelManager.LN]);
        lblgroupl1.setText(LabelManager.hmapLang.get("lblgroupl1".concat(frm).toUpperCase())[LabelManager.LN]);
        lblgroupl2.setText(LabelManager.hmapLang.get("lblgroupl2".concat(frm).toUpperCase())[LabelManager.LN]);
        lblID.setText(LabelManager.hmapLang.get("lblID".concat(frm).toUpperCase())[LabelManager.LN]);
        btnUpdateGroup.setText(LabelManager.hmapLang.get("btnUpdateGroup".concat(frm).toUpperCase())[LabelManager.LN]);
        btnGroupShowData.setText(LabelManager.hmapLang.get("btnGroupShowData".concat(frm).toUpperCase())[LabelManager.LN]);
        btnShowDataGroupPermission.setText(LabelManager.hmapLang.get("btnShowDataGroupPermission".concat(frm).toUpperCase())[LabelManager.LN]);
        cbAll.setText(LabelManager.hmapLang.get("cbAll".concat(frm).toUpperCase())[LabelManager.LN]);
        lblGroupName.setText(LabelManager.hmapLang.get("lblGroupName".concat(frm).toUpperCase())[LabelManager.LN]);
        btnUpdateGroupPermission.setText(LabelManager.hmapLang.get("btnUpdateGroupPermission".concat(frm).toUpperCase())[LabelManager.LN]);
        

        JTableHeader th = jTable1.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        jTable1.getColumnCount();
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(LabelManager.hmapLang.get(jTable1.getModel().getColumnName(i).concat(frm).toUpperCase())[LabelManager.LN]);
        }
        jTable1.setAutoCreateRowSorter(true);
        th.repaint();

        JTableHeader th2 = jTable2.getTableHeader();
        TableColumnModel tcm2 = th2.getColumnModel();
        jTable2.getColumnCount();
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            TableColumn tc2 = tcm2.getColumn(i);
            tc2.setHeaderValue(LabelManager.hmapLang.get(jTable2.getModel().getColumnName(i).concat(frm).toUpperCase())[LabelManager.LN]);
        }
        jTable2.setAutoCreateRowSorter(true);
        th2.repaint();

        JTableHeader th3 = jTable3.getTableHeader();
        TableColumnModel tcm3 = th3.getColumnModel();
        jTable3.getColumnCount();
        for (int i = 0; i < jTable3.getColumnCount(); i++) {
            TableColumn tc3 = tcm3.getColumn(i);
            tc3.setHeaderValue(LabelManager.hmapLang.get(jTable3.getModel().getColumnName(i).concat(frm).toUpperCase())[LabelManager.LN]);
        }
        jTable3.setAutoCreateRowSorter(true);
        th3.repaint();

        lblSystemInfo.setText(LabelManager.hmapForm.get(frm.toUpperCase())[LabelManager.LN]);
        jTabbedPane1.setTitleAt(0, LabelManager.hmapLang.get("TabUser".concat(frm).toUpperCase())[LabelManager.LN]);
        jTabbedPane1.setTitleAt(1, LabelManager.hmapLang.get("TabCreateGroup".concat(frm).toUpperCase())[LabelManager.LN]);
        jTabbedPane1.setTitleAt(2, LabelManager.hmapLang.get("TabAddGroupToLang".concat(frm).toUpperCase())[LabelManager.LN]);

    }

    private void showClearGroupUSER() {
        try {
            txtGroupL1.setText("");
            txtGroupL2.setText("");
            txtID.setText("New");
            txtGroupL1.requestFocus();

        } catch (Exception e) {
        }
    }
    private void showGroupUser(){
        try {
            mapGL = ulm.mapGroup();
            Map<String, Object[]>mp = new TreeMap<>(mapGL);
            cbbGroupUser.removeAllItems();
            mp.keySet().forEach((s)->{
                cbbGroupUser.addItem(s);
            });
            cbbGroupUser.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbGroupUser);
            
            
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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblSystemInfo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblsearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnShowData = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblgroupl1 = new javax.swing.JLabel();
        txtGroupL1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdateGroup = new javax.swing.JLabel();
        lblgroupl2 = new javax.swing.JLabel();
        txtGroupL2 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnGroupShowData = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        lblGroupName = new javax.swing.JLabel();
        cbbGroupUser = new javax.swing.JComboBox<>();
        btnShowDataGroupPermission = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        cbAll = new javax.swing.JCheckBox();
        btnUpdateGroupPermission = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();

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
        lblSystemInfo.setText("Setting User");
        lblSystemInfo.setOpaque(true);
        jPanel6.add(lblSystemInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jPanel7.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "userlogin", "userlogin", "TEmail", "T_nbr", "T_Name_L1", "T_Name_L2", "Teacher"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(250);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(2).setMinWidth(350);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(350);
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(250);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(5).setMinWidth(250);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(6).setMinWidth(100);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jPanel12.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblsearch.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblsearch.setText("Search");
        lblsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsearchMouseClicked(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnShowData.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnShowData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnShowData.setText("ShowData");
        btnShowData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowDataMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtSearch)
                            .addComponent(lblsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowData, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblsearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnShowData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Login User", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        lblgroupl1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblgroupl1.setText("Group Name L1");
        lblgroupl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblgroupl1MouseClicked(evt);
            }
        });

        txtGroupL1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtGroupL1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtGroupL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGroupL1KeyReleased(evt);
            }
        });

        btnUpdateGroup.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnUpdateGroup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUpdateGroup.setText("Update");
        btnUpdateGroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateGroupMouseClicked(evt);
            }
        });

        lblgroupl2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblgroupl2.setText("Group Name L2");
        lblgroupl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblgroupl2MouseClicked(evt);
            }
        });

        txtGroupL2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtGroupL2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtGroupL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGroupL2ActionPerformed(evt);
            }
        });
        txtGroupL2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGroupL2KeyReleased(evt);
            }
        });

        jPanel13.setLayout(new java.awt.BorderLayout());

        jTable2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "lblgroupL1", "lblgroupL1", "lblgroupL2", "lblUsed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.setRowHeight(30);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(0);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(1).setMinWidth(250);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(250);
            jTable2.getColumnModel().getColumn(2).setMinWidth(350);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(350);
            jTable2.getColumnModel().getColumn(3).setMinWidth(150);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jPanel13.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btnGroupShowData.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnGroupShowData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGroupShowData.setText("Data");
        btnGroupShowData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGroupShowData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGroupShowDataMouseClicked(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID");
        lblID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIDMouseClicked(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setText("New");
        txtID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtID.setOpaque(false);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(txtGroupL1)
                    .addComponent(lblgroupl1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(txtGroupL2)
                    .addComponent(lblgroupl2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGroupShowData, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblgroupl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGroupL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGroupShowData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblgroupl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGroupL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Create Group", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        lblGroupName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblGroupName.setText("Group Name L1");
        lblGroupName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGroupNameMouseClicked(evt);
            }
        });

        cbbGroupUser.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbGroupUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnShowDataGroupPermission.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnShowDataGroupPermission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnShowDataGroupPermission.setText("Data");
        btnShowDataGroupPermission.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowDataGroupPermission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowDataGroupPermissionMouseClicked(evt);
            }
        });

        jPanel14.setLayout(new java.awt.BorderLayout());

        jTable3.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FormName", "Checked", "FormName", "Label"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable3.setRowHeight(30);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable3.getColumnModel().getColumn(1).setMinWidth(150);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable3.getColumnModel().getColumn(2).setMinWidth(250);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(250);
            jTable3.getColumnModel().getColumn(3).setMinWidth(350);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(350);
        }

        jPanel14.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        cbAll.setBackground(new java.awt.Color(255, 255, 255));
        cbAll.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbAll.setText("Check All");
        cbAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAllMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbAllMousePressed(evt);
            }
        });
        cbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAllActionPerformed(evt);
            }
        });

        btnUpdateGroupPermission.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnUpdateGroupPermission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUpdateGroupPermission.setText("Update");
        btnUpdateGroupPermission.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateGroupPermission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateGroupPermissionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGroupName, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(cbbGroupUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbAll, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowDataGroupPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateGroupPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 331, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGroupName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbGroupUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowDataGroupPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAll, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateGroupPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add User to Group", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1062, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel11);

        jPanel7.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

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

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmUserLogin.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnShowDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowDataMouseClicked
        try {
            if (evt.getModifiers() == 6) {
                LabelManager.WindowChangeLabel("btnshowData", frm);
            } else {
                ulm.showDataUser(jTable1, model1);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnShowDataMouseClicked

    private void lblsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsearchMouseClicked
        try {
            LabelManager.WindowChangeLabel("lblsearch", frm);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblsearchMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int index = jTable1.getSelectedRow();
            ul.setTeid(Integer.parseInt(jTable1.getValueAt(index, 0).toString()));
            Boolean x = (Boolean) jTable1.getValueAt(index, 1);
            if (x == true) {
                ul.setUserlogin(x);
                ulm.upDateUser(ul);
            } else {
                ul.setUserlogin(x);
                ulm.upDateUser(ul);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            ulm.showSearch(jTable1, model1, txtSearch.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        try {
            if (evt.getModifiers() == 6) {
                if (jTabbedPane1.getSelectedIndex() == 0) {
                    LabelManager.WindowChangeLabel("TabUser", frm);
                } else if (jTabbedPane1.getSelectedIndex() == 1) {
                    LabelManager.WindowChangeLabel("TabCreateGroup", frm);
                } else if (jTabbedPane1.getSelectedIndex() == 1) {
                    LabelManager.WindowChangeLabel("TabAddGroupToLang", frm);
                }

            } else {
                if (jTabbedPane1.getSelectedIndex() == 0) {
                    ulm.showDataUser(jTable1, model1);
                } else if (jTabbedPane1.getSelectedIndex() == 1) {
                    ulm.showDataGroupUser(jTable2, model2);
                } else if (jTabbedPane1.getSelectedIndex() == 2) {
                    showGroupUser();
                    ulm.showDataGroupUserPermission(jTable3, model3);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void lblgroupl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblgroupl1MouseClicked
        try {
            LabelManager.WindowChangeLabel("lblgroupl1", frm);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblgroupl1MouseClicked

    private void txtGroupL1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGroupL1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGroupL1KeyReleased

    private void btnUpdateGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateGroupMouseClicked
        try {
            if (evt.getModifiers() == 6) {
                LabelManager.WindowChangeLabel("btnUpdateGroup", frm);
            } else {
                if (txtGroupL1.getText().equals("") || txtGroupL2.getText().equals("")) {
                    MsgBox.msgWarning();
                    return;
                }
                ul.setGroupName_L1(txtGroupL1.getText());
                ul.setGroupName_L2(txtGroupL2.getText());
                if (txtID.getText().equals("New")) {
                    ul.setUsed(true);
                    ulm.insertGroupUser(ul);
                    ulm.showDataGroupUser(jTable2, model2);
                    showClearGroupUSER();
                } else {
                    ul.setGRUID(Integer.parseInt(txtID.getText()));
                    ulm.updateGroupUser(ul);
                    ulm.showDataGroupUser(jTable2, model2);
                    showClearGroupUSER();
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUpdateGroupMouseClicked

    private void lblgroupl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblgroupl2MouseClicked
        try {
            LabelManager.WindowChangeLabel("lblgroupL2", frm);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblgroupl2MouseClicked

    private void txtGroupL2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGroupL2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGroupL2KeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            int index = jTable2.getSelectedRow();
            txtID.setText(jTable2.getValueAt(index, 0).toString());
            txtGroupL1.setText(jTable2.getValueAt(index, 1).toString());
            txtGroupL2.setText(jTable2.getValueAt(index, 2).toString());

            Boolean x = (Boolean) jTable2.getValueAt(index, 3);
            if (x == true) {
                ul.setGRUID(Integer.parseInt(txtID.getText()));
                ul.setUsed(x);
                ulm.updateUsedGroupUser(ul);
                showClearGroupUSER();

            } else {
                ul.setGRUID(Integer.parseInt(txtID.getText()));
                ul.setUsed(x);
                ulm.updateUsedGroupUser(ul);
                showClearGroupUSER();
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnGroupShowDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGroupShowDataMouseClicked
        try {
            if (evt.getModifiers() == 6) {
                LabelManager.WindowChangeLabel("btnGroupShowData", frm);
            } else {
                ulm.showDataGroupUser(jTable2, model2);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnGroupShowDataMouseClicked

    private void lblIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIDMouseClicked
        LabelManager.WindowChangeLabel("lblID", frm);
    }//GEN-LAST:event_lblIDMouseClicked

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtGroupL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGroupL2ActionPerformed
        try {
            if (txtGroupL1.getText().equals("") || txtGroupL2.getText().equals("")) {
                MsgBox.msgWarning();
                return;
            }
            ul.setGroupName_L1(txtGroupL1.getText());
            ul.setGroupName_L2(txtGroupL2.getText());
            if (txtID.getText().equals("New")) {
                ul.setUsed(true);
                ulm.insertGroupUser(ul);
                ulm.showDataGroupUser(jTable2, model2);
                showClearGroupUSER();
            } else {
                ul.setGRUID(Integer.parseInt(txtID.getText()));
                ulm.updateGroupUser(ul);
                ulm.showDataGroupUser(jTable2, model2);
                showClearGroupUSER();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtGroupL2ActionPerformed

    private void lblGroupNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGroupNameMouseClicked
        LabelManager.WindowChangeLabel("lblGroupName", frm);
    }//GEN-LAST:event_lblGroupNameMouseClicked

    private void btnShowDataGroupPermissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowDataGroupPermissionMouseClicked
        try {
            if (evt.getModifiers() == 6) {
                LabelManager.WindowChangeLabel("btnShowDataGroupPermission", frm);
            } else {
                ulm.showDataGroupUserPermission(jTable3, model3);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnShowDataGroupPermissionMouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void cbAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAllMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("cbAll", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbAllMouseClicked

    private void cbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAllActionPerformed
        try {
            if (cbAll.isSelected() == true) {
                TableModel m = jTable3.getModel();
                int cols = 1;
                for (int x1 = 0; x1 < m.getRowCount(); x1++) {
                    jTable3.setValueAt(true, x1, cols);
                }
            } else {
                ulm.showDataGroupUserPermission(jTable3, model3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbAllActionPerformed

    private void cbAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAllMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAllMousePressed

    private void btnUpdateGroupPermissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateGroupPermissionMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("btnUpdateGroupPermission", frm);
            }else{
                String gr = cbbGroupUser.getSelectedItem().toString();
                
                DateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date dt = new Date();
                String date = dtFormat.format(dt);
                Date dt1 = new Date();
                dt1 = df.parse(date);
                        
                int index = jTable3.getRowCount(); 
                for (int x1 = 0; x1<index; x1++){
                    Boolean x = (Boolean) jTable3.getValueAt(x1, 1);
                    if (x == true){
                        
                        ul.setSLANGID(Integer.parseInt(jTable3.getValueAt(x1, 0).toString()));
                        ul.setGRUID(Integer.parseInt(mapGL.get(gr)[0].toString()));
                        ul.setCreateDate(ConvertDateSQL.convertUtilDateToSqlDate(dt1));
                        ul.setReads(true);
                        ul.setWrite(true);
                        ul.setDenys(true);                        
                        ulm.showCheckGroupUserLang(ul);                
                    }
                }
                MsgBox.msgInfo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateGroupPermissionMouseClicked

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
            java.util.logging.Logger.getLogger(FrmUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnGroupShowData;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnShowData;
    private javax.swing.JLabel btnShowDataGroupPermission;
    private javax.swing.JLabel btnUpdateGroup;
    private javax.swing.JLabel btnUpdateGroupPermission;
    private javax.swing.JCheckBox cbAll;
    private javax.swing.JComboBox<String> cbbGroupUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblGroupName;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblSystemInfo;
    private javax.swing.JLabel lblgroupl1;
    private javax.swing.JLabel lblgroupl2;
    private javax.swing.JLabel lblsearch;
    private javax.swing.JTextField txtGroupL1;
    private javax.swing.JTextField txtGroupL2;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
