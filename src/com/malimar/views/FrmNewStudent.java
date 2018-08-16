/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.views;

import com.malimar.controllers.LabelManager;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.OpenPicture;
import static com.malimar.controllers.OpenPicture.imagePath;
import com.malimar.controllers.StudentManager;
import com.malimar.models.Student;
import com.malimar.utils.Border;
import com.malimar.utils.MsgBox;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Malimar
 */
public class FrmNewStudent extends javax.swing.JDialog {
    String frm;
    StudentManager sm = new StudentManager();
    Student sd = new Student();
    HashMap<String, Object[]> mapGender = null;
    HashMap<String, Object[]> mapStudentType = null;
    HashMap<String, Object[]> mapNational = null;
    HashMap<String, Object[]> mapEthnic = null;
    HashMap<String, Object[]> mapReligion = null;
    HashMap<String, Object[]> mapPark = null;
    public FrmNewStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        getNewStudentLabel();
        showGenderComboBox();
        showStudentTypeComboBox();
        showNationalComboBox();
        showEthnicComboBox();
        showReligionComboBox();
        showParkComboBox();
        chStdStudying.setSelected(true);
        cmbBloodGroup.setSelectedIndex(-1);
        txtStdDiseases.setEnabled(false);
        txtStdDiseases.setOpaque(false);
        txtStdDiseases.setDisabledTextColor(Color.BLACK);
    }
    private void getNewStudentLabel(){
        lblStdNbr.setText(hmapLang.get("lblStdNbr".concat(frm).toUpperCase())[LN]);
        lblStdName_L1.setText(hmapLang.get("lblStdName_L1".concat(frm).toUpperCase())[LN]);
        lblStdName_L2.setText(hmapLang.get("lblStdName_L2".concat(frm).toUpperCase())[LN]);
        lblGender.setText(hmapLang.get("lblGender".concat(frm).toUpperCase())[LN]);
        lblStdType.setText(hmapLang.get("lblStdType".concat(frm).toUpperCase())[LN]);
        lblStdMobile.setText(hmapLang.get("lblStdMobile".concat(frm).toUpperCase())[LN]);
        lblHomeNumber.setText(hmapLang.get("lblHomeNumber".concat(frm).toUpperCase())[LN]);
        lblStdEmail.setText(hmapLang.get("lblStdEmail".concat(frm).toUpperCase())[LN]);
        lblStdDOB.setText(hmapLang.get("lblStdDOB".concat(frm).toUpperCase())[LN]);
        lblStdStartDate.setText(hmapLang.get("lblStdStartDate".concat(frm).toUpperCase())[LN]);
        lblStdEndDate.setText(hmapLang.get("lblStdEndDate".concat(frm).toUpperCase())[LN]);
        lblStdNationality.setText(hmapLang.get("lblStdNationality".concat(frm).toUpperCase())[LN]);
        lblStdEthnic.setText(hmapLang.get("lblStdEthnic".concat(frm).toUpperCase())[LN]);
        lblStdReligion.setText(hmapLang.get("lblStdReligion".concat(frm).toUpperCase())[LN]);
        lblStdStudying.setText(hmapLang.get("lblStdStudying".concat(frm).toUpperCase())[LN]);
        lblBloodGroup.setText(hmapLang.get("lblBloodGroup".concat(frm).toUpperCase())[LN]);
        lblPark.setText(hmapLang.get("lblPark".concat(frm).toUpperCase())[LN]);
        lblStdWeight.setText(hmapLang.get("lblStdWeight".concat(frm).toUpperCase())[LN]);
        lblStdHeight.setText(hmapLang.get("lblStdHeight".concat(frm).toUpperCase())[LN]);
        lblStdDisease.setText(hmapLang.get("lblStdDisease".concat(frm).toUpperCase())[LN]);
        lblStdSchoolName.setText(hmapLang.get("lblStdSchoolName".concat(frm).toUpperCase())[LN]);
        lblSchoolLevel.setText(hmapLang.get("lblSchoolLevel".concat(frm).toUpperCase())[LN]);
        lblSchoolMobile.setText(hmapLang.get("lblSchoolMobile".concat(frm).toUpperCase())[LN]);
        lblStdNote.setText(hmapLang.get("lblStdNote".concat(frm).toUpperCase())[LN]);
        lblNewStudentTitle.setText(hmapLang.get("lblNewStudentTitle".concat(frm).toUpperCase())[LN]);
        btnSave.setText(hmapLang.get("btnSave".concat(frm).toUpperCase())[LN]);
    }
    private void showGenderComboBox() {
        try {
            mapGender = sm.GenderComboBox();
            Map<String, Object[]> SortMap = new TreeMap<>(mapGender);
            cmbGender.removeAllItems();
            SortMap.keySet().forEach((s) -> {
                cmbGender.addItem(s);
            });
            cmbGender.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbGender);
        } catch (Exception e) {
        }
    }
    private void showStudentTypeComboBox() {
        try {
            mapStudentType = sm.StudentTypeComboBox();
            Map<String, Object[]> SortMap = new TreeMap<>(mapStudentType);
            cmbStdType.removeAllItems();
            SortMap.keySet().forEach((s) -> {
                cmbStdType.addItem(s);
            });
            cmbStdType.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbStdType);
        } catch (Exception e) {
        }
    }
    private void showNationalComboBox() {
        try {
            mapNational = sm.NationalityComboBox();
            Map<String, Object[]> SortMap = new TreeMap<>(mapNational);
            cmbStdNationality.removeAllItems();
            SortMap.keySet().forEach((s) -> {
                cmbStdNationality.addItem(s);
            });
            cmbStdNationality.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbStdNationality);
        } catch (Exception e) {
        }
    }
    private void showEthnicComboBox() {
        try {
            mapEthnic = sm.EthnicComboBox();
            Map<String, Object[]> SortMap = new TreeMap<>(mapEthnic);
            cmbStdEthnic.removeAllItems();
            SortMap.keySet().forEach((s) -> {
                cmbStdEthnic.addItem(s);
            });
            cmbStdEthnic.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbStdEthnic);
        } catch (Exception e) {
        }
    }
    private void showReligionComboBox() {
        try {
            mapReligion = sm.ReligionComboBox();
            Map<String, Object[]> SortMap = new TreeMap<>(mapReligion);
            cmbStdReligion.removeAllItems();
            SortMap.keySet().forEach((s) -> {
                cmbStdReligion.addItem(s);
            });
            cmbStdReligion.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbStdReligion);
        } catch (Exception e) {
        }
    }
    private void showParkComboBox() {
        try {
            mapPark = sm.StudentParkComboBox();
            Map<String, Object[]> SortMap = new TreeMap<>(mapPark);
            cmbStdPark.removeAllItems();
            SortMap.keySet().forEach((s) -> {
                cmbStdPark.addItem(s);
            });
            cmbStdPark.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmbStdPark);
        } catch (Exception e) {
        }
    }
    private void clearText(){
        txtStdNbr.setText("New");
        txtStdName_L1.setText("");
        txtStdName_L2.setText("");
        cmbGender.setSelectedIndex(-1);
        cmbStdType.setSelectedIndex(-1);
        txtStdMobile.setText("");
        txtHmoneNumber.setText("");
        txtStdEmail.setText("");
        txtStdDOB.setDate(null);
        txtStdStartDate.setDate(null);
        txtStdEndDate.setDate(null);
        cmbStdNationality.setSelectedIndex(-1);
        cmbStdEthnic.setSelectedIndex(-1);
        cmbStdReligion.setSelectedIndex(-1);
        chStdStudying.setSelected(true);
        cmbBloodGroup.setSelectedIndex(-1);
        cmbStdPark.setSelectedIndex(-1);
        txtStdWeight.setText("0");
        txtStdHeight.setText("0");
        chDiseases.setSelected(false);
        txtStdDiseases.setText("");
        txtStdSchoolName.setText("");
        txtStdSchoolLevel.setText("");
        txtStdSchoolMobile.setText("");
        txtStdNote.setText("");
        lblImage.setIcon(null);
        txtStdDiseases.setEnabled(false);
        txtStdDiseases.setOpaque(false);
        txtStdDiseases.setDisabledTextColor(Color.BLACK);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblNewStudentTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtStdEmail = new javax.swing.JTextField();
        lblStdDOB = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lblStdEmail = new javax.swing.JLabel();
        txtStdDOB = new com.toedter.calendar.JDateChooser();
        lblStdStartDate = new javax.swing.JLabel();
        txtStdStartDate = new com.toedter.calendar.JDateChooser();
        lblStdEndDate = new javax.swing.JLabel();
        txtStdEndDate = new com.toedter.calendar.JDateChooser();
        lblStdNationality = new javax.swing.JLabel();
        cmbStdNationality = new javax.swing.JComboBox<>();
        lblStdEthnic = new javax.swing.JLabel();
        cmbStdEthnic = new javax.swing.JComboBox<>();
        lblStdReligion = new javax.swing.JLabel();
        cmbStdReligion = new javax.swing.JComboBox<>();
        lblStdStudying = new javax.swing.JLabel();
        chStdStudying = new javax.swing.JCheckBox();
        lblBloodGroup = new javax.swing.JLabel();
        cmbBloodGroup = new javax.swing.JComboBox<>();
        txtStdWeight = new javax.swing.JTextField();
        lblStdWeight = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lblStdHeight = new javax.swing.JLabel();
        txtStdHeight = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        lblHomeNumber = new javax.swing.JLabel();
        txtHmoneNumber = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        lblStdMobile = new javax.swing.JLabel();
        txtStdMobile = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        lblStdDisease = new javax.swing.JLabel();
        txtStdDiseases = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        chDiseases = new javax.swing.JCheckBox();
        lblStdSchoolName = new javax.swing.JLabel();
        txtStdSchoolName = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        lblSchoolLevel = new javax.swing.JLabel();
        txtStdSchoolLevel = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        lblSchoolMobile = new javax.swing.JLabel();
        txtStdSchoolMobile = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        lblGender = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        cmbStdType = new javax.swing.JComboBox<>();
        lblStdType = new javax.swing.JLabel();
        lblPark = new javax.swing.JLabel();
        cmbStdPark = new javax.swing.JComboBox<>();
        lblStdNote = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStdNote = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        txtStdNbr = new javax.swing.JTextField();
        lblStdNbr = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtStdName_L2 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lblStdName_L2 = new javax.swing.JLabel();
        txtStdName_L1 = new javax.swing.JTextField();
        lblStdName_L1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 15, 255)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Close Window_30px.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel6.setLayout(new java.awt.BorderLayout());

        lblNewStudentTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblNewStudentTitle.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblNewStudentTitle.setForeground(new java.awt.Color(0, 15, 255));
        lblNewStudentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewStudentTitle.setText("New Student");
        lblNewStudentTitle.setOpaque(true);
        jPanel6.add(lblNewStudentTitle, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());

        lblImage.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Image");
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });
        jPanel2.add(lblImage, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStdEmail.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdEmail.setBorder(null);
        jPanel3.add(txtStdEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 155, 200, 25));

        lblStdDOB.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdDOB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdDOB.setText("Birthday");
        lblStdDOB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdDOBMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, 25));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 200, 10));

        lblStdEmail.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdEmail.setText("Email");
        lblStdEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdEmailMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 110, 25));

        txtStdDOB.setDateFormatString("dd-MM-yyyy");
        txtStdDOB.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(txtStdDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 140, 25));

        lblStdStartDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdStartDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdStartDate.setText("Start Date");
        lblStdStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdStartDateMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 25));

        txtStdStartDate.setDateFormatString("dd-MM-yyyy");
        txtStdStartDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(txtStdStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 140, 25));

        lblStdEndDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdEndDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdEndDate.setText("End Date");
        lblStdEndDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdEndDateMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 110, 25));

        txtStdEndDate.setDateFormatString("dd-MM-yyyy");
        txtStdEndDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(txtStdEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 140, 25));

        lblStdNationality.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdNationality.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdNationality.setText("Nationality");
        lblStdNationality.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdNationalityMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 25));

        cmbStdNationality.setEditable(true);
        cmbStdNationality.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(cmbStdNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 200, 25));

        lblStdEthnic.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdEthnic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdEthnic.setText("Ethnic");
        lblStdEthnic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdEthnicMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdEthnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 25));

        cmbStdEthnic.setEditable(true);
        cmbStdEthnic.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(cmbStdEthnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 200, 25));

        lblStdReligion.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdReligion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdReligion.setText("Religion");
        lblStdReligion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdReligionMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 110, 25));

        cmbStdReligion.setEditable(true);
        cmbStdReligion.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(cmbStdReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 200, 25));

        lblStdStudying.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdStudying.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdStudying.setText("Studying");
        lblStdStudying.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdStudyingMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdStudying, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 110, 25));

        chStdStudying.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(chStdStudying, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, -1, -1));

        lblBloodGroup.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblBloodGroup.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBloodGroup.setText("Blood Group");
        lblBloodGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBloodGroupMouseClicked(evt);
            }
        });
        jPanel3.add(lblBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 110, 25));

        cmbBloodGroup.setEditable(true);
        cmbBloodGroup.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbBloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));
        jPanel3.add(cmbBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 200, 25));

        txtStdWeight.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdWeight.setText("0");
        txtStdWeight.setBorder(null);
        jPanel3.add(txtStdWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 200, 25));

        lblStdWeight.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdWeight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdWeight.setText("Weight");
        lblStdWeight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdWeightMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 110, 25));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 65, 200, 10));

        lblStdHeight.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdHeight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdHeight.setText("Height");
        lblStdHeight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdHeightMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 75, 110, 25));

        txtStdHeight.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdHeight.setText("0");
        txtStdHeight.setBorder(null);
        jPanel3.add(txtStdHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 75, 200, 25));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 200, 10));

        lblHomeNumber.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblHomeNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHomeNumber.setText("Home Numer");
        lblHomeNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeNumberMouseClicked(evt);
            }
        });
        jPanel3.add(lblHomeNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 115, 110, 25));

        txtHmoneNumber.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtHmoneNumber.setBorder(null);
        jPanel3.add(txtHmoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 115, 200, 25));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 200, 10));

        lblStdMobile.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdMobile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdMobile.setText("Mobile Number");
        lblStdMobile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdMobileMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, 110, 25));

        txtStdMobile.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdMobile.setBorder(null);
        jPanel3.add(txtStdMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 75, 200, 25));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 200, 10));

        lblStdDisease.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdDisease.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdDisease.setText("Diseases");
        lblStdDisease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdDiseaseMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 115, 110, 25));

        txtStdDiseases.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdDiseases.setBorder(null);
        jPanel3.add(txtStdDiseases, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 115, 200, 25));
        jPanel3.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 200, 10));

        chDiseases.setBackground(new java.awt.Color(255, 255, 255));
        chDiseases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chDiseasesActionPerformed(evt);
            }
        });
        jPanel3.add(chDiseases, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 115, -1, -1));

        lblStdSchoolName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdSchoolName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdSchoolName.setText("School Name");
        lblStdSchoolName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdSchoolNameMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdSchoolName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 155, 110, 25));

        txtStdSchoolName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdSchoolName.setBorder(null);
        jPanel3.add(txtStdSchoolName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 155, 200, 25));
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 200, 10));

        lblSchoolLevel.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSchoolLevel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSchoolLevel.setText("School Level");
        lblSchoolLevel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSchoolLevelMouseClicked(evt);
            }
        });
        jPanel3.add(lblSchoolLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 110, 25));

        txtStdSchoolLevel.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdSchoolLevel.setBorder(null);
        jPanel3.add(txtStdSchoolLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 200, 25));
        jPanel3.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 225, 200, 10));

        lblSchoolMobile.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSchoolMobile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSchoolMobile.setText("School Mobile");
        lblSchoolMobile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSchoolMobileMouseClicked(evt);
            }
        });
        jPanel3.add(lblSchoolMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 110, 25));

        txtStdSchoolMobile.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdSchoolMobile.setBorder(null);
        jPanel3.add(txtStdSchoolMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 200, 25));
        jPanel3.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 265, 200, 10));

        lblGender.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGender.setText("Gender");
        lblGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGenderMouseClicked(evt);
            }
        });
        jPanel3.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 25));

        cmbGender.setEditable(true);
        cmbGender.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });
        jPanel3.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 200, 25));

        cmbStdType.setEditable(true);
        cmbStdType.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(cmbStdType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 200, 25));

        lblStdType.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdType.setText("Student type");
        lblStdType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdTypeMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 25));

        lblPark.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblPark.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPark.setText("Park");
        lblPark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblParkMouseClicked(evt);
            }
        });
        jPanel3.add(lblPark, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 110, 25));

        cmbStdPark.setEditable(true);
        cmbStdPark.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        jPanel3.add(cmbStdPark, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 200, 25));

        lblStdNote.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdNote.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdNote.setText("Note");
        lblStdNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdNoteMouseClicked(evt);
            }
        });
        jPanel3.add(lblStdNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 283, 400, 25));

        txtStdNote.setColumns(20);
        txtStdNote.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdNote.setRows(5);
        jScrollPane1.setViewportView(txtStdNote);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 400, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStdNbr.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdNbr.setText("New");
        txtStdNbr.setBorder(null);
        txtStdNbr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtStdNbr.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStdNbr.setEnabled(false);
        txtStdNbr.setOpaque(false);
        txtStdNbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStdNbrMouseClicked(evt);
            }
        });
        jPanel4.add(txtStdNbr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 8, 140, 25));

        lblStdNbr.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdNbr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStdNbr.setText("Student#");
        lblStdNbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdNbrMouseClicked(evt);
            }
        });
        jPanel4.add(lblStdNbr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 77, 25));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 33, 140, 10));

        txtStdName_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdName_L2.setBorder(null);
        jPanel4.add(txtStdName_L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, 25));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 125, 200, 10));

        lblStdName_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdName_L2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdName_L2.setText("Student Name(EN)");
        lblStdName_L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdName_L2MouseClicked(evt);
            }
        });
        jPanel4.add(lblStdName_L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, 25));

        txtStdName_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtStdName_L1.setBorder(null);
        jPanel4.add(txtStdName_L1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 200, 25));

        lblStdName_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblStdName_L1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStdName_L1.setText("Student Name(Lao)");
        lblStdName_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStdName_L1MouseClicked(evt);
            }
        });
        jPanel4.add(lblStdName_L1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 25));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 75, 200, 10));

        btnSave.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("Save");
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
        jPanel4.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 90, -1));

        jPanel7.setBackground(new java.awt.Color(0, 15, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        Border.blueColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if(evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("btnSave", frm);
        } else {
            if (cmbGender.getSelectedItem() == null || cmbBloodGroup.getSelectedItem()==null || cmbStdEthnic.getSelectedItem()==null || cmbStdNationality.getSelectedItem()==null || cmbStdPark.getSelectedItem()==null || cmbStdReligion.getSelectedItem()==null || cmbStdType.getSelectedItem()==null) {
                MsgBox.msgError();
            } else {
                String gender = cmbGender.getSelectedItem().toString();
                String stdType = cmbStdType.getSelectedItem().toString();
                String national = cmbStdNationality.getSelectedItem().toString();
                String ethnic = cmbStdEthnic.getSelectedItem().toString();
                String religion = cmbStdReligion.getSelectedItem().toString();
                String park = cmbStdPark.getSelectedItem().toString();
                sd.setStdName_L1(txtStdName_L1.getText().trim());
                sd.setStdName_L2(txtStdName_L2.getText().trim());
                sd.setGendID(Integer.parseInt(mapGender.get(gender)[0].toString()));
                sd.setStdType(Integer.parseInt(mapStudentType.get(stdType)[0].toString()));
                sd.setStdPhone1(txtStdMobile.getText().trim());
                sd.setStdPhone2(txtHmoneNumber.getText().trim());
                sd.setStdEmail(txtStdEmail.getText().trim());
                sd.setStdDOB(txtStdDOB.getDate());
                sd.setStdStartDate(txtStdStartDate.getDate());
                sd.setStdEndDate(txtStdEndDate.getDate());
                sd.setStdNationlity(Integer.parseInt(mapNational.get(national)[0].toString()));
                sd.setStdEthnic(Integer.parseInt(mapEthnic.get(ethnic)[0].toString()));
                sd.setStdReligion(Integer.parseInt(mapReligion.get(religion)[0].toString()));
                sd.setStdStudying(chStdStudying.isSelected());
                sd.setBlood(cmbBloodGroup.getSelectedItem().toString());
                sd.setStdPark(Integer.parseInt(mapPark.get(park)[0].toString()));
                sd.setStdWeight(Float.parseFloat(txtStdWeight.getText()));
                sd.setStdHeight(Float.parseFloat(txtStdHeight.getText()));
                sd.setStdCongenialDisease(chDiseases.isSelected());
                sd.setStdCongenialDiseaseInfo(txtStdDiseases.getText().trim());
                sd.setStdSchoolName(txtStdSchoolName.getText().trim());
                sd.setStdSchoolLevel(txtStdSchoolLevel.getText().trim());
                sd.setStdSchoolMobile(txtStdSchoolMobile.getText().trim());
                sd.setStdNote(txtStdNote.getText().trim());
                sd.setPath(imagePath);
                if (txtStdNbr.getText().equals("New")) {
                    if (sm.insertStudent(sd)) {
                        MsgBox.msgInfo();
                    }
                } else {
                    if (sm.updateStudent(sd)) {
                        MsgBox.msgInfo();
                    }
                }
                clearText();
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblImage", frm);
        }else if(evt.getClickCount()==2){
            lblImage.setText("");
            lblImage.setIcon(OpenPicture.getImage(lblImage.getWidth(), lblImage.getHeight()));
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void txtStdNbrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStdNbrMouseClicked
 
    }//GEN-LAST:event_txtStdNbrMouseClicked

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed

    }//GEN-LAST:event_cmbGenderActionPerformed

    private void chDiseasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chDiseasesActionPerformed
        txtStdDiseases.setEnabled(false);
        txtStdDiseases.setOpaque(false);
        txtStdDiseases.setDisabledTextColor(Color.BLACK);
    }//GEN-LAST:event_chDiseasesActionPerformed

    private void lblStdNbrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdNbrMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdNbr", frm);
        }
    }//GEN-LAST:event_lblStdNbrMouseClicked

    private void lblStdName_L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdName_L1MouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdName_L1", frm);
        }
    }//GEN-LAST:event_lblStdName_L1MouseClicked

    private void lblStdName_L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdName_L2MouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdName_L2", frm);
        }
    }//GEN-LAST:event_lblStdName_L2MouseClicked

    private void lblGenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenderMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblGender", frm);
        }
    }//GEN-LAST:event_lblGenderMouseClicked

    private void lblStdTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdTypeMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdType", frm);
        }
    }//GEN-LAST:event_lblStdTypeMouseClicked

    private void lblStdMobileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdMobileMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdMobile", frm);
        }
    }//GEN-LAST:event_lblStdMobileMouseClicked

    private void lblHomeNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeNumberMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblHomeNumber", frm);
        }
    }//GEN-LAST:event_lblHomeNumberMouseClicked

    private void lblStdEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdEmailMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdEmail", frm);
        }
    }//GEN-LAST:event_lblStdEmailMouseClicked

    private void lblStdDOBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdDOBMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdDOB", frm);
        }
    }//GEN-LAST:event_lblStdDOBMouseClicked

    private void lblStdStartDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdStartDateMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdStartDate", frm);
        }
    }//GEN-LAST:event_lblStdStartDateMouseClicked

    private void lblStdEndDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdEndDateMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdEndDate", frm);
        }
    }//GEN-LAST:event_lblStdEndDateMouseClicked

    private void lblStdNationalityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdNationalityMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdNationality", frm);
        }
    }//GEN-LAST:event_lblStdNationalityMouseClicked

    private void lblStdEthnicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdEthnicMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdEthnic", frm);
        }
    }//GEN-LAST:event_lblStdEthnicMouseClicked

    private void lblStdReligionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdReligionMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdReligion", frm);
        }
    }//GEN-LAST:event_lblStdReligionMouseClicked

    private void lblStdStudyingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdStudyingMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdStudying", frm);
        }
    }//GEN-LAST:event_lblStdStudyingMouseClicked

    private void lblBloodGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBloodGroupMouseClicked
       if(evt.getModifiers()==6){
            WindowChangeLabel("lblBloodGroup", frm);
        }
    }//GEN-LAST:event_lblBloodGroupMouseClicked

    private void lblParkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParkMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblPark", frm);
        }
    }//GEN-LAST:event_lblParkMouseClicked

    private void lblStdWeightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdWeightMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdWeight", frm);
        }
    }//GEN-LAST:event_lblStdWeightMouseClicked

    private void lblStdHeightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdHeightMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdHeight", frm);
        }
    }//GEN-LAST:event_lblStdHeightMouseClicked

    private void lblStdDiseaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdDiseaseMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdDisease", frm);
        }
    }//GEN-LAST:event_lblStdDiseaseMouseClicked

    private void lblStdSchoolNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdSchoolNameMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdSchoolName", frm);
        }
    }//GEN-LAST:event_lblStdSchoolNameMouseClicked

    private void lblSchoolLevelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSchoolLevelMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblSchoolLevel", frm);
        }
    }//GEN-LAST:event_lblSchoolLevelMouseClicked

    private void lblSchoolMobileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSchoolMobileMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblSchoolMobile", frm);
        }
    }//GEN-LAST:event_lblSchoolMobileMouseClicked

    private void lblStdNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdNoteMouseClicked
        if(evt.getModifiers()==6){
            WindowChangeLabel("lblStdNote", frm);
        }
    }//GEN-LAST:event_lblStdNoteMouseClicked

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
            java.util.logging.Logger.getLogger(FrmNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNewStudent dialog = new FrmNewStudent(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel btnSave;
    private javax.swing.JCheckBox chDiseases;
    private javax.swing.JCheckBox chStdStudying;
    private javax.swing.JComboBox<String> cmbBloodGroup;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbStdEthnic;
    private javax.swing.JComboBox<String> cmbStdNationality;
    private javax.swing.JComboBox<String> cmbStdPark;
    private javax.swing.JComboBox<String> cmbStdReligion;
    private javax.swing.JComboBox<String> cmbStdType;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblBloodGroup;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHomeNumber;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNewStudentTitle;
    private javax.swing.JLabel lblPark;
    private javax.swing.JLabel lblSchoolLevel;
    private javax.swing.JLabel lblSchoolMobile;
    private javax.swing.JLabel lblStdDOB;
    private javax.swing.JLabel lblStdDisease;
    private javax.swing.JLabel lblStdEmail;
    private javax.swing.JLabel lblStdEndDate;
    private javax.swing.JLabel lblStdEthnic;
    private javax.swing.JLabel lblStdHeight;
    private javax.swing.JLabel lblStdMobile;
    private javax.swing.JLabel lblStdName_L1;
    private javax.swing.JLabel lblStdName_L2;
    private javax.swing.JLabel lblStdNationality;
    private javax.swing.JLabel lblStdNbr;
    private javax.swing.JLabel lblStdNote;
    private javax.swing.JLabel lblStdReligion;
    private javax.swing.JLabel lblStdSchoolName;
    private javax.swing.JLabel lblStdStartDate;
    private javax.swing.JLabel lblStdStudying;
    private javax.swing.JLabel lblStdType;
    private javax.swing.JLabel lblStdWeight;
    private javax.swing.JTextField txtHmoneNumber;
    private com.toedter.calendar.JDateChooser txtStdDOB;
    private javax.swing.JTextField txtStdDiseases;
    private javax.swing.JTextField txtStdEmail;
    private com.toedter.calendar.JDateChooser txtStdEndDate;
    private javax.swing.JTextField txtStdHeight;
    private javax.swing.JTextField txtStdMobile;
    private javax.swing.JTextField txtStdName_L1;
    private javax.swing.JTextField txtStdName_L2;
    private javax.swing.JTextField txtStdNbr;
    private javax.swing.JTextArea txtStdNote;
    private javax.swing.JTextField txtStdSchoolLevel;
    private javax.swing.JTextField txtStdSchoolMobile;
    private javax.swing.JTextField txtStdSchoolName;
    private com.toedter.calendar.JDateChooser txtStdStartDate;
    private javax.swing.JTextField txtStdWeight;
    // End of variables declaration//GEN-END:variables
}
