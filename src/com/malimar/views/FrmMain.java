
package com.malimar.views;

import com.malimar.controllers.DatabaseManagerAccess;
import com.malimar.controllers.LabelManager;
import static com.malimar.controllers.LabelManager.LN;
import com.malimar.controllers.LoginManager;
import com.malimar.utils.Border;
import static com.malimar.controllers.LabelManager.LangType;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.utils.SetText;
import com.malimar.utils.MenuSlide;
import com.malimar.utils.MsgBox;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author Malimar
 */
public class FrmMain extends javax.swing.JFrame {
DatabaseManagerAccess am = new DatabaseManagerAccess();
    String frm;
    public FrmMain() {
        initComponents();
        frm = this.getClass().getSimpleName();
        //this.setExtendedState(FrmMain.MAXIMIZED_BOTH);
//        jPanel5.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel5.setLayout( new GridBagLayout() );
        jPanel5.add(jPanel6, new GridBagConstraints());
        radLao.setSelected(true);
        beforeLogin();
        langLao();
        this.txtUserName.setText(am.getUserLogin());
        txtPassword.requestFocus();
    }
    private void beforeLogin() {
        SetText.disableLabel(Menu);
        SetText.setVisibleFalse(btnRegister);
        SetText.setVisibleFalse(btnStudentInfo);
        SetText.setVisibleFalse(btnPayment);
        SetText.setVisibleFalse(btnTeacher);
        SetText.setVisibleFalse(btnExam);
        SetText.setVisibleFalse(btnScore);
        SetText.setVisibleFalse(lblRegistation);
        SetText.setVisibleFalse(lblStudentInfo);
        SetText.setVisibleFalse(lblPayment);
        SetText.setVisibleFalse(lblTeacher);
        SetText.setVisibleFalse(lblExam);
        SetText.setVisibleFalse(lblReport);
        SetText.setVisibleFalse(lblScore);
        SetText.setVisibleFalse(lblReport);
        SetText.setVisibleFalse(lblSettingUser);
        SetText.setVisibleFalse(btnReport);
        SetText.setVisibleFalse(btnSetting);
        txtUserName.setVisible(true);
        txtPassword.setVisible(true);
        btnLogOut.setVisible(true);
        btnDatasource.setVisible(true);
        lblLoginIcon.setVisible(true);
        lblUserName.setVisible(true);
        lblIconUser.setVisible(true);
        txtsparetorName.setVisible(true);
        lblPassword.setVisible(true);
        lblSparetorPass.setVisible(true);
        lblIconPass.setVisible(true);
        btnLogOut.setVisible(true);
        btnDatasource.setVisible(true);
        txtUserName.setEnabled(true);
        txtPassword.setEnabled(true);
        btnSignUP.setEnabled(true);
        btnDatasource.setEnabled(true);
        txtUserName.setOpaque(true);
        txtPassword.setOpaque(true);
        txtPassword.setText("");
        radEnglish.setEnabled(true);
        radLao.setEnabled(true);
    }

