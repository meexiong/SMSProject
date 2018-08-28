/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.LabelManager;
import com.malimar.controllers.TeacherAddManager;
import com.malimar.models.TeacherAdd;
import com.malimar.utils.Border;
import com.malimar.utils.ConvertDateSQL;
import com.malimar.utils.MsgBox;
import static com.malimar.utils.ResizeScall.ResizeScall;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.bson.types.Binary;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.Date;

/**
 *
 * @author Malimar
 */
public class FrmTeacherAdd extends javax.swing.JDialog {

    /**
     * Creates new form FrmTeacherAdd
     */
    Connection c = DatabaseManagerSQL.getConnection();
    String frm, sql;
    String path;
    
    private ImageIcon format = null;
    
    HashMap<String, Object[]>mapGender = null;
    HashMap<String, Object[]>mapWorkStatus = null;
    HashMap<String, Object[]>mapClassRoom = null;
    HashMap<String, Object[]>mapInternationality= null;
    HashMap<String, Object[]>mapParkStudy= null;
    HashMap<String, Object[]>mapEthnic = null;
    HashMap<String, Object[]>mapRegion = null;
    
    TeacherAddManager tam = new TeacherAddManager();
    TeacherAdd ta = new TeacherAdd();
    
    Image ic;
    String tcID;
    String ids;
    String keySalary="";
    float sal=0;
    
