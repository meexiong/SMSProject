/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.views;

import com.malimar.controllers.GuardianManager;
import com.malimar.controllers.LabelManager;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.controllers.OpenPicture;
import static com.malimar.controllers.OpenPicture.imagePath;
import com.malimar.controllers.StudentManager;
import com.malimar.controllers.UserPermission;
import com.malimar.models.Guardian;
import com.malimar.models.Student;
import com.malimar.utils.Border;
import com.malimar.utils.FrameMove;
import com.malimar.utils.MsgBox;
import com.malimar.utils.Variables;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
    HashMap<String, Object[]> mapGender1 = null;
    Guardian gd = new Guardian();
    GuardianManager gdm = new GuardianManager();

    String stdnbr;
    DefaultTableModel model = new DefaultTableModel();

    public FrmNewStudent(java.awt.Frame parent, boolean modal, String nbr) {
        super(parent, modal);
        initComponents();
        stdnbr = nbr;
        frm = this.getClass().getSimpleName();
        model = (DefaultTableModel) table.getModel();
        table.getTableHeader().setFont(new Font("Saysettha OT", Font.PLAIN, 12));
        getNewStudentLabel();
        showGenderComboBox();
        showGenderComboBox1();
        showStudentTypeComboBox();
        showNationalComboBox();
        showEthnicComboBox();
        showReligionComboBox();
        showParkComboBox();
        txtStdNbr.setText(nbr);
        if ("New".equals(nbr)) {
            chStdStudying.setSelected(true);
            cmbBloodGroup.setSelectedIndex(-1);
            txtStdDiseases.setEnabled(false);
            txtStdDiseases.setOpaque(false);
            txtStdDiseases.setDisabledTextColor(Color.BLACK);
//            tabInfo.setEnabledAt(1, false);
        } else {
            showData();
            gdm.loadGuardian(table, model, nbr);
        }
        UserPermission.getPermission_S(FrmMain.userNbr, frm, btnSave);
    }

    private void getNewStudentLabel() {
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
        lblImage.setText(hmapLang.get("lblImage".concat(frm).toUpperCase())[LN]);
        tabInfo.setTitleAt(1, hmapLang.get("tabQuardianInfo".concat(frm).toUpperCase())[LN]);
        tabInfo.setTitleAt(0, hmapLang.get("tabStudentInfo".concat(frm).toUpperCase())[LN]);

        lblID.setText(hmapLang.get("lblID".concat(frm).toUpperCase())[LN]);
        lblGuardian_L1.setText(hmapLang.get("lblGuardian_L1".concat(frm).toUpperCase())[LN]);
        lblGuardian_L2.setText(hmapLang.get("lblGuardian_L2".concat(frm).toUpperCase())[LN]);
        lblGender1.setText(hmapLang.get("lblGender1".concat(frm).toUpperCase())[LN]);
        lblPhoneNumber.setText(hmapLang.get("lblPhoneNumber".concat(frm).toUpperCase())[LN]);
        lblPhoneNumber2.setText(hmapLang.get("lblPhoneNumber2".concat(frm).toUpperCase())[LN]);
        lblEmail.setText(hmapLang.get("lblEmail".concat(frm).toUpperCase())[LN]);
        lblWorklocation.setText(hmapLang.get("lblWorklocation".concat(frm).toUpperCase())[LN]);
        lblAddress_L1.setText(hmapLang.get("lblAddress_L1".concat(frm).toUpperCase())[LN]);
        lblAddress_L2.setText(hmapLang.get("lblAddress_L2".concat(frm).toUpperCase())[LN]);
        btnSaveG.setText(hmapLang.get("btnSaveG".concat(frm).toUpperCase())[LN]);
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        table.getColumnCount();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        table.setAutoCreateRowSorter(true);
        th.repaint();
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.getTableHeader().setBackground(Color.decode("#4169E1"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
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

    private void showGenderComboBox1() {
        try {
            mapGender1 = gdm.mapGender();
            Map<String, Object[]> SortMap = new TreeMap<>(mapGender1);
            cmdGender.removeAllItems();
            SortMap.keySet().forEach((s) -> {
                cmdGender.addItem(s);
            });
            cmdGender.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cmdGender);
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

    private void clearText() {
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

    private void clearGuardian() {
        txtGuardianID.setText("New");
        txtGuardian_L1.setText("");
        txtGuardian_L2.setText("");
        cmdGender.setSelectedIndex(-1);
        txtPhoneNumber.setText("");
        txtPhoneNumber2.setText("");
        txtEmail.setText("");
        txtWorkLocation.setText("");
        txtAddress_L1.setText("");
        txtAddress_L2.setText("");
    }

    private void showData() {
        sd.setStdNbr(stdnbr);
        sm.LoadEdit(sd);
        txtStdName_L1.setText(sd.getStdName_L1());
        txtStdName_L2.setText(sd.getStdName_L2());
        cmbGender.setSelectedItem(sd.getGenderName());
        cmbStdType.setSelectedItem(sd.getStdTypeName());
        txtStdMobile.setText(sd.getStdPhone1());
        txtHmoneNumber.setText(sd.getStdPhone2());
        txtStdEmail.setText(sd.getStdEmail());
        txtStdDOB.setDate(sd.getStdDOB());
        txtStdStartDate.setDate(sd.getStdStartDate());
        txtStdEndDate.setDate(sd.getStdEndDate());
        cmbStdNationality.setSelectedItem(sd.getStdNationalName());
        cmbStdEthnic.setSelectedItem(sd.getStdEthnicName());
        cmbStdReligion.setSelectedItem(sd.getStdReligionName());
        chStdStudying.setSelected(sd.isStdStudying());
        cmbBloodGroup.setSelectedItem(sd.getBlood());
        cmbStdPark.setSelectedItem(sd.getStdParkName());
        txtStdWeight.setText(String.valueOf(sd.getStdWeight()));
        txtStdHeight.setText(String.valueOf(sd.getStdHeight()));
        chDiseases.setSelected(sd.isStdCongenialDisease());
        txtStdDiseases.setText(sd.getStdCongenialDiseaseInfo());
        txtStdSchoolName.setText(sd.getStdSchoolName());
        txtStdSchoolLevel.setText(sd.getStdSchoolLevel());
        txtStdSchoolMobile.setText(sd.getStdSchoolMobile());
        txtStdNote.setText(sd.getStdNote());
        if (sd.getPicture() == null) {
            lblImage.setIcon(null);
        } else {
            Image img1 = new ImageIcon(sd.getPicture()).getImage();
            Image ic = OpenPicture.ResizeScall(img1, lblImage.getWidth(), lblImage.getHeight());
            lblImage.setIcon(new ImageIcon(ic));
        }
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
        btnTake = new javax.swing.JLabel();
        tabInfo = new com.xzq.osc.JocTabbedPane();
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
        jPanel8 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtGuardianID = new javax.swing.JTextField();
        lblGuardian_L1 = new javax.swing.JLabel();
        txtGuardian_L1 = new javax.swing.JTextField();
        txtGuardian_L2 = new javax.swing.JTextField();
        lblGuardian_L2 = new javax.swing.JLabel();
        lblGender1 = new javax.swing.JLabel();
        cmdGender = new javax.swing.JComboBox<>();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblPhoneNumber2 = new javax.swing.JLabel();
        txtPhoneNumber2 = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblWorklocation = new javax.swing.JLabel();
        txtWorkLocation = new javax.swing.JTextField();
        lblAddress_L1 = new javax.swing.JLabel();
        txtAddress_L1 = new javax.swing.JTextField();
        lblAddress_L2 = new javax.swing.JLabel();
        txtAddress_L2 = new javax.swing.JTextField();
        btnSaveG = new com.xzq.osc.JocHyperlink();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSearch = new com.xzq.osc.JocHyperlink();

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
        jPanel4.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 90, -1));

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

        btnTake.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnTake.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Camera_24px.png"))); // NOI18N
        btnTake.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTake.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTakeMouseMoved(evt);
            }
        });
        btnTake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTakeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTakeMouseExited(evt);
            }
        });

        tabInfo.setShowCloseButton(false);
        tabInfo.setShowListButton(false);
        tabInfo.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

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

        tabInfo.addTab("Student Info", jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lblID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID");
        lblID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIDMouseClicked(evt);
            }
        });

        txtGuardianID.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtGuardianID.setText("New");
        txtGuardianID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtGuardianID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtGuardianID.setEnabled(false);
        txtGuardianID.setOpaque(false);

        lblGuardian_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblGuardian_L1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGuardian_L1.setText("Quardian Lao");
        lblGuardian_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardian_L1MouseClicked(evt);
            }
        });

        txtGuardian_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtGuardian_L1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtGuardian_L1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtGuardian_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtGuardian_L2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtGuardian_L2.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblGuardian_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblGuardian_L2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGuardian_L2.setText("Quardian EN");
        lblGuardian_L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardian_L2MouseClicked(evt);
            }
        });

        lblGender1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblGender1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGender1.setText("Gender");
        lblGender1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGender1MouseClicked(evt);
            }
        });

        cmdGender.setEditable(true);
        cmdGender.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        lblPhoneNumber.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhoneNumber.setText("Phone number");
        lblPhoneNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhoneNumberMouseClicked(evt);
            }
        });

        txtPhoneNumber.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtPhoneNumber.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblPhoneNumber2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblPhoneNumber2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhoneNumber2.setText("Phone number");
        lblPhoneNumber2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhoneNumber2MouseClicked(evt);
            }
        });

        txtPhoneNumber2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtPhoneNumber2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtPhoneNumber2.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtEmail.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblEmail.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email");
        lblEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmailMouseClicked(evt);
            }
        });

        lblWorklocation.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblWorklocation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWorklocation.setText("Work");
        lblWorklocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWorklocationMouseClicked(evt);
            }
        });

        txtWorkLocation.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtWorkLocation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtWorkLocation.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblAddress_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblAddress_L1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddress_L1.setText("Address Lao");
        lblAddress_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddress_L1MouseClicked(evt);
            }
        });

        txtAddress_L1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtAddress_L1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtAddress_L1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        lblAddress_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblAddress_L2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddress_L2.setText("Address EN");
        lblAddress_L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddress_L2MouseClicked(evt);
            }
        });

        txtAddress_L2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtAddress_L2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtAddress_L2.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        btnSaveG.setText("Save");
        btnSaveG.setUnvisitColor(new java.awt.Color(0, 0, 0));
        btnSaveG.setVisitedColor(new java.awt.Color(0, 0, 0));
        btnSaveG.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnSaveG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveGMouseClicked(evt);
            }
        });
        btnSaveG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveGActionPerformed(evt);
            }
        });

        jPanel9.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "lblID", "lblGuardian_L1", "lblGuardian_L2", "lblGender", "lblPhoneNumber", "lblPhoneNumber2", "lblEmail", "lblWorklocation", "lblAddress_L1", "lblAddress_L2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(java.awt.Color.red);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMinWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(200);
            table.getColumnModel().getColumn(2).setMinWidth(200);
            table.getColumnModel().getColumn(2).setMaxWidth(200);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(150);
            table.getColumnModel().getColumn(4).setMaxWidth(150);
            table.getColumnModel().getColumn(5).setMinWidth(150);
            table.getColumnModel().getColumn(5).setMaxWidth(150);
            table.getColumnModel().getColumn(6).setMinWidth(150);
            table.getColumnModel().getColumn(6).setMaxWidth(150);
            table.getColumnModel().getColumn(7).setMinWidth(150);
            table.getColumnModel().getColumn(7).setMaxWidth(150);
            table.getColumnModel().getColumn(8).setMinWidth(200);
            table.getColumnModel().getColumn(8).setMaxWidth(200);
            table.getColumnModel().getColumn(9).setMinWidth(200);
            table.getColumnModel().getColumn(9).setMaxWidth(200);
        }

        jPanel9.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Search_24px.png"))); // NOI18N
        btnSearch.setUnvisitColor(new java.awt.Color(0, 0, 0));
        btnSearch.setVisitedColor(new java.awt.Color(0, 0, 0));
        btnSearch.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress_L2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress_L1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWorklocation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGuardian_L2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGuardian_L1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddress_L2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtAddress_L1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtWorkLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtPhoneNumber2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtGuardian_L2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtGuardian_L1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtGuardianID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnSaveG, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAddress_L1, lblAddress_L2, lblEmail, lblGender1, lblGuardian_L1, lblGuardian_L2, lblID, lblPhoneNumber, lblPhoneNumber2, lblWorklocation});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtGuardianID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGuardian_L1)
                    .addComponent(txtGuardian_L1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGuardian_L2)
                    .addComponent(txtGuardian_L2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender1)
                    .addComponent(cmdGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber2)
                    .addComponent(txtPhoneNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWorklocation)
                    .addComponent(txtWorkLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress_L1)
                    .addComponent(txtAddress_L1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress_L2)
                    .addComponent(txtAddress_L2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnSaveG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmdGender, lblAddress_L1, lblAddress_L2, lblEmail, lblGender1, lblGuardian_L1, lblGuardian_L2, lblID, lblPhoneNumber, lblPhoneNumber2, lblWorklocation, txtAddress_L1, txtAddress_L2, txtEmail, txtGuardianID, txtGuardian_L1, txtGuardian_L2, txtPhoneNumber, txtPhoneNumber2, txtWorkLocation});

        tabInfo.addTab("Add Quardian", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTake)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(1, 1, 1)
                .addComponent(btnTake, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(tabInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if (evt.getModifiers() == 6) {
            LabelManager.WindowChangeLabel("btnSave", frm);
        } else {
            if (cmbGender.getSelectedItem() == null || cmbBloodGroup.getSelectedItem() == null || cmbStdEthnic.getSelectedItem() == null || cmbStdNationality.getSelectedItem() == null || cmbStdPark.getSelectedItem() == null || cmbStdReligion.getSelectedItem() == null || cmbStdType.getSelectedItem() == null) {
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
                        tabInfo.setEnabledAt(1, false);
//                        clearText();
                    } else {
                        MsgBox.msgError();
                    }
                } else {
                    if (sm.updateStudent(sd)) {
                        sm.updateStudentPicture(sd);
                        MsgBox.msgInfo();
//                        clearText();
                    } else {
                        MsgBox.msgError();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        Border.WhiteColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblImage", frm);
        } else if (evt.getClickCount() == 2) {
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
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdNbr", frm);
        }
    }//GEN-LAST:event_lblStdNbrMouseClicked

    private void lblStdName_L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdName_L1MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdName_L1", frm);
        }
    }//GEN-LAST:event_lblStdName_L1MouseClicked

    private void lblStdName_L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdName_L2MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdName_L2", frm);
        }
    }//GEN-LAST:event_lblStdName_L2MouseClicked

    private void lblGenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenderMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblGender", frm);
        }
    }//GEN-LAST:event_lblGenderMouseClicked

    private void lblStdTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdTypeMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdType", frm);
        }
    }//GEN-LAST:event_lblStdTypeMouseClicked

    private void lblStdMobileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdMobileMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdMobile", frm);
        }
    }//GEN-LAST:event_lblStdMobileMouseClicked

    private void lblHomeNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeNumberMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblHomeNumber", frm);
        }
    }//GEN-LAST:event_lblHomeNumberMouseClicked

    private void lblStdEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdEmailMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdEmail", frm);
        }
    }//GEN-LAST:event_lblStdEmailMouseClicked

    private void lblStdDOBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdDOBMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdDOB", frm);
        }
    }//GEN-LAST:event_lblStdDOBMouseClicked

    private void lblStdStartDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdStartDateMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdStartDate", frm);
        }
    }//GEN-LAST:event_lblStdStartDateMouseClicked

    private void lblStdEndDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdEndDateMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdEndDate", frm);
        }
    }//GEN-LAST:event_lblStdEndDateMouseClicked

    private void lblStdNationalityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdNationalityMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdNationality", frm);
        }
    }//GEN-LAST:event_lblStdNationalityMouseClicked

    private void lblStdEthnicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdEthnicMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdEthnic", frm);
        }
    }//GEN-LAST:event_lblStdEthnicMouseClicked

    private void lblStdReligionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdReligionMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdReligion", frm);
        }
    }//GEN-LAST:event_lblStdReligionMouseClicked

    private void lblStdStudyingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdStudyingMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdStudying", frm);
        }
    }//GEN-LAST:event_lblStdStudyingMouseClicked

    private void lblBloodGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBloodGroupMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblBloodGroup", frm);
        }
    }//GEN-LAST:event_lblBloodGroupMouseClicked

    private void lblParkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParkMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblPark", frm);
        }
    }//GEN-LAST:event_lblParkMouseClicked

    private void lblStdWeightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdWeightMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdWeight", frm);
        }
    }//GEN-LAST:event_lblStdWeightMouseClicked

    private void lblStdHeightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdHeightMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdHeight", frm);
        }
    }//GEN-LAST:event_lblStdHeightMouseClicked

    private void lblStdDiseaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdDiseaseMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdDisease", frm);
        }
    }//GEN-LAST:event_lblStdDiseaseMouseClicked

    private void lblStdSchoolNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdSchoolNameMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdSchoolName", frm);
        }
    }//GEN-LAST:event_lblStdSchoolNameMouseClicked

    private void lblSchoolLevelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSchoolLevelMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblSchoolLevel", frm);
        }
    }//GEN-LAST:event_lblSchoolLevelMouseClicked

    private void lblSchoolMobileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSchoolMobileMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblSchoolMobile", frm);
        }
    }//GEN-LAST:event_lblSchoolMobileMouseClicked

    private void lblStdNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStdNoteMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblStdNote", frm);
        }
    }//GEN-LAST:event_lblStdNoteMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FrameMove.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FrameMove.mouseDragded(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void btnTakeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTakeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTakeMouseMoved

    private void btnTakeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTakeMouseClicked
//        int a =OpenPicture.num-1;
//        File file = new File("src/com/malimar/images/picture_"+a+".png");
//        file.delete();
        FrmTakePhoto f = new FrmTakePhoto(null, rootPaneCheckingEnabled);
        f.setVisible(true);
//        lblImage.setIcon(null);
        lblImage.setIcon(OpenPicture.getImageAuto(lblImage.getWidth(), lblImage.getHeight()));
    }//GEN-LAST:event_btnTakeMouseClicked

    private void btnTakeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTakeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTakeMouseExited

    private void lblIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIDMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblID", frm);
        }
    }//GEN-LAST:event_lblIDMouseClicked

    private void lblGuardian_L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardian_L1MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblGuardian_L1", frm);
        }
    }//GEN-LAST:event_lblGuardian_L1MouseClicked

    private void lblGuardian_L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardian_L2MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblGuardian_L2", frm);
        }
    }//GEN-LAST:event_lblGuardian_L2MouseClicked

    private void lblGender1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGender1MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblGender1", frm);
        }
    }//GEN-LAST:event_lblGender1MouseClicked

    private void lblPhoneNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhoneNumberMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblPhoneNumber", frm);
        }
    }//GEN-LAST:event_lblPhoneNumberMouseClicked

    private void lblPhoneNumber2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhoneNumber2MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblPhoneNumber2", frm);
        }
    }//GEN-LAST:event_lblPhoneNumber2MouseClicked

    private void lblEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmailMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblEmail", frm);
        }
    }//GEN-LAST:event_lblEmailMouseClicked

    private void lblWorklocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWorklocationMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblWorklocation", frm);
        }
    }//GEN-LAST:event_lblWorklocationMouseClicked

    private void lblAddress_L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddress_L1MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblAddress_L1", frm);
        }
    }//GEN-LAST:event_lblAddress_L1MouseClicked

    private void lblAddress_L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddress_L2MouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblAddress_L2", frm);
        }
    }//GEN-LAST:event_lblAddress_L2MouseClicked

    private void btnSaveGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveGMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("btnSaveG", frm);
        }
    }//GEN-LAST:event_btnSaveGMouseClicked

    private void btnSaveGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGActionPerformed
        try {
            String gender = cmdGender.getSelectedItem().toString();
            gd.setGuardianL1(txtGuardian_L1.getText());
            gd.setGuardianL2(txtGuardian_L2.getText());
            gd.setGenid(Integer.parseInt(mapGender.get(gender)[0].toString()));
            gd.setPhone1(txtPhoneNumber.getText());
            gd.setPhone2(txtPhoneNumber2.getText());
            gd.setEmail(txtEmail.getText());
            gd.setGud_Work(txtWorkLocation.getText());
            gd.setAddress(txtAddress_L1.getText());
            gd.setMoreinfo(txtAddress_L2.getText());
            gd.setStudentNbr(txtStdNbr.getText());
            if (txtGuardianID.getText().equals("New")) {
                gdm.insertGuardian(gd);
            } else {
                gd.setId(Integer.parseInt(txtGuardianID.getText()));
                gdm.updateGuardian(gd);
            }
            gdm.loadGuardian(table, model, txtStdNbr.getText());
            clearGuardian();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveGActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            int row = table.getSelectedRow();
            txtGuardianID.setText(table.getValueAt(row, 0).toString());
            txtGuardian_L1.setText(table.getValueAt(row, 1).toString());
            txtGuardian_L2.setText(table.getValueAt(row, 2).toString());
            cmdGender.setSelectedItem(table.getValueAt(row, 3).toString());
            txtPhoneNumber.setText(table.getValueAt(row, 4).toString());
            txtPhoneNumber2.setText(table.getValueAt(row, 5).toString());
            txtEmail.setText(table.getValueAt(row, 6).toString());
            txtWorkLocation.setText(table.getValueAt(row, 7).toString());
            txtAddress_L1.setText(table.getValueAt(row, 8).toString());
            txtAddress_L2.setText(table.getValueAt(row, 9).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        try {
            int row = table.getSelectedRow();
            int id = Integer.parseInt(table.getValueAt(row, 0).toString());
            gd.setGUDID(id);
            gdm.deleteGuardian(gd);
            this.clearGuardian();
            gdm.loadGuardian(table, model, txtStdNbr.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        FrmSearchGuardian f = new FrmSearchGuardian(null, rootPaneCheckingEnabled);
        f.setVisible(true);
        gd.setGuardianName(Variables.guardianName);
        gdm.loadGuardian(gd);
        txtGuardian_L1.setText(gd.getGuardianL1());
        txtGuardian_L2.setText(gd.getGuardianL2());
        cmdGender.setSelectedItem(gd.getGenderName());
        txtPhoneNumber.setText(gd.getPhone1());
        txtPhoneNumber2.setText(gd.getPhone2());
        txtEmail.setText(gd.getEmail());
        txtWorkLocation.setText(gd.getGud_Work());
        txtAddress_L1.setText(gd.getAddress());
        txtAddress_L2.setText(gd.getMoreinfo());
    }//GEN-LAST:event_btnSearchActionPerformed

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
                FrmNewStudent dialog = new FrmNewStudent(new javax.swing.JFrame(), true, null);
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
    private com.xzq.osc.JocHyperlink btnSaveG;
    private com.xzq.osc.JocHyperlink btnSearch;
    private javax.swing.JLabel btnTake;
    private javax.swing.JCheckBox chDiseases;
    private javax.swing.JCheckBox chStdStudying;
    private javax.swing.JComboBox<String> cmbBloodGroup;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbStdEthnic;
    private javax.swing.JComboBox<String> cmbStdNationality;
    private javax.swing.JComboBox<String> cmbStdPark;
    private javax.swing.JComboBox<String> cmbStdReligion;
    private javax.swing.JComboBox<String> cmbStdType;
    private javax.swing.JComboBox<String> cmdGender;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JLabel lblAddress_L1;
    private javax.swing.JLabel lblAddress_L2;
    private javax.swing.JLabel lblBloodGroup;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblGuardian_L1;
    private javax.swing.JLabel lblGuardian_L2;
    private javax.swing.JLabel lblHomeNumber;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNewStudentTitle;
    private javax.swing.JLabel lblPark;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumber2;
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
    private javax.swing.JLabel lblWorklocation;
    private com.xzq.osc.JocTabbedPane tabInfo;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAddress_L1;
    private javax.swing.JTextField txtAddress_L2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGuardianID;
    private javax.swing.JTextField txtGuardian_L1;
    private javax.swing.JTextField txtGuardian_L2;
    private javax.swing.JTextField txtHmoneNumber;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPhoneNumber2;
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
    private javax.swing.JTextField txtWorkLocation;
    // End of variables declaration//GEN-END:variables
}