    private void afterLogin() {
        SetText.enableLabel(Menu);
        SetText.setVisibleTrue(btnRegister);
        SetText.setVisibleTrue(btnStudentInfo);
        SetText.setVisibleTrue(btnPayment);
        SetText.setVisibleTrue(btnTeacher);
        SetText.setVisibleTrue(btnExam);
        SetText.setVisibleTrue(btnScore);
        SetText.setVisibleTrue(lblRegistation);
        SetText.setVisibleTrue(lblStudentInfo);
        SetText.setVisibleTrue(lblPayment);
        SetText.setVisibleTrue(lblTeacher);
        SetText.setVisibleTrue(lblExam);
        SetText.setVisibleTrue(lblReport);
        SetText.setVisibleTrue(lblScore);
        SetText.setVisibleTrue(lblReport);
        SetText.setVisibleTrue(lblSettingUser);
        SetText.setVisibleTrue(btnReport);
        SetText.setVisibleTrue(btnSetting);
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
        btnSignUP.setEnabled(false);
        btnDatasource.setEnabled(false);
        txtUserName.setDisabledTextColor(Color.BLACK);
        txtUserName.setBackground(Color.WHITE);
        txtUserName.setOpaque(false);
        txtPassword.setDisabledTextColor(Color.BLACK);
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setOpaque(false);
        radEnglish.setEnabled(false);
        radLao.setEnabled(false);
    }
    private void login(){
        if(radLao.isSelected()){
            LN=0;
        }else{
            LN=1;
        }
        LoginManager login = new LoginManager();
        login.setUserName(txtUserName.getText().trim());
        login.setPassword(txtPassword.getText().trim());
        if (login.verifyUser()) {
            LabelManager.getLabelLang();
            afterLogin();
            getMainLabel();
            am.saveSeasion(txtUserName.getText());
        } else {
            MsgBox.msgWarning();
        }
    }
    private void langLao(){
        lblUserName.setText("ເຂົ້າລະບົບ");
        lblPassword.setText("ລະຫັດຜ່ານ");
        lblUserName.setText("ອີເມວ");
        btnDatasource.setText("ຕັ້ງຄ່າຖານຂໍ້ມູນ");
        btnSignUP.setText("ເຂົ້າໃຊ້ລະບົບ");
        btnLogOut.setText("ອອກຈາກໃຊ້ລະບົບ");
    }
    private void langEN(){
//        lblUserName.setText("User Name");
        lblPassword.setText("Password");
        lblUserName.setText("Email");
        btnDatasource.setText("Datasource Setting");
        btnSignUP.setText("Sign Up");
        btnLogOut.setText("Logout");
    }
    private void getMainLabel(){
        lblRegistation.setText(hmapLang.get("lblRegistation".concat(frm).toUpperCase()) [LN]);
        lblStudentInfo.setText(hmapLang.get("lblStudentInfo".concat(frm).toUpperCase()) [LN]);
        lblPayment.setText(hmapLang.get("lblPayment".concat(frm).toUpperCase()) [LN]);
        lblTeacher.setText(hmapLang.get("lblTeacher".concat(frm).toUpperCase()) [LN]);
        lblExam.setText(hmapLang.get("lblExam".concat(frm).toUpperCase()) [LN]);
        lblScore.setText(hmapLang.get("lblScore".concat(frm).toUpperCase()) [LN]);
        lblReport.setText(hmapLang.get("lblReport".concat(frm).toUpperCase()) [LN]);
        lblSettingUser.setText(hmapLang.get("lblSettingUser".concat(frm).toUpperCase()) [LN]);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        btnMaximum = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSystemInfo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblLoginIcon = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtsparetorName = new javax.swing.JSeparator();
        lblSparetorPass = new javax.swing.JSeparator();
        lblIconUser = new javax.swing.JLabel();
        lblIconPass = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JLabel();
        btnMStudentType = new javax.swing.JLabel();
        btnMNationality = new javax.swing.JLabel();
        Menu = new javax.swing.JLabel();
        btnMReligion = new javax.swing.JLabel();
        btnMEthnic = new javax.swing.JLabel();
        btnMLevel = new javax.swing.JLabel();
        btnMClassroom = new javax.swing.JLabel();
        btnDatasource = new com.xzq.osc.JocHyperlink();
        btnSignUP = new javax.swing.JLabel();
        radLao = new javax.swing.JRadioButton();
        radEnglish = new javax.swing.JRadioButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnTeacher = new javax.swing.JLabel();
        lblTeacher = new javax.swing.JLabel();
        lblExam = new javax.swing.JLabel();
        btnExam = new javax.swing.JLabel();
        btnScore = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        btnRegister = new javax.swing.JLabel();
        lblRegistation = new javax.swing.JLabel();
        lblStudentInfo = new javax.swing.JLabel();
        btnStudentInfo = new javax.swing.JLabel();
        btnPayment = new javax.swing.JLabel();
        lblPayment = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        btnReport = new javax.swing.JLabel();
        btnSetting = new javax.swing.JLabel();
        lblSettingUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));

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

        btnMaximum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMaximum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Maximize Window_30px.png"))); // NOI18N
        btnMaximum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaximum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximumMouseClicked(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        lblSystemInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblSystemInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSystemInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblSystemInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSystemInfo.setText("School Management System");
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
                .addGap(5, 5, 5)
                .addComponent(btnMaximum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMaximum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserName.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblUserName.setText("User Name");
        jPanel3.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 382, 255, -1));

        lblLoginIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/User_100px.png"))); // NOI18N
        jPanel3.add(lblLoginIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 250, 260, 80));

        lblPassword.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblPassword.setText("Password");
        jPanel3.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 452, 255, -1));

        txtUserName.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtUserName.setBorder(null);
        txtUserName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUserName.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jPanel3.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 407, 227, -1));
        jPanel3.add(txtsparetorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 430, 255, -1));
        jPanel3.add(lblSparetorPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 500, 255, -1));

        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/User_24px.png"))); // NOI18N
        jPanel3.add(lblIconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 405, -1, -1));

        lblIconPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Key_24px.png"))); // NOI18N
        jPanel3.add(lblIconPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 475, -1, -1));

        btnLogOut.setBackground(new java.awt.Color(255, 255, 255));
        btnLogOut.setFont(new java.awt.Font("Saysettha OT", 1, 18)); // NOI18N
        btnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogOut.setText("LogOut");
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.setOpaque(true);
        btnLogOut.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLogOutMouseMoved(evt);
            }
        });
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogOutMouseExited(evt);
            }
        });
        jPanel3.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 640, 180, -1));

        btnMStudentType.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnMStudentType.setForeground(new java.awt.Color(0, 15, 255));
        btnMStudentType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMStudentType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Student Male_30px.png"))); // NOI18N
        btnMStudentType.setText("Student Type");
        btnMStudentType.setToolTipText("");
        btnMStudentType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMStudentType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMStudentTypeMouseClicked(evt);
            }
        });
        jPanel3.add(btnMStudentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 76, 130, -1));

        btnMNationality.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnMNationality.setForeground(new java.awt.Color(0, 15, 255));
        btnMNationality.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMNationality.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Flag Filled _30px.png"))); // NOI18N
        btnMNationality.setText("Nationality");
        btnMNationality.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMNationality.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMNationalityMouseClicked(evt);
            }
        });
        jPanel3.add(btnMNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 124, 130, -1));

        Menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Menu_30px.png"))); // NOI18N
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        jPanel3.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 38, -1));

        btnMReligion.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnMReligion.setForeground(new java.awt.Color(0, 15, 255));
        btnMReligion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMReligion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Pray_30px.png"))); // NOI18N
        btnMReligion.setText("Religion");
        btnMReligion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnMReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 172, 130, -1));

        btnMEthnic.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnMEthnic.setForeground(new java.awt.Color(0, 15, 255));
        btnMEthnic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMEthnic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Aztec Headdress_30px.png"))); // NOI18N
        btnMEthnic.setText("Ethnic");
        btnMEthnic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnMEthnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 220, 130, -1));

        btnMLevel.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnMLevel.setForeground(new java.awt.Color(0, 15, 255));
        btnMLevel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMLevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Level Up_30px.png"))); // NOI18N
        btnMLevel.setText("Level");
        btnMLevel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnMLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 268, 130, -1));

        btnMClassroom.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        btnMClassroom.setForeground(new java.awt.Color(0, 15, 255));
        btnMClassroom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMClassroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Classroom_30px.png"))); // NOI18N
        btnMClassroom.setText("Classroom");
        btnMClassroom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnMClassroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 316, 130, -1));

        btnDatasource.setForeground(new java.awt.Color(0, 0, 0));
        btnDatasource.setText("Datasource Setting");
        btnDatasource.setUnvisitColor(new java.awt.Color(0, 0, 0));
        btnDatasource.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        btnDatasource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatasourceActionPerformed(evt);
            }
        });
        jPanel3.add(btnDatasource, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 250, -1));

        btnSignUP.setBackground(new java.awt.Color(255, 255, 255));
        btnSignUP.setFont(new java.awt.Font("Saysettha OT", 1, 18)); // NOI18N
        btnSignUP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSignUP.setText("Sign Up");
        btnSignUP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignUP.setOpaque(true);
        btnSignUP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSignUPMouseMoved(evt);
            }
        });
        btnSignUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignUPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSignUPMouseExited(evt);
            }
        });
        jPanel3.add(btnSignUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 540, 180, -1));

        radLao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radLao);
        radLao.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        radLao.setText("ລາວ");
        radLao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radLao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radLaoActionPerformed(evt);
            }
        });
        jPanel3.add(radLao, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 70, -1));

        radEnglish.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radEnglish);
        radEnglish.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        radEnglish.setText("English");
        radEnglish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radEnglishActionPerformed(evt);
            }
        });
        jPanel3.add(radEnglish, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPassword.setBorder(null);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 479, 227, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnTeacher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Teacher Hiring_100px.png"))); // NOI18N
        btnTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTeacher.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTeacherMouseMoved(evt);
            }
        });
        btnTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTeacherMouseExited(evt);
            }
        });

        lblTeacher.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblTeacher.setForeground(new java.awt.Color(0, 15, 255));
        lblTeacher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTeacher.setText("Teacher");

        lblExam.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblExam.setForeground(new java.awt.Color(0, 15, 255));
        lblExam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExam.setText("Exam");

        btnExam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Exam_100px.png"))); // NOI18N
        btnExam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExam.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnExamMouseMoved(evt);
            }
        });
        btnExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExamMouseExited(evt);
            }
        });

        btnScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Scoreboard_100px.png"))); // NOI18N
        btnScore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnScore.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnScoreMouseMoved(evt);
            }
        });
        btnScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnScoreMouseExited(evt);
            }
        });

        lblScore.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblScore.setForeground(new java.awt.Color(0, 15, 255));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("Score");

        btnRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Student Registration_100px.png"))); // NOI18N
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegisterMouseMoved(evt);
            }
        });
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterMouseExited(evt);
            }
        });

        lblRegistation.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblRegistation.setForeground(new java.awt.Color(0, 15, 255));
        lblRegistation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistation.setText("Registation");

        lblStudentInfo.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblStudentInfo.setForeground(new java.awt.Color(0, 15, 255));
        lblStudentInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStudentInfo.setText("Student Info");

        btnStudentInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Student Male_100px.png"))); // NOI18N
        btnStudentInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudentInfo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnStudentInfoMouseMoved(evt);
            }
        });
        btnStudentInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStudentInfoMouseExited(evt);
            }
        });

        btnPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Payment History_100px.png"))); // NOI18N
        btnPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPayment.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnPaymentMouseMoved(evt);
            }
        });
        btnPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPaymentMouseExited(evt);
            }
        });

        lblPayment.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblPayment.setForeground(new java.awt.Color(0, 15, 255));
        lblPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPayment.setText("Payment");

        lblReport.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblReport.setForeground(new java.awt.Color(0, 15, 255));
        lblReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReport.setText("Report");

        btnReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Analyze_100px.png"))); // NOI18N
        btnReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReport.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReportMouseMoved(evt);
            }
        });
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportMouseExited(evt);
            }
        });

        btnSetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/malimar/icons/Add User Male_100px.png"))); // NOI18N
        btnSetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSetting.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSettingMouseMoved(evt);
            }
        });
        btnSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSettingMouseExited(evt);
            }
        });

        lblSettingUser.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSettingUser.setForeground(new java.awt.Color(0, 15, 255));
        lblSettingUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSettingUser.setText("User Login");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegistation, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStudentInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStudentInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExam, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExam, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReport, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSetting, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(lblSettingUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRegister, btnTeacher, lblRegistation, lblTeacher});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExam, btnStudentInfo, lblExam, lblStudentInfo});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPayment, btnScore, lblPayment, lblScore});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudentInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistation, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStudentInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSettingUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReport, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