    public FrmTeacherAdd(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        
        txtID.setEnabled(false);
        txtnameL1.requestFocus();
        
        txtID.setText(id);
        ids = id;
        txtID.setVisible(false);
        lblID.setVisible(false);
        txtt_nbr.setEnabled(false);
        
        Border.blueColor(btnSave);
        Border.blueColor(btnNew);
        
        lblSystemInfo.setText(LabelManager.hmapForm.get(frm.toUpperCase())[LabelManager.LN]);
        lblID.setText(LabelManager.hmapLang.get("lblID".concat(frm).toUpperCase())[LabelManager.LN]);
        lblTeachL1.setText(LabelManager.hmapLang.get("lblteachl1".concat(frm).toUpperCase())[LabelManager.LN]);
        lblTeachL2.setText(LabelManager.hmapLang.get("lblteachl2".concat(frm).toUpperCase())[LabelManager.LN]);
        lbldob.setText(LabelManager.hmapLang.get("lbldob".concat(frm).toUpperCase())[LabelManager.LN]);
        lblstartwork.setText(LabelManager.hmapLang.get("lblstartwork".concat(frm).toUpperCase())[LabelManager.LN]);
        lblemail.setText(LabelManager.hmapLang.get("lblemail".concat(frm).toUpperCase())[LabelManager.LN]);
        lblphone1.setText(LabelManager.hmapLang.get("lblphone1".concat(frm).toUpperCase())[LabelManager.LN]);
        lblphone2.setText(LabelManager.hmapLang.get("lblphone2".concat(frm).toUpperCase())[LabelManager.LN]);
        lblclassroom.setText(LabelManager.hmapLang.get("lblclassroom".concat(frm).toUpperCase())[LabelManager.LN]);
        lblnationality.setText(LabelManager.hmapLang.get("lblnationality".concat(frm).toUpperCase())[LabelManager.LN]);
        lblparkteach.setText(LabelManager.hmapLang.get("lblparkteach".concat(frm).toUpperCase())[LabelManager.LN]);
        lblethnic.setText(LabelManager.hmapLang.get("lblehnic".concat(frm).toUpperCase())[LabelManager.LN]);
        lblAddress.setText(LabelManager.hmapLang.get("lbladdress".concat(frm).toUpperCase())[LabelManager.LN]);
        lblRegion.setText(LabelManager.hmapLang.get("lblregion".concat(frm).toUpperCase())[LabelManager.LN]);
        lblMoreInfo.setText(LabelManager.hmapLang.get("lblmoreinfo".concat(frm).toUpperCase())[LabelManager.LN]);
        lblLeaveDate.setText(LabelManager.hmapLang.get("lblleavedate".concat(frm).toUpperCase())[LabelManager.LN]);
        cbWorking.setText(LabelManager.hmapLang.get("lblworking".concat(frm).toUpperCase())[LabelManager.LN]);
        cbTeachDaily.setText(LabelManager.hmapLang.get("lblteachdaily".concat(frm).toUpperCase())[LabelManager.LN]);
        btnSave.setText(LabelManager.hmapLang.get("btnSave".concat(frm).toUpperCase())[LabelManager.LN]);
        lblgender.setText(LabelManager.hmapLang.get("lblgender".concat(frm).toUpperCase())[LabelManager.LN]);
        lblworkstatus.setText(LabelManager.hmapLang.get("lblWorkstatus".concat(frm).toUpperCase())[LabelManager.LN]);
        btnNew.setText(LabelManager.hmapLang.get("btnNew".concat(frm).toUpperCase())[LabelManager.LN]);       
        lbltnbr.setText(LabelManager.hmapLang.get("lbltnbr".concat(frm).toUpperCase())[LabelManager.LN]);  
        cbTeacher.setText(LabelManager.hmapLang.get("cbTeacher".concat(frm).toUpperCase())[LabelManager.LN]);
        
    }
    private void getGender(){
        try {
            mapGender = tam.getMapGender();
            Map<String, Object[]> smap = new TreeMap<>(mapGender);
            cbbGender.removeAllItems();
            smap.keySet().forEach((s)->{
            cbbGender.addItem(s);
        });
            cbbGender.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbGender);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getWorkStatus(){
        try {
            mapWorkStatus = tam.getMapWorkStatus();
            Map<String, Object[]> smap = new TreeMap<>(mapWorkStatus);
            cbbworkstatus.removeAllItems();
            smap.keySet().forEach((s)->{
                cbbworkstatus.addItem(s);
            });
            cbbworkstatus.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbworkstatus);
        } catch (Exception e) {
        }
    }
    private void getClassRoom(){
        try {
            mapClassRoom = tam.getMapClassRoom();
            Map<String, Object[]>smap = new TreeMap<>(mapClassRoom);
            cbbroom.removeAllItems();
            smap.keySet().forEach((s)->{
            cbbroom.addItem(s);
            });
            cbbroom.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbroom);
            
        } catch (Exception e) {
        }
    }
    private void getNationality(){
        try {
            mapInternationality = tam.getMapNationality();
            Map<String, Object[]>smap = new TreeMap<>(mapInternationality);
            cbbNationality.removeAllItems();
            smap.keySet().forEach((s)->{
            cbbNationality.addItem(s);
            });
            cbbNationality.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbNationality);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getEthnic(){
        try {
            mapEthnic = tam.getMapEthnic();
            Map<String, Object[]> smap = new TreeMap<>(mapEthnic);
            cbbEthnic.removeAllItems();
            smap.keySet().forEach((s)->{
            cbbEthnic.addItem(s);
            });
            cbbEthnic.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbEthnic);
            
        } catch (Exception e) {
        }
    }
    private void getRegion(){
        try {
            mapRegion = tam.getMapRegion();
            Map<String, Object[]>smap = new TreeMap<>(mapRegion);
            cbbregion.removeAllItems();
            smap.keySet().forEach((s)->{
            cbbregion.addItem(s);
            });
            cbbregion.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbregion);
        } catch (Exception e) {
        }
    }
    private void showClear(){
        try {
            txtID.setText("New");
            txtt_nbr.setText("");
            txtMoreInfo.setText("");
            txtaddress.setText("");
            txtemail.setText("");
            txtnameL1.setText("");
            txtnameL2.setText("");
            txtphone1.setText("");
            txtphone2.setText("");
            lbl_image.setIcon(null);
            txtnameL1.requestFocus();
            keySalary="";
            
            dob.setDate(null);
            startwork.setDate(null);
            
            getGender();
            getWorkStatus();
            getClassRoom();
            getNationality();
            getEthnic();
            getRegion();
            
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
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblTeachL1 = new javax.swing.JLabel();
        txtnameL1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblTeachL2 = new javax.swing.JLabel();
        txtnameL2 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        lbldob = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        lblstartwork = new javax.swing.JLabel();
        startwork = new com.toedter.calendar.JDateChooser();
        lblgender = new javax.swing.JLabel();
        cbbGender = new javax.swing.JComboBox<>();
        lblworkstatus = new javax.swing.JLabel();
        cbbworkstatus = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        txtemail = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        lblphone1 = new javax.swing.JLabel();
        txtphone1 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        cbWorking = new javax.swing.JCheckBox();
        cbTeachDaily = new javax.swing.JCheckBox();
        cbTeacher = new javax.swing.JCheckBox();
        lblphone2 = new javax.swing.JLabel();
        txtphone2 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        lblclassroom = new javax.swing.JLabel();
        cbbroom = new javax.swing.JComboBox<>();
        lblnationality = new javax.swing.JLabel();
        cbbNationality = new javax.swing.JComboBox<>();
        lblethnic = new javax.swing.JLabel();
        cbbEthnic = new javax.swing.JComboBox<>();
        lblRegion = new javax.swing.JLabel();
        cbbregion = new javax.swing.JComboBox<>();
        lblLeaveDate = new javax.swing.JLabel();
        leaveDate = new com.toedter.calendar.JDateChooser();
        lblparkteach = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblMoreInfo = new javax.swing.JLabel();
        txtMoreInfo = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        btnNew = new javax.swing.JLabel();
        lbltnbr = new javax.swing.JLabel();
        txtt_nbr = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        txtMoney = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
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

        lblSystemInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblSystemInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSystemInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblSystemInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSystemInfo.setText("Teacher Add");
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
        txtID.setBorder(null);
        txtID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtID.setOpaque(false);
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

        lblTeachL1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblTeachL1.setText("TeacherName_L1");
        lblTeachL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTeachL1MouseClicked(evt);
            }
        });

        txtnameL1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtnameL1.setBorder(null);

        lblTeachL2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblTeachL2.setText("TeacherName_L2");
        lblTeachL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTeachL2MouseClicked(evt);
            }
        });

        txtnameL2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtnameL2.setBorder(null);
        txtnameL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameL2ActionPerformed(evt);
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

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 15, 255), 1, true));
        jPanel8.setLayout(new java.awt.BorderLayout());

        lbl_image.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imageMouseClicked(evt);
            }
        });
        jPanel8.add(lbl_image, java.awt.BorderLayout.CENTER);

        lbldob.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lbldob.setText("Dob");
        lbldob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldobMouseClicked(evt);
            }
        });

        dob.setDateFormatString("dd-MM-yyyy");

        lblstartwork.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblstartwork.setText("Start Work");
        lblstartwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblstartworkMouseClicked(evt);
            }
        });

        startwork.setDateFormatString("dd-MM-yyyy");

        lblgender.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblgender.setText("Gender");
        lblgender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblgenderMouseClicked(evt);
            }
        });

        cbbGender.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbGender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblworkstatus.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblworkstatus.setText("Work Status");
        lblworkstatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblworkstatusMouseClicked(evt);
            }
        });

        cbbworkstatus.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbworkstatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtemail.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtemail.setBorder(null);

        lblemail.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblemail.setText("Email");
        lblemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblemailMouseClicked(evt);
            }
        });

        lblphone1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblphone1.setText("Phone 1");
        lblphone1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblphone1MouseClicked(evt);
            }
        });

        txtphone1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtphone1.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        cbWorking.setBackground(new java.awt.Color(255, 255, 255));
        cbWorking.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbWorking.setText("Working");
        cbWorking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbWorking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbWorkingMouseClicked(evt);
            }
        });

        cbTeachDaily.setBackground(new java.awt.Color(255, 255, 255));
        cbTeachDaily.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbTeachDaily.setText("Teach Daily");
        cbTeachDaily.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbTeacher.setBackground(new java.awt.Color(255, 255, 255));
        cbTeacher.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbTeacher.setText("Teacher");
        cbTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbWorking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTeachDaily, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(cbTeacher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbWorking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTeachDaily)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTeacher)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        lblphone2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblphone2.setText("Phone 2");
        lblphone2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblphone2MouseClicked(evt);
            }
        });

        txtphone2.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtphone2.setBorder(null);

        lblclassroom.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblclassroom.setText("Class Room");
        lblclassroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblclassroomMouseClicked(evt);
            }
        });

        cbbroom.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbroom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblnationality.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblnationality.setText("Nationality");
        lblnationality.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnationalityMouseClicked(evt);
            }
        });

        cbbNationality.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbNationality.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblethnic.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblethnic.setText("Ethnic");
        lblethnic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblethnicMouseClicked(evt);
            }
        });

        cbbEthnic.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbEthnic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblRegion.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblRegion.setText("Region");
        lblRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegionMouseClicked(evt);
            }
        });

        cbbregion.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbbregion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblLeaveDate.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblLeaveDate.setText("Leave Date");
        lblLeaveDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeaveDateMouseClicked(evt);
            }
        });

        leaveDate.setDateFormatString("dd-MM-yyyy");

        lblparkteach.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblparkteach.setText("Salary");
        lblparkteach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblparkteachMouseClicked(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblAddress.setText("Address");
        lblAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddressMouseClicked(evt);
            }
        });

        txtaddress.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtaddress.setBorder(null);

        lblMoreInfo.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblMoreInfo.setText("More Info");
        lblMoreInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMoreInfoMouseClicked(evt);
            }
        });

        txtMoreInfo.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtMoreInfo.setBorder(null);

        btnNew.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNew.setText("New");
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNew.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNewMouseMoved(evt);
            }
        });
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewMouseExited(evt);
            }
        });

        lbltnbr.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lbltnbr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltnbr.setText("Number");
        lbltnbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbltnbrMouseClicked(evt);
            }
        });

        txtt_nbr.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtt_nbr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtt_nbr.setBorder(null);
        txtt_nbr.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtt_nbr.setOpaque(false);
        txtt_nbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtt_nbrMouseClicked(evt);
            }
        });
        txtt_nbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtt_nbrActionPerformed(evt);
            }
        });

        txtMoney.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        txtMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMoney.setText("0");
        txtMoney.setBorder(null);
        txtMoney.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMoneyMouseClicked(evt);
            }
        });
        txtMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoneyActionPerformed(evt);
            }
        });
        txtMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoneyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbltnbr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtt_nbr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTeachL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnameL1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTeachL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnameL2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(lbldob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(startwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblstartwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblgender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbworkstatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblworkstatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblphone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(leaveDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLeaveDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(104, 104, 104))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblphone2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbroom, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblclassroom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbregion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRegion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMoreInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbEthnic, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblethnic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbNationality, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblnationality, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblparkteach, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTeachL2)
                            .addComponent(lblTeachL1))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnameL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnameL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblID)
                        .addGap(1, 1, 1)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblphone2)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtphone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblclassroom)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbroom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(lbltnbr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblparkteach)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblnationality)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblethnic)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbEthnic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRegion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbregion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblLeaveDate))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblAddress)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblMoreInfo)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(leaveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblstartwork)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startwork, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblworkstatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbworkstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lbldob)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblgender)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txtt_nbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblemail)
                                .addGap(1, 1, 1)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblphone1)
                                .addGap(1, 1, 1)
                                .addComponent(txtphone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
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
//        this.setState(FrmMain.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked
        
    }//GEN-LAST:event_txtIDMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtnameL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameL2ActionPerformed
        
    }//GEN-LAST:event_txtnameL2ActionPerformed

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        try {
            if (txtnameL1.getText().equals("")||txtnameL2.getText().equals("")){
                MsgBox.msgError();
                return;
            }
             String workid = cbbworkstatus.getSelectedItem().toString();
             String clsid = cbbroom.getSelectedItem().toString();
             String ntid = cbbNationality.getSelectedItem().toString();
             String etid = cbbEthnic.getSelectedItem().toString();
             String reid = cbbregion.getSelectedItem().toString();            
             String genid = cbbGender.getSelectedItem().toString();
             
             
            if (txtID.getText().equals("New")){ //This is insert tbl_teacher                
                ta.setTname_l1(txtnameL1.getText());
                ta.setTname_l2(txtnameL2.getText());
                ta.setDob(ConvertDateSQL.convertUtilDateToSqlDate(dob.getDate()));
                ta.setWorkid(Integer.parseInt(mapWorkStatus.get(workid)[0].toString()));
                ta.settPhone1(txtphone1.getText());
                ta.settPhone2(txtphone2.getText());
                ta.settEmail(txtemail.getText());
                ta.setGenid(Integer.parseInt(mapGender.get(genid)[0].toString()));
                ta.setCLSID(Integer.parseInt(mapClassRoom.get(clsid)[0].toString()));
                ta.setNtid(Integer.parseInt(mapInternationality.get(ntid)[0].toString()));
                ta.setEtid(Integer.parseInt(mapEthnic.get(etid)[0].toString()));
                ta.setReid(Integer.parseInt(mapRegion.get(reid)[0].toString()));
                
                ta.setSalary(sal);
                //ta.setSalary(Float.parseFloat(txtMoney.getText()));
                
                if (cbTeacher.isSelected()==true){
                    ta.setTeacher(true);
                }else{
                    ta.setTeacher(false);
                }
                
                ta.setPath(path);
                ta.setT_address(txtaddress.getText());
                ta.settDailyTeach(cbTeachDaily.isSelected());
                ta.setTeacher(cbTeacher.isSelected());
                ta.settWorking(cbWorking.isSelected());
                ta.setT_Startdate(ConvertDateSQL.convertUtilDateToSqlDate(startwork.getDate()));                
                ta.setT_EndDate(ConvertDateSQL.convertUtilDateToSqlDate(leaveDate.getDate()));               
                ta.setT_moreinfo(txtMoreInfo.getText()); 
                tam.insertTeacher(ta);
                tam.showT_Nbr(ta, txtnameL1.getText());                
                txtt_nbr.setText(ta.getT_nbr());
                
                
            }else{
                ta.setTeid(Integer.parseInt(txtID.getText()));
                ta.setTname_l1(txtnameL1.getText());
                ta.setTname_l2(txtnameL2.getText());
                ta.setDob(ConvertDateSQL.convertUtilDateToSqlDate(dob.getDate()));
                ta.setWorkid(Integer.parseInt(mapWorkStatus.get(workid)[0].toString()));
                ta.settPhone1(txtphone1.getText());
                ta.settPhone2(txtphone2.getText());
                ta.settEmail(txtemail.getText());
                ta.setGenid(Integer.parseInt(mapGender.get(genid)[0].toString()));                
                ta.setCLSID(Integer.parseInt(mapClassRoom.get(clsid)[0].toString()));                
                ta.setNtid(Integer.parseInt(mapInternationality.get(ntid)[0].toString()));
                ta.setEtid(Integer.parseInt(mapEthnic.get(etid)[0].toString()));
                ta.setReid(Integer.parseInt(mapRegion.get(reid)[0].toString()));                
                ta.setSalary(sal);
                
                //ta.setTeacher(cbTeacher.isSelected());
                if (cbTeacher.isSelected()==true){
                    ta.setTeacher(true);
                }else{
                    ta.setTeacher(false);
                }
                
                ta.setT_address(txtaddress.getText());
                ta.settDailyTeach(cbTeachDaily.isSelected());
                ta.settWorking(cbWorking.isSelected());
                ta.setT_Startdate(ConvertDateSQL.convertUtilDateToSqlDate(startwork.getDate()));                
                ta.setT_EndDate(ConvertDateSQL.convertUtilDateToSqlDate(leaveDate.getDate()));               
                ta.setT_moreinfo(txtMoreInfo.getText());                
                tam.updateTeacherAdd(ta);                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited

    }//GEN-LAST:event_btnSaveMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {  
            getGender();
            getWorkStatus();
            getClassRoom();
            getNationality();
            getEthnic();
            getRegion();
            
            if (txtID.getText().equals("New")){
                
            }else{
                //this is         
                tam.showOpenClickTable(ta, Integer.parseInt(txtID.getText()));
                txtt_nbr.setText(ta.getT_nbr());
                txtnameL1.setText(ta.getTname_l1());
                txtnameL2.setText(ta.getTname_l2());
                txtemail.setText(ta.gettEmail());
                txtphone1.setText(ta.gettPhone1());
                txtphone2.setText(ta.gettPhone2());
                txtaddress.setText(ta.getT_address());
                txtMoreInfo.setText(ta.getT_moreinfo());
                cbWorking.setSelected(ta.gettWorking());
                cbTeachDaily.setSelected(ta.gettDailyTeach());
                dob.setDate(ta.getDob());
                startwork.setDate(ta.getT_Startdate());
                leaveDate.setDate(ta.getT_EndDate());                
                cbbEthnic.setSelectedItem(ta.getEthnicname());
                cbbGender.setSelectedItem(ta.getGendername());
                cbbNationality.setSelectedItem(ta.getNationalityname());
                cbbregion.setSelectedItem(ta.getRename());
                cbbroom.setSelectedItem(ta.getClassroom());
                cbbworkstatus.setSelectedItem(ta.getWorkingname());
                
                DecimalFormat df = new DecimalFormat("##,###");
                txtMoney.setText(String.valueOf(df.format(ta.getSalary())));                
                sal = ta.getSalary();
                
                cbTeacher.setSelected(ta.getTeacher());
                
                ImageIcon format =null;
                format = new ImageIcon(ta.getImageB());
                Image ic = format.getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_DEFAULT);
                lbl_image.setIcon(new ImageIcon(ic));
                
            }
            
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void lbl_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imageMouseClicked
         try {
             
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            path = choose.getSelectedFile().getAbsolutePath();            
            Image img = new ImageIcon(path).getImage();
            ic = ResizeScall(img, lbl_image.getWidth(), lbl_image.getHeight());
            lbl_image.setIcon(new ImageIcon(ic));  
            
            if (txtID.getText().equals("New")){
                
            }else{                
                ta.setTeid(Integer.parseInt(txtID.getText().trim()));
                ta.setPath(path);
                tam.updateImageTeacherAdd(ta);               
            }
            
        } catch (Exception e) {
           // e.printStackTrace();
        }
    }//GEN-LAST:event_lbl_imageMouseClicked

    private void btnNewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewMouseMoved

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("btnNew", frm);
            }else{
                showClear();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnNewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewMouseExited

    private void txtt_nbrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtt_nbrMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtt_nbrMouseClicked

    private void txtt_nbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtt_nbrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtt_nbrActionPerformed

    private void lblIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIDMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblID", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblIDMouseClicked

    private void lblTeachL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTeachL1MouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblTeachL1", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblTeachL1MouseClicked

    private void lblTeachL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTeachL2MouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblteachL2", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblTeachL2MouseClicked

    private void lbltnbrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltnbrMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lbltnbr", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lbltnbrMouseClicked

    private void lbldobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldobMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lbldob", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lbldobMouseClicked

    private void lblstartworkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblstartworkMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblstartwork", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblstartworkMouseClicked

    private void lblgenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblgenderMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblgender", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblgenderMouseClicked

    private void lblworkstatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblworkstatusMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblworkstatus", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblworkstatusMouseClicked

    private void lblemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblemailMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblemail", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblemailMouseClicked

    private void lblphone1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblphone1MouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblphone1", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblphone1MouseClicked

    private void lblphone2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblphone2MouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblphone2", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblphone2MouseClicked

    private void lblclassroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblclassroomMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblclassroom", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblclassroomMouseClicked

    private void lblnationalityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnationalityMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblnationality", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblnationalityMouseClicked

    private void lblparkteachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblparkteachMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblparkteach", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblparkteachMouseClicked

    private void lblethnicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblethnicMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblethnic", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblethnicMouseClicked

    private void lblAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddressMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblAddress", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblAddressMouseClicked

    private void lblRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegionMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblregion", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblRegionMouseClicked

    private void lblMoreInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoreInfoMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblMoreinfo", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblMoreInfoMouseClicked

    private void lblLeaveDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeaveDateMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblLeaveDate", frm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblLeaveDateMouseClicked

    private void cbWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbWorkingMouseClicked
        try {
            if (evt.getModifiers()==6){
                LabelManager.WindowChangeLabel("lblworking", frm);
            }else{
                cbWorking.isSelected();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbWorkingMouseClicked

    private void txtMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoneyKeyReleased
      
    }//GEN-LAST:event_txtMoneyKeyReleased

    private void txtMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoneyActionPerformed
        try {
//            DecimalFormat df = new DecimalFormat("##,###");
//            keySalary = txtMoney.getText();             
//            float x1 = Float.parseFloat(txtMoney.getText());            
//            String x = df.format(x1);
//            txtMoney.setText(x);
            if (txtMoney.getText().equals("")){
                txtMoney.setText("0");
            }else{
                sal = Float.parseFloat(txtMoney.getText().replace(",", ""));
                float x = Float.parseFloat(txtMoney.getText().replace(",", ""));
                txtMoney.setText(String.valueOf(String.format("%,.0f", x)));
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtMoneyActionPerformed

    private void txtMoneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMoneyMouseClicked
        try {
            txtMoney.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtMoneyMouseClicked

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
            java.util.logging.Logger.getLogger(FrmTeacherAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTeacherAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTeacherAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTeacherAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmTeacherAdd dialog = new FrmTeacherAdd(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnNew;
    private javax.swing.JLabel btnSave;
    private javax.swing.JCheckBox cbTeachDaily;
    private javax.swing.JCheckBox cbTeacher;
    private javax.swing.JCheckBox cbWorking;
    private javax.swing.JComboBox<String> cbbEthnic;
    private javax.swing.JComboBox<String> cbbGender;
    private javax.swing.JComboBox<String> cbbNationality;
    private javax.swing.JComboBox<String> cbbregion;
    private javax.swing.JComboBox<String> cbbroom;
    private javax.swing.JComboBox<String> cbbworkstatus;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLeaveDate;
    private javax.swing.JLabel lblMoreInfo;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblSystemInfo;
    private javax.swing.JLabel lblTeachL1;
    private javax.swing.JLabel lblTeachL2;
    public static javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lblclassroom;
    private javax.swing.JLabel lbldob;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblethnic;
    private javax.swing.JLabel lblgender;
    private javax.swing.JLabel lblnationality;
    private javax.swing.JLabel lblparkteach;
    private javax.swing.JLabel lblphone1;
    private javax.swing.JLabel lblphone2;
    private javax.swing.JLabel lblstartwork;
    private javax.swing.JLabel lbltnbr;
    private javax.swing.JLabel lblworkstatus;
    private com.toedter.calendar.JDateChooser leaveDate;
    private com.toedter.calendar.JDateChooser startwork;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMoney;
    private javax.swing.JTextField txtMoreInfo;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnameL1;
    private javax.swing.JTextField txtnameL2;
    private javax.swing.JTextField txtphone1;
    private javax.swing.JTextField txtphone2;
    private javax.swing.JTextField txtt_nbr;
    // End of variables declaration//GEN-END:variables
}
