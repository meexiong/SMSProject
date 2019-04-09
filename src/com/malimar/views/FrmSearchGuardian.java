package com.malimar.views;

import com.malimar.controllers.DatabaseManagerSQL;
import com.malimar.controllers.LabelManager;
import static com.malimar.controllers.LabelManager.LN;
import static com.malimar.controllers.LabelManager.WindowChangeLabel;
import static com.malimar.controllers.LabelManager.hmapLang;
import com.malimar.utils.ClearTable;
import com.malimar.utils.Variables;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FrmSearchGuardian extends javax.swing.JDialog {

    Connection c = DatabaseManagerSQL.getConnection();
    String frm;
    DefaultTableModel model = new DefaultTableModel();

    public FrmSearchGuardian(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        model = (DefaultTableModel) table.getModel();
        table.getTableHeader().setFont(new Font("Saysettha OT", Font.PLAIN, 12));
        changeLabel();
        load();
    }

    private void changeLabel() {
        lblSearchGuardian.setText(hmapLang.get("lblSearchGuardian".concat(frm).toUpperCase())[LN]);
        lblSearch.setText(hmapLang.get("lblSearch".concat(frm).toUpperCase())[LN]);
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        table.getColumnCount();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(hmapLang.get(table.getModel().getColumnName(i).concat(frm).toUpperCase())[LN]);
        }
        table.setAutoCreateRowSorter(true);
        th.repaint();
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.getTableHeader().setBackground(Color.decode("#4169E1"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
    }

    private void load() {
        try {
            ClearTable.clearFirstLoad(table, model);
            String query = "SELECT dbo.tbl_Guardian.GUD_Name_" + LabelManager.LangType + " as GuardianName, \n"
                    + "dbo.tbl_Gender.Gen_" + LabelManager.LangType + " as sex, dbo.tbl_Guardian.GUD_Phone1, dbo.tbl_Guardian.GUD_Address_" + LabelManager.LangType + " as Gaddress\n"
                    + "FROM dbo.tbl_Gender INNER JOIN\n"
                    + "dbo.tbl_Guardian ON dbo.tbl_Gender.Genid = dbo.tbl_Guardian.Genid \n"
                    + "group by dbo.tbl_Guardian.GUD_Name_" + LabelManager.LangType + ",dbo.tbl_Gender.Gen_" + LabelManager.LangType + ", dbo.tbl_Guardian.GUD_Phone1, dbo.tbl_Guardian.GUD_Address_" + LabelManager.LangType + "";
            ResultSet rs = c.createStatement().executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("GuardianName");
                String sex = rs.getString("Sex");
                String phone = rs.getString("GUD_Phone1");
                String address = rs.getString("Gaddress");
                Object[] obj = new Object[]{name, sex, phone, address};
                model.addRow(obj);
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void find() {
        try {
            ClearTable.clearFirstLoad(table, model);
            String query = "SELECT dbo.tbl_Guardian.GUD_Name_" + LabelManager.LangType + " as GuardianName, \n"
                    + "dbo.tbl_Gender.Gen_" + LabelManager.LangType + " as sex, dbo.tbl_Guardian.GUD_Phone1, dbo.tbl_Guardian.GUD_Address_" + LabelManager.LangType + " as Gaddress\n"
                    + "FROM dbo.tbl_Gender INNER JOIN\n"
                    + "dbo.tbl_Guardian ON dbo.tbl_Gender.Genid = dbo.tbl_Guardian.Genid where dbo.tbl_Guardian.GUD_Name_" + LabelManager.LangType + " like N'%" + txtSearch.getText() + "%' \n"
                    + "or dbo.tbl_Guardian.GUD_Phone1 = '" + txtSearch.getText() + "' \n"
                    + "group by dbo.tbl_Guardian.GUD_Name_" + LabelManager.LangType + ",dbo.tbl_Gender.Gen_" + LabelManager.LangType + ", dbo.tbl_Guardian.GUD_Phone1, dbo.tbl_Guardian.GUD_Address_" + LabelManager.LangType + "";
            ResultSet rs = c.createStatement().executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("GuardianName");
                String sex = rs.getString("Sex");
                String phone = rs.getString("GUD_Phone1");
                String address = rs.getString("Gaddress");
                Object[] obj = new Object[]{name, sex, phone, address};
                model.addRow(obj);
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblSearchGuardian = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

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

        lblSearchGuardian.setBackground(new java.awt.Color(255, 255, 255));
        lblSearchGuardian.setFont(new java.awt.Font("Saysettha OT", 1, 12)); // NOI18N
        lblSearchGuardian.setForeground(new java.awt.Color(0, 15, 255));
        lblSearchGuardian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchGuardian.setText("Search Guardian");
        lblSearchGuardian.setOpaque(true);
        jPanel6.add(lblSearchGuardian, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
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

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N

        table.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "lblGuardianName", "lblGender", "lblPhone", "lbladdress"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setSelectionForeground(java.awt.Color.red);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(200);
            table.getColumnModel().getColumn(0).setMaxWidth(200);
            table.getColumnModel().getColumn(1).setMinWidth(70);
            table.getColumnModel().getColumn(1).setMaxWidth(70);
            table.getColumnModel().getColumn(2).setMinWidth(120);
            table.getColumnModel().getColumn(2).setMaxWidth(120);
            table.getColumnModel().getColumn(3).setMinWidth(410);
            table.getColumnModel().getColumn(3).setMaxWidth(410);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblSearch.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        lblSearch.setText("Search");
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(160, 160, 160)));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                int row = table.getSelectedRow();
                Variables.guardianName = table.getValueAt(row, 0).toString().trim();
                this.dispose();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tableMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (txtSearch.getText().isEmpty()) {
            load();
        } else {
            find();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        if (evt.getModifiers() == 6) {
            WindowChangeLabel("lblSearch", frm);
        }
    }//GEN-LAST:event_lblSearchMouseClicked

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
            java.util.logging.Logger.getLogger(FrmSearchGuardian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSearchGuardian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSearchGuardian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSearchGuardian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmSearchGuardian dialog = new FrmSearchGuardian(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearchGuardian;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
