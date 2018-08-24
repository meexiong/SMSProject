
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.RegistrationManager;
import com.malimar.utils.Border;
import com.malimar.utils.ClearTable;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrmRegistation extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelRegistration = new DefaultTableModel();
    String frm;
    Connection c = DatabaseManagerSQL.getConnection();
    HashMap<String, Object[]>mapSemester = null;
    HashMap<String, Object[]>mapStudent = null;
    RegistrationManager rm = new RegistrationManager();
    public FrmRegistation() {
        initComponents();
        showRegistation();
        getcmbSemester();
        getcmbStudent();
    }
    private void showRegistation(){
        frm = this.getClass().getSimpleName();
        tableCourse.getTableHeader().setFont(new Font("Saysettha OT",Font.BOLD,12));
        tableRegistration.getTableHeader().setFont(new Font("Saysettha OT",Font.BOLD,12));
        model = (DefaultTableModel) tableCourse.getModel();
        modelRegistration=(DefaultTableModel) tableRegistration.getModel();
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        tableCourse.setShowGrid(true);
        tableCourse.getTableHeader().setBackground(Color.decode("#4169E1"));
        tableCourse.getTableHeader().setForeground(Color.WHITE);
        tableCourse.getTableHeader().setOpaque(false);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        tableRegistration.setShowGrid(true);
        tableRegistration.getTableHeader().setBackground(Color.decode("#4169E1"));
        tableRegistration.getTableHeader().setForeground(Color.WHITE);
        tableRegistration.getTableHeader().setOpaque(false);
        lblSemester.setText(hmapLang.get("lblSemester".concat(frm).toUpperCase())[LN]);
        lblStudent.setText(hmapLang.get("lblStudent".concat(frm).toUpperCase())[LN]);
        lblStudentNbr.setText(hmapLang.get("lblStudentNbr".concat(frm).toUpperCase())[LN]);
        lblGender.setText(hmapLang.get("lblGender".concat(frm).toUpperCase())[LN]);
        lblNationality.setText(hmapLang.get("lblNationality".concat(frm).toUpperCase())[LN]);
        lblEthnic.setText(hmapLang.get("lblEthnic".concat(frm).toUpperCase())[LN]);
        lblReligion.setText(hmapLang.get("lblReligion".concat(frm).toUpperCase())[LN]);
        btnSave.setText(hmapLang.get("btnSave".concat(frm).toUpperCase())[LN]);
        lblID.setText(hmapLang.get("lblID".concat(frm).toUpperCase())[LN]);
        lblRegistration.setText(hmapLang.get("lblRegistration".concat(frm).toUpperCase())[LN]);
        lblSubTotal.setText(hmapLang.get("lblSubTotal".concat(frm).toUpperCase())[LN]);
        lblDiscount.setText(hmapLang.get("lblDiscount".concat(frm).toUpperCase())[LN]);
        lblDiscountAmount.setText(hmapLang.get("lblDiscountAmount".concat(frm).toUpperCase())[LN]);
        lblVAT.setText(hmapLang.get("lblVAT".concat(frm).toUpperCase())[LN]);
        lblVATAmount.setText(hmapLang.get("lblVATAmount".concat(frm).toUpperCase())[LN]);
        lblGrandTotal.setText(hmapLang.get("lblGrandTotal".concat(frm).toUpperCase())[LN]);
        JTableHeader th = tableCourse.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        tableCourse.getColumnCount();
        for (int i = 2; i < tableCourse.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(hmapLang.get(tableCourse.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        tableCourse.setAutoCreateRowSorter(true);
        th.repaint();
        
        JTableHeader th2 = tableRegistration.getTableHeader();
        TableColumnModel tcm2 = th2.getColumnModel();
        tableRegistration.getColumnCount();
        for (int i = 1; i < tableRegistration.getColumnCount(); i++) {
            TableColumn tc2 = tcm2.getColumn(i);
            tc2.setHeaderValue(hmapLang.get(tableRegistration.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        tableRegistration.setAutoCreateRowSorter(true);
        th2.repaint();
        rm.createCheck(tableCourse, model);
        rm.createCheck(tableRegistration, modelRegistration);
    }
    private void getcmbSemester() {
        try {
            mapSemester = rm.mapSemester();
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
    private void getcmbStudent() {
        try {
            mapStudent = rm.mapStudent();
            Map<String, Object[]> ms = new TreeMap<>(mapStudent);
            cmbStudent.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbStudent.addItem(s);
            });
            cmbStudent.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbStudent);
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnMinimize2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblRegistration = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCourse = new javax.swing.JTable();
        lblStudent = new javax.swing.JLabel();
        cmbStudent = new javax.swing.JComboBox<>();
        txtStudentID = new javax.swing.JTextField();
        lblStudentNbr = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        txtNational = new javax.swing.JTextField();
        lblNationality = new javax.swing.JLabel();
        lblEthnic = new javax.swing.JLabel();
        txtEthnic = new javax.swing.JTextField();
        txtReligion = new javax.swing.JTextField();
        lblReligion = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lblSemester = new javax.swing.JLabel();
        cmbSemester = new javax.swing.JComboBox<>();
        btnNewStudent = new javax.swing.JButton();
        btnSave = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRegistration = new javax.swing.JTable();
        lblSubTotal = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtID2 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        lblDiscountAmount = new javax.swing.JLabel();
        lblVATAmount = new javax.swing.JLabel();
        txtID3 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        lblGrandTotal = new javax.swing.JLabel();
        txtID4 = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        lblDiscount = new javax.swing.JLabel();
        txtID5 = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        lblVAT = new javax.swing.JLabel();
        txtID6 = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        btnSave1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnMinimize2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Minimize Window_30px.png"))); // NOI18N
        btnMinimize2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimize2MouseClicked(evt);
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

        lblRegistration.setBackground(new java.awt.Color(255, 255, 255));
        lblRegistration.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblRegistration.setForeground(new java.awt.Color(0, 15, 255));
        lblRegistration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistration.setText("Registation Information");
        lblRegistration.setOpaque(true);
        jPanel5.add(lblRegistration, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimize2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMinimize2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        tableCourse.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        tableCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "lblDID", "lblCourse", "lblTeacher", "lblRoom", "lblPrice", "lblSunday", "lblMonday", "lblTuesday", "lblWednesday", "lblThursday", "lblFriday", "lblSaturday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCourse.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableCourse.setRowHeight(25);
        tableCourse.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableCourse.setSelectionForeground(java.awt.Color.red);
        jScrollPane1.setViewportView(tableCourse);
        if (tableCourse.getColumnModel().getColumnCount() > 0) {
            tableCourse.getColumnModel().getColumn(0).setMinWidth(50);
            tableCourse.getColumnModel().getColumn(0).setMaxWidth(50);
            tableCourse.getColumnModel().getColumn(1).setMinWidth(0);
            tableCourse.getColumnModel().getColumn(1).setMaxWidth(0);
            tableCourse.getColumnModel().getColumn(2).setMinWidth(200);
            tableCourse.getColumnModel().getColumn(2).setMaxWidth(200);
            tableCourse.getColumnModel().getColumn(3).setMinWidth(150);
            tableCourse.getColumnModel().getColumn(3).setMaxWidth(150);
            tableCourse.getColumnModel().getColumn(4).setMinWidth(60);
            tableCourse.getColumnModel().getColumn(4).setMaxWidth(60);
            tableCourse.getColumnModel().getColumn(5).setMinWidth(100);
            tableCourse.getColumnModel().getColumn(5).setMaxWidth(100);
            tableCourse.getColumnModel().getColumn(6).setMinWidth(70);
            tableCourse.getColumnModel().getColumn(6).setMaxWidth(70);
            tableCourse.getColumnModel().getColumn(7).setMinWidth(70);
            tableCourse.getColumnModel().getColumn(7).setMaxWidth(70);
            tableCourse.getColumnModel().getColumn(8).setMinWidth(70);
            tableCourse.getColumnModel().getColumn(8).setMaxWidth(70);
            tableCourse.getColumnModel().getColumn(9).setMinWidth(85);
            tableCourse.getColumnModel().getColumn(9).setMaxWidth(85);
            tableCourse.getColumnModel().getColumn(10).setMinWidth(70);
            tableCourse.getColumnModel().getColumn(10).setMaxWidth(70);
            tableCourse.getColumnModel().getColumn(11).setMinWidth(70);
            tableCourse.getColumnModel().getColumn(11).setMaxWidth(70);
            tableCourse.getColumnModel().getColumn(12).setMinWidth(70);
            tableCourse.getColumnModel().getColumn(12).setMaxWidth(70);
        }

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblStudent.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblStudent.setText("Student");

        cmbStudent.setEditable(true);
        cmbStudent.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStudentActionPerformed(evt);
            }
        });

        txtStudentID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStudentID.setBorder(null);

        lblStudentNbr.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblStudentNbr.setText("Student#");

        lblGender.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblGender.setText("Gender");

        txtGender.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtGender.setBorder(null);

        txtNational.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtNational.setBorder(null);

        lblNationality.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblNationality.setText("Nationality");

        lblEthnic.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblEthnic.setText("Ethnic");

        txtEthnic.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtEthnic.setBorder(null);

        txtReligion.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtReligion.setBorder(null);

        lblReligion.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblReligion.setText("Religion");

        lblID.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID");

        txtID.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setText("New");
        txtID.setBorder(null);

        lblSemester.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSemester.setText("Semester");

        cmbSemester.setEditable(true);
        cmbSemester.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemesterActionPerformed(evt);
            }
        });

        btnNewStudent.setText("...");
        btnNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewStudentActionPerformed(evt);
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tableRegistration.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        tableRegistration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "lblStudentNbr", "lblStudent", "lblCourse", "lblPrice"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegistration.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableRegistration.setRowHeight(25);
        tableRegistration.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableRegistration.setSelectionForeground(java.awt.Color.red);
        jScrollPane2.setViewportView(tableRegistration);
        if (tableRegistration.getColumnModel().getColumnCount() > 0) {
            tableRegistration.getColumnModel().getColumn(0).setMinWidth(50);
            tableRegistration.getColumnModel().getColumn(0).setMaxWidth(50);
            tableRegistration.getColumnModel().getColumn(1).setMinWidth(100);
            tableRegistration.getColumnModel().getColumn(1).setMaxWidth(100);
            tableRegistration.getColumnModel().getColumn(2).setMinWidth(250);
            tableRegistration.getColumnModel().getColumn(2).setMaxWidth(250);
            tableRegistration.getColumnModel().getColumn(3).setMinWidth(200);
            tableRegistration.getColumnModel().getColumn(3).setMaxWidth(200);
            tableRegistration.getColumnModel().getColumn(4).setMinWidth(110);
            tableRegistration.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        lblSubTotal.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("SubTotal");

        txtID1.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID1.setText("0.00");
        txtID1.setBorder(null);

        txtID2.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID2.setText("0.00");
        txtID2.setBorder(null);

        lblDiscountAmount.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblDiscountAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscountAmount.setText("Discount Amount");

        lblVATAmount.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblVATAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVATAmount.setText("VAT Amount");

        txtID3.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID3.setText("0.00");
        txtID3.setBorder(null);

        lblGrandTotal.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblGrandTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGrandTotal.setText("GrandTotal");

        txtID4.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID4.setText("0.00");
        txtID4.setBorder(null);

        lblDiscount.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblDiscount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiscount.setText("Discount");

        txtID5.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID5.setText("0.00");
        txtID5.setBorder(null);

        lblVAT.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblVAT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVAT.setText("VAT");

        txtID6.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID6.setText("0.00");
        txtID6.setBorder(null);

        btnSave1.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnSave1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave1.setText("Print");
        btnSave1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSave1MouseMoved(evt);
            }
        });
        btnSave1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSave1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSave1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(btnNewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStudentID)
                            .addComponent(jSeparator1)
                            .addComponent(lblStudentNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNational, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEthnic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEthnic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtReligion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReligion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtID5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtID6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblVAT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtID3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblVATAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDiscountAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtID2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(txtID4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblGrandTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtID1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblStudent)
                    .addComponent(lblSemester)
                    .addComponent(lblStudentNbr)
                    .addComponent(lblGender)
                    .addComponent(lblNationality)
                    .addComponent(lblEthnic)
                    .addComponent(lblReligion))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtReligion)
                    .addComponent(txtEthnic)
                    .addComponent(txtNational)
                    .addComponent(txtGender)
                    .addComponent(txtStudentID)
                    .addComponent(cmbStudent)
                    .addComponent(cmbSemester)
                    .addComponent(btnNewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator3)
                        .addComponent(jSeparator4)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubTotal)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lblDiscountAmount)
                                .addGap(1, 1, 1)
                                .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDiscount)
                                .addGap(1, 1, 1)
                                .addComponent(txtID5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblVATAmount)
                                .addGap(1, 1, 1)
                                .addComponent(txtID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblVAT)
                                .addGap(1, 1, 1)
                                .addComponent(txtID6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addComponent(lblGrandTotal)
                        .addGap(1, 1, 1)
                        .addComponent(txtID4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnNewStudent, cmbSemester, cmbStudent, txtEthnic, txtGender, txtID, txtNational, txtReligion, txtStudentID});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblEthnic, lblGender, lblNationality, lblReligion, lblStudent, lblStudentNbr});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimize2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimize2MouseClicked
        this.setState(FrmRegistation.ICONIFIED);
    }//GEN-LAST:event_btnMinimize2MouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("btnSave", frm);
        } else {

        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void cmbStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStudentActionPerformed
        try {
            if(cmbStudent.getSelectedIndex()==-1){
                txtStudentID.setText("");
                txtGender.setText("");
                txtNational.setText("");
                txtEthnic.setText("");
                txtReligion.setText("");
            }else{
                String student = cmbStudent.getSelectedItem().toString();
                txtStudentID.setText(mapStudent.get(student)[1].toString());
                txtGender.setText(mapStudent.get(student)[3].toString());
                txtNational.setText(mapStudent.get(student)[4].toString());
                txtEthnic.setText(mapStudent.get(student)[5].toString());
                txtReligion.setText(mapStudent.get(student)[6].toString());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbStudentActionPerformed

    private void cmbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemesterActionPerformed
       if(cmbSemester.getSelectedIndex()==-1){
           ClearTable.clearFirstLoad(tableCourse, model);
       }else{
           ClearTable.clearFirstLoad(tableCourse, model);
           String semester = cmbSemester.getSelectedItem().toString();
           rm.showSemseterDetails(model, (int) mapSemester.get(semester)[0]);
       }
    }//GEN-LAST:event_cmbSemesterActionPerformed

    private void btnNewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewStudentActionPerformed
        FrmNewStudent frmNew = new FrmNewStudent(this, rootPaneCheckingEnabled, "New");
        frmNew.setVisible(true);
        getcmbStudent();
    }//GEN-LAST:event_btnNewStudentActionPerformed

    private void btnSave1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSave1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave1MouseMoved

    private void btnSave1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSave1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave1MouseClicked

    private void btnSave1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSave1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave1MouseExited

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
            java.util.logging.Logger.getLogger(FrmRegistation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize2;
    private javax.swing.JButton btnNewStudent;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnSave1;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JComboBox<String> cmbStudent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblDiscountAmount;
    private javax.swing.JLabel lblEthnic;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblRegistration;
    private javax.swing.JLabel lblReligion;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblStudentNbr;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblVAT;
    private javax.swing.JLabel lblVATAmount;
    private javax.swing.JTable tableCourse;
    private javax.swing.JTable tableRegistration;
    private javax.swing.JTextField txtEthnic;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtID3;
    private javax.swing.JTextField txtID4;
    private javax.swing.JTextField txtID5;
    private javax.swing.JTextField txtID6;
    private javax.swing.JTextField txtNational;
    private javax.swing.JTextField txtReligion;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}