int cnt=0;
    private void btnMaximumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximumMouseClicked
        
        if (cnt == 0) {
            this.setExtendedState(FrmMain.MAXIMIZED_BOTH);
            cnt++;
        } else {
            this.setExtendedState(FrmMain.NORMAL);
            cnt = 0;
        }
    }//GEN-LAST:event_btnMaximumMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(FrmMain.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseExited
        Border.WhiteColor(btnRegister);
    }//GEN-LAST:event_btnRegisterMouseExited

    private void btnRegisterMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseMoved
        Border.blueColor(btnRegister);
    }//GEN-LAST:event_btnRegisterMouseMoved

    private void btnStudentInfoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentInfoMouseMoved
        Border.blueColor(btnStudentInfo);
    }//GEN-LAST:event_btnStudentInfoMouseMoved

    private void btnPaymentMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentMouseMoved
        Border.blueColor(btnPayment);
    }//GEN-LAST:event_btnPaymentMouseMoved

    private void btnExamMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExamMouseMoved
        Border.blueColor(btnExam);
    }//GEN-LAST:event_btnExamMouseMoved

    private void btnScoreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScoreMouseMoved
        Border.blueColor(btnScore);
    }//GEN-LAST:event_btnScoreMouseMoved

    private void btnStudentInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentInfoMouseExited
        Border.WhiteColor(btnStudentInfo);
    }//GEN-LAST:event_btnStudentInfoMouseExited

    private void btnPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentMouseExited
        Border.WhiteColor(btnPayment);
    }//GEN-LAST:event_btnPaymentMouseExited

    private void btnExamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExamMouseExited
        Border.WhiteColor(btnExam);
    }//GEN-LAST:event_btnExamMouseExited

    private void btnScoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScoreMouseExited
        Border.WhiteColor(btnScore);
    }//GEN-LAST:event_btnScoreMouseExited

    private void btnTeacherMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeacherMouseExited
        Border.WhiteColor(btnTeacher);
    }//GEN-LAST:event_btnTeacherMouseExited

    private void btnTeacherMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeacherMouseMoved
        Border.blueColor(btnTeacher);
    }//GEN-LAST:event_btnTeacherMouseMoved

    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        MenuSlide.setMenu(btnMStudentType);
        MenuSlide.setMenu(btnMNationality);
        MenuSlide.setMenu(btnMLevel);
        MenuSlide.setMenu(btnMReligion);
        MenuSlide.setMenu(btnMClassroom);
        MenuSlide.setMenu(btnMEthnic);
    }//GEN-LAST:event_MenuMouseClicked

    private void btnDatasourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatasourceActionPerformed
        FrmDatasource frmDatasource = new FrmDatasource();
        frmDatasource.setVisible(true);
    }//GEN-LAST:event_btnDatasourceActionPerformed

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        radLao.setSelected(true);
        beforeLogin();
        langLao();
        this.txtUserName.setText(am.getUserLogin());
        txtPassword.requestFocus();
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnReportMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseMoved
        Border.blueColor(btnReport);
    }//GEN-LAST:event_btnReportMouseMoved

    private void btnReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseExited
        Border.WhiteColor(btnReport);
    }//GEN-LAST:event_btnReportMouseExited

    private void btnSettingMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingMouseMoved
        Border.blueColor(btnSetting);
    }//GEN-LAST:event_btnSettingMouseMoved

    private void btnSettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingMouseExited
        Border.WhiteColor(btnSetting);
    }//GEN-LAST:event_btnSettingMouseExited

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void btnSignUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignUPMouseClicked
        login();
    }//GEN-LAST:event_btnSignUPMouseClicked

    private void btnMNationalityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMNationalityMouseClicked
        FrmNationality frmNationality =  new FrmNationality();
        frmNationality.setVisible(true);
    }//GEN-LAST:event_btnMNationalityMouseClicked

    private void btnMStudentTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMStudentTypeMouseClicked
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMStudentTypeMouseClicked

    private void radLaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radLaoActionPerformed
        langLao();
        LangType="L1";

    }//GEN-LAST:event_radLaoActionPerformed

    private void radEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radEnglishActionPerformed
        langEN();
        LangType="L2";
    }//GEN-LAST:event_radEnglishActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        login();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnSignUPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignUPMouseExited
       Border.WhiteColor(btnSignUP);
    }//GEN-LAST:event_btnSignUPMouseExited

    private void btnSignUPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignUPMouseMoved
        Border.blueColor(btnSignUP);
    }//GEN-LAST:event_btnSignUPMouseMoved

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited
        Border.WhiteColor(btnLogOut);
    }//GEN-LAST:event_btnLogOutMouseExited

    private void btnLogOutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseMoved
        Border.blueColor(btnLogOut);
    }//GEN-LAST:event_btnLogOutMouseMoved

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Menu;
    private com.xzq.osc.JocHyperlink btnDatasource;
    private javax.swing.JLabel btnExam;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnLogOut;
    private javax.swing.JLabel btnMClassroom;
    private javax.swing.JLabel btnMEthnic;
    private javax.swing.JLabel btnMLevel;
    private javax.swing.JLabel btnMNationality;
    private javax.swing.JLabel btnMReligion;
    private javax.swing.JLabel btnMStudentType;
    private javax.swing.JLabel btnMaximum;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnPayment;
    private javax.swing.JLabel btnRegister;
    private javax.swing.JLabel btnReport;
    private javax.swing.JLabel btnScore;
    private javax.swing.JLabel btnSetting;
    private javax.swing.JLabel btnSignUP;
    private javax.swing.JLabel btnStudentInfo;
    private javax.swing.JLabel btnTeacher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblExam;
    private javax.swing.JLabel lblIconPass;
    private javax.swing.JLabel lblIconUser;
    private javax.swing.JLabel lblLoginIcon;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPayment;
    private javax.swing.JLabel lblRegistation;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblSettingUser;
    private javax.swing.JSeparator lblSparetorPass;
    private javax.swing.JLabel lblStudentInfo;
    private javax.swing.JLabel lblSystemInfo;
    private javax.swing.JLabel lblTeacher;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JRadioButton radEnglish;
    private javax.swing.JRadioButton radLao;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JSeparator txtsparetorName;
    // End of variables declaration//GEN-END:variables
}
