/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.GetMaxID;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.Logo;
import com.malimar.controllers.NextCellActioin;
import com.malimar.controllers.SchaduleManager;
import com.malimar.controllers.TableAlignmentHeader;
import com.malimar.models.Schedule;
import com.malimar.utils.Border;
import com.malimar.utils.ClearTable;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import static com.malimar.views.FrmMain.userNbr;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Malimar
 */
public class FrmSchedule extends javax.swing.JFrame {
    Connection c = DatabaseManagerSQL.getConnection();
    String sql, frm;
    DefaultTableModel model = new DefaultTableModel();
    HashMap<String, Object[]>mapSem = null;
    HashMap<String, Object[]>mapCourse = null;
    HashMap<String, Object[]>mapTeacher = null;
    HashMap<String, Object[]>mapRoom = null;
    SchaduleManager sm = new SchaduleManager();
    Schedule sh = new Schedule();
    public FrmSchedule() {
        initComponents();
        Logo lg = new Logo();
        lg.getLogo(this);
        frm = this.getClass().getSimpleName();
        showSchedule();
        getcmbSemester();
        getcmbCourse();
        getcmbTeacher();
        getcmbRoom();
        Date dateNow = new Date();
        txtCreateDate.setDate(dateNow);
    }
    private void showSchedule() {
        table.getTableHeader().setFont(new Font("Saysettha OT", Font.BOLD, 12));
        model = (DefaultTableModel) table.getModel();
        ((JTextFieldDateEditor) txtStartDate.getDateEditor()).setDisabledTextColor(Color.BLACK);
        ((JTextFieldDateEditor) txtCreateDate.getDateEditor()).setDisabledTextColor(Color.BLACK);
        ((JTextFieldDateEditor) txtEndDate.getDateEditor()).setDisabledTextColor(Color.BLACK);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.getTableHeader().setBackground(Color.decode("#4169E1"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
        lblSemester.setText(hmapLang.get("lblSemester".concat(frm).toUpperCase())[LN]);
        lblStartDate.setText(hmapLang.get("lblStartDate".concat(frm).toUpperCase())[LN]);
        lblEndDate.setText(hmapLang.get("lblEndDate".concat(frm).toUpperCase())[LN]);
        lblCreateDate.setText(hmapLang.get("lblCreateDate".concat(frm).toUpperCase())[LN]);
        lblStatus.setText(hmapLang.get("lblStatus".concat(frm).toUpperCase())[LN]);
        lblStatus.setText(hmapLang.get("lblStatus".concat(frm).toUpperCase())[LN]);
        btnSave.setText(hmapLang.get("btnSave".concat(frm).toUpperCase())[LN]);
        lblScheduleInfo.setText(hmapLang.get("lblScheduleInfo".concat(frm).toUpperCase())[LN]);
        lblID.setText(hmapLang.get("lblID".concat(frm).toUpperCase())[LN]);
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        table.getColumnCount();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        table.setAutoCreateRowSorter(true);
        th.repaint();
        table.getColumnModel().getColumn(0).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(1).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
        table.getColumnModel().getColumn(2).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
        table.getColumnModel().getColumn(3).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
        table.getColumnModel().getColumn(4).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.RIGHT));
        table.getColumnModel().getColumn(5).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(6).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(7).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(8).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(9).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(10).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(11).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(12).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(13).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(14).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(15).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(16).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(17).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(18).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.CENTER));
        table.getColumnModel().getColumn(19).setHeaderRenderer(new TableAlignmentHeader(SwingConstants.LEFT));
        DefaultTableCellRenderer CenterRenderer = new DefaultTableCellRenderer();
        CenterRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(8).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(10).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(12).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(14).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(16).setCellRenderer(CenterRenderer);
        table.getColumnModel().getColumn(18).setCellRenderer(CenterRenderer);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
    }

    private void getcmbSemester() {
        try {
            mapSem = sm.mapSemester();
            Map<String, Object[]> ms = new TreeMap<>(mapSem);
            cmbSemester.removeAllItems();
            ms.keySet().forEach((s) -> {
                cmbSemester.addItem(s);
            });
            cmbSemester.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbSemester);

        } catch (Exception e) {
        }
    }
    private void getcmbCourse(){
        try {
            mapCourse = sm.mapCourse();
            Map<String, Object[]>ms = new TreeMap<>(mapCourse);
            cmbCourse.removeAllItems();
            ms.keySet().forEach((s)->{
                cmbCourse.addItem(s);
            });
//            cmbCourse.setSelectedIndex(-1);
//            AutoCompleteDecorator.decorate(cmbCourse);
        } catch (Exception e) {
        }
    }
    private void getcmbTeacher(){
        try {
            mapTeacher = sm.mapTeacher();
            Map<String, Object[]>ms = new TreeMap<>(mapTeacher);
            cmbTeacher.removeAllItems();
            ms.keySet().forEach((s)->{
                cmbTeacher.addItem(s);
            });
//            cmbTeacher.setSelectedIndex(-1);
//            AutoCompleteDecorator.decorate(cmbTeacher);
        } catch (Exception e) {
        }
    }
    private void getcmbRoom(){
        try {
            mapRoom = sm.mapRoom();
            Map<String, Object[]>ms = new TreeMap<>(mapRoom);
            cmbRoom.removeAllItems();
            ms.keySet().forEach((s)->{
                cmbRoom.addItem(s);
            });
//            cmbRoom.setSelectedIndex(-1);
//            AutoCompleteDecorator.decorate(cmbRoom);
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbTeacher = new javax.swing.JComboBox<>();
        cmbCourse = new javax.swing.JComboBox<>();
        cmbRoom = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblScheduleInfo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblSemester = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        cmbSemester = new javax.swing.JComboBox<>();
        lblStartDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        lblStatus = new javax.swing.JLabel();
        chStatus = new javax.swing.JCheckBox();
        txtCreateDate = new com.toedter.calendar.JDateChooser();
        lblCreateDate = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        btnPlus = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        cmbTeacher.setEditable(true);
        cmbTeacher.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbTeacher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCourse.setEditable(true);
        cmbCourse.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCourseActionPerformed(evt);
            }
        });

        cmbRoom.setEditable(true);
        cmbRoom.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        lblScheduleInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblScheduleInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblScheduleInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblScheduleInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScheduleInfo.setText("Schadule");
        lblScheduleInfo.setOpaque(true);
        lblScheduleInfo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblScheduleInfoMouseDragged(evt);
            }
        });
        lblScheduleInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblScheduleInfoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblScheduleInfoMousePressed(evt);
            }
        });
        jPanel6.add(lblScheduleInfo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
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

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "lblRowNbr", "lblCourse", "lblTeacher", "lblRoom", "lblPrice", "lblSunday", "lblSunTime", "lblModay", "lblMonTime", "lblTuesday", "lblTuesTime", "lblWednesday", "lblWedTime", "lblThursday", "lblThurTime", "lblFriday", "lblFridayTime", "lblSaturday", "lblSaturdayTime", "lblID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(27);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(java.awt.Color.red);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMinWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(200);
            table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cmbCourse));
            table.getColumnModel().getColumn(2).setMinWidth(150);
            table.getColumnModel().getColumn(2).setMaxWidth(150);
            table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cmbTeacher));
            table.getColumnModel().getColumn(3).setMinWidth(60);
            table.getColumnModel().getColumn(3).setMaxWidth(60);
            table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cmbRoom));
            table.getColumnModel().getColumn(4).setMinWidth(120);
            table.getColumnModel().getColumn(4).setMaxWidth(120);
            table.getColumnModel().getColumn(5).setMinWidth(80);
            table.getColumnModel().getColumn(5).setMaxWidth(80);
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(70);
            table.getColumnModel().getColumn(7).setMaxWidth(70);
            table.getColumnModel().getColumn(8).setMinWidth(0);
            table.getColumnModel().getColumn(8).setMaxWidth(0);
            table.getColumnModel().getColumn(9).setMinWidth(70);
            table.getColumnModel().getColumn(9).setMaxWidth(70);
            table.getColumnModel().getColumn(10).setMinWidth(0);
            table.getColumnModel().getColumn(10).setMaxWidth(0);
            table.getColumnModel().getColumn(11).setMinWidth(85);
            table.getColumnModel().getColumn(11).setMaxWidth(85);
            table.getColumnModel().getColumn(12).setMinWidth(0);
            table.getColumnModel().getColumn(12).setMaxWidth(0);
            table.getColumnModel().getColumn(13).setMinWidth(70);
            table.getColumnModel().getColumn(13).setMaxWidth(70);
            table.getColumnModel().getColumn(14).setMinWidth(0);
            table.getColumnModel().getColumn(14).setMaxWidth(0);
            table.getColumnModel().getColumn(15).setMinWidth(70);
            table.getColumnModel().getColumn(15).setMaxWidth(70);
            table.getColumnModel().getColumn(16).setMinWidth(0);
            table.getColumnModel().getColumn(16).setMaxWidth(0);
            table.getColumnModel().getColumn(17).setMinWidth(70);
            table.getColumnModel().getColumn(17).setMaxWidth(70);
            table.getColumnModel().getColumn(18).setMinWidth(0);
            table.getColumnModel().getColumn(18).setMaxWidth(0);
            table.getColumnModel().getColumn(19).setMinWidth(0);
            table.getColumnModel().getColumn(19).setMaxWidth(0);
        }

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblSemester.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSemester.setText("Semester");
        lblSemester.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSemesterMouseClicked(evt);
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

        cmbSemester.setEditable(true);
        cmbSemester.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbSemester.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbSemester.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSemesterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbSemesterMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbSemesterMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbSemesterMouseReleased(evt);
            }
        });
        cmbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemesterActionPerformed(evt);
            }
        });

        lblStartDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStartDate.setText("Start Date");
        lblStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStartDateMouseClicked(evt);
            }
        });

        lblEndDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblEndDate.setText("End Date");
        lblEndDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEndDateMouseClicked(evt);
            }
        });

        txtStartDate.setBackground(new java.awt.Color(255, 255, 255));
        txtStartDate.setDateFormatString("dd-MM-yyyy");
        txtStartDate.setEnabled(false);
        txtStartDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStartDate.setOpaque(false);

        txtEndDate.setBackground(new java.awt.Color(255, 255, 255));
        txtEndDate.setDateFormatString("dd-MM-yyyy");
        txtEndDate.setEnabled(false);
        txtEndDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtEndDate.setOpaque(false);

        lblStatus.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStatus.setText("Finished");
        lblStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStatusMouseClicked(evt);
            }
        });

        chStatus.setBackground(new java.awt.Color(255, 255, 255));
        chStatus.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        chStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtCreateDate.setBackground(new java.awt.Color(255, 255, 255));
        txtCreateDate.setDateFormatString("dd-MM-yyyy");
        txtCreateDate.setEnabled(false);
        txtCreateDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtCreateDate.setOpaque(false);

        lblCreateDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblCreateDate.setText("Create Date");
        lblCreateDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCreateDateMouseClicked(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID");
        lblID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIDMouseClicked(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setText("New");
        txtID.setBorder(null);
        txtID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtID.setEnabled(false);
        txtID.setOpaque(false);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        btnPlus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPlus.setText("+");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRemove.setText("-");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnPlus)
                .addGap(0, 0, 0)
                .addComponent(btnRemove))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlus)
            .addComponent(btnRemove)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSemester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCreateDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSemester)
                    .addComponent(lblStartDate)
                    .addComponent(lblEndDate)
                    .addComponent(lblCreateDate)
                    .addComponent(lblStatus)
                    .addComponent(lblID))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCreateDate, lblEndDate, lblSemester, lblStartDate, lblStatus});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSave, chStatus, cmbSemester, txtCreateDate, txtEndDate, txtID, txtStartDate});

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
        this.setState(FrmSchedule.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            if (col == 5 || col == 7 || col == 9 || col == 11 || col == 13 || col == 15 || col == 17) {
                if ((Boolean) table.getValueAt(row, col)) {
                    sm.showCol(table, col + 1);
                } else {
                    sm.hideCol(table, col + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("btnSave", frm);
        } else {
            String semester = cmbSemester.getSelectedItem().toString();
            sh.setSemesterID((int) mapSem.get(semester)[0]);
            if ("New".equals(txtID.getText())) {
                GetMaxID gm = new GetMaxID();
                txtID.setText(String.valueOf(gm.getIntID2("tbl_Schedule", "ScheduleID")));
                sh.setScheduleID(Integer.parseInt(txtID.getText()));
                sh.setCreatedate(txtCreateDate.getDate());
                sh.setCreatebyUser(userNbr);
                if (sm.insert(sh)) {
                    MsgBox.msgInfo();
                }
            } else {
                sh.setScheduleID(Integer.parseInt(txtID.getText()));
                sh.setSchStatus(chStatus.isSelected());
                if (sm.update(sh)) {
                    sm.updateSemesterStatus(sh);
                    MsgBox.msgInfo();
                }
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
 
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void cmbSemesterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSemesterMouseClicked
      
    }//GEN-LAST:event_cmbSemesterMouseClicked

    private void cmbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemesterActionPerformed
         try {
             if (cmbSemester.getSelectedIndex()==-1){
                 txtStartDate.setDate(null);
                 txtEndDate.setDate(null);
                 txtID.setText("New");
                  ClearTable.clearFirstLoad(table, model);
             }else{
                String semester = cmbSemester.getSelectedItem().toString();
                sh.setSemesterID(Integer.parseInt(mapSem.get(semester)[0].toString()));
                sm.showSemesterInfo(sh);
                txtStartDate.setDate(sh.getStartDate());
                txtEndDate.setDate(sh.getEndDate());
                int id = sm.getScheduleTextID(sh);
                if(id !=0){
                    txtID.setText(String.valueOf(id));
                    ClearTable.clearFirstLoad(table, model);
                    sm.showScheduleDetails(sh, model);
                }else{
                    txtID.setText("New");
                    ClearTable.clearFirstLoad(table, model);
                }
             }
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmbSemesterActionPerformed

    private void cmbSemesterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSemesterMouseEntered
        
    }//GEN-LAST:event_cmbSemesterMouseEntered

    private void cmbSemesterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSemesterMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSemesterMousePressed

    private void cmbSemesterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSemesterMouseReleased
      
    }//GEN-LAST:event_cmbSemesterMouseReleased

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        try {
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                String semes = cmbSemester.getSelectedItem().toString();
                String course = cmbCourse.getSelectedItem().toString();
                String teacher = cmbTeacher.getSelectedItem().toString();
                String room = cmbRoom.getSelectedItem().toString();
                sh.setCourseID((int) mapCourse.get(course)[0]);
                sh.setTecherID((int) mapTeacher.get(teacher)[0]);
                sh.setRoomID((int) mapRoom.get(room)[0]);
                sh.setSemesterID((int) mapSem.get(semes)[0]);
                sh.setScheduleID(Integer.parseInt(txtID.getText()));
                int rowSelect = table.getSelectedRow();
                int sdid = Integer.parseInt(table.getValueAt(rowSelect, 19).toString());
                if(sm.checkScheduleDetailID(sdid)==1){
                    sm.insertDetails(sh, table);
                }
                InputMap im = table.getInputMap();
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Action.NextCell");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "Action.NextCell");
                ActionMap am = table.getActionMap();
                am.put("Action.NextCell", new NextCellActioin(table)); 
                GetMaxID gm = new GetMaxID();
                int No = table.getRowCount();
                Object[] data = new Object[] {No+1,null,null,null,null,false,"",false,"",false,"",false,"",false,"",false,"",false,"",gm.getIntID("tbl_ScheduleDetails", "SCDID")};
                model.addRow(data);
                table.requestFocusInWindow();
                table.changeSelection(table.getRowCount()-1, 0, false, false);
                table.editCellAt(table.getRowCount()-1, 0);
                table.setSurrendersFocusOnKeystroke(true);
            }
            if(evt.getKeyCode()==KeyEvent.VK_DELETE){
                int rowSelect  = table.getSelectedRow();
                int sdid = Integer.parseInt(table.getValueAt(rowSelect, 19).toString());
                sm.deleteDetails(sdid, Integer.parseInt(txtID.getText()));
                model.removeRow(rowSelect--);
                int No = table.getRowCount();
                model.setValueAt(No, rowSelect+1, 0);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tableKeyPressed

    private void cmbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCourseActionPerformed
        try {
            int row = table.getSelectedRow();
            if (row != -1) {
                DecimalFormat df = new DecimalFormat("#,##0.00");
                String course = cmbCourse.getSelectedItem().toString();
                if (!"".equals(course)) {
                    double price = (double) mapCourse.get(course)[3];
                    model.setValueAt(df.format(price), row, 4);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmbCourseActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        GetMaxID gm = new GetMaxID();
        int No = table.getRowCount();
        Object[] data = new Object[] {No+1,null,null,null,null,false,"",false,"",false,"",false,"",false,"",false,"",false,"",gm.getIntID("tbl_ScheduleDetails", "SCDID")};
        model.addRow(data);
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = table.getRowCount()-1;
        Object a =  table.getValueAt(row, 1);
        int sdid = Integer.parseInt(table.getValueAt(row, 12).toString());
        if(a==null){
//            ps.deleteSaleDetail(sdid);
            model.removeRow(row--);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void lblScheduleInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblScheduleInfoMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblScheduleInfo", frm);
        }
    }//GEN-LAST:event_lblScheduleInfoMouseClicked

    private void lblSemesterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSemesterMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblSemester", frm);
        }
    }//GEN-LAST:event_lblSemesterMouseClicked

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

    private void lblCreateDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateDateMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblCreateDate", frm);
        }
    }//GEN-LAST:event_lblCreateDateMouseClicked

    private void lblStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatusMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStatus", frm);
        }
    }//GEN-LAST:event_lblStatusMouseClicked

    private void lblIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIDMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblID", frm);
        }
    }//GEN-LAST:event_lblIDMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void lblScheduleInfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblScheduleInfoMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_lblScheduleInfoMousePressed

    private void lblScheduleInfoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblScheduleInfoMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_lblScheduleInfoMouseDragged

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
            java.util.logging.Logger.getLogger(FrmSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel btnSave;
    private javax.swing.JCheckBox chStatus;
    private javax.swing.JComboBox<String> cmbCourse;
    private javax.swing.JComboBox<String> cmbRoom;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JComboBox<String> cmbTeacher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCreateDate;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblScheduleInfo;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser txtCreateDate;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtID;
    private com.toedter.calendar.JDateChooser txtStartDate;
    // End of variables declaration//GEN-END:variables
}
